/**
 * Moteur CRUD generique.
 * Chaque page Thymeleaf definit un objet "crudConfig" (colonnes, champs de formulaire,
 * url de l'API deja existante) puis appelle CrudPage.init(crudConfig).
 * Ce fichier est le seul a manipuler le DOM et les appels fetch : les pages ne font
 * que declarer leur configuration, ce qui evite de dupliquer la logique CRUD.
 */
const CrudPage = (function () {

    let config = null;
    let selectOptionsCache = {};
    let editingId = null;

    function el(id) {
        return document.getElementById(id);
    }

    function formatValue(value, type) {
        if (value === null || value === undefined || value === '') {
            return '<span class="text-muted">-</span>';
        }
        if (type === 'date') {
            const d = new Date(value);
            return Number.isNaN(d.getTime()) ? value : d.toLocaleString('fr-FR');
        }
        if (type === 'bool') {
            return value === true || value === 'true'
                ? '<span class="badge text-bg-success">Oui</span>'
                : '<span class="badge text-bg-secondary">Non</span>';
        }
        if (type === 'money') {
            const n = Number(value);
            return Number.isNaN(n) ? value : n.toLocaleString('fr-FR');
        }
        return escapeHtml(String(value));
    }

    function escapeHtml(str) {
        const d = document.createElement('div');
        d.innerText = str;
        return d.innerHTML;
    }

    function showAlert(message, type) {
        const box = el('crud-alert');
        if (!box) return;
        box.className = 'alert alert-' + (type || 'danger');
        box.textContent = message;
        box.classList.remove('d-none');
    }

    function hideAlert() {
        const box = el('crud-alert');
        if (box) box.classList.add('d-none');
    }

    function buildHead() {
        const thead = el('crud-thead-row');
        if (!thead) return;
        thead.innerHTML = '';
        config.columns.forEach(function (col) {
            const th = document.createElement('th');
            th.textContent = col.label;
            thead.appendChild(th);
        });
        if (config.idKey) {
            const th = document.createElement('th');
            th.textContent = 'Actions';
            th.style.width = '160px';
            thead.appendChild(th);
        }
    }

    function loadTable() {
        const tbody = el('crud-table-body');
        tbody.innerHTML = '<tr><td colspan="20" class="text-center text-muted py-4">Chargement...</td></tr>';
        fetch(config.apiUrl)
            .then(function (res) {
                if (!res.ok) throw new Error('Erreur de chargement (' + res.status + ')');
                return res.json();
            })
            .then(function (data) {
                renderRows(data);
            })
            .catch(function (err) {
                tbody.innerHTML = '<tr><td colspan="20" class="text-center text-danger py-4">' + escapeHtml(err.message) + '</td></tr>';
            });
    }

    function renderRows(data) {
        const tbody = el('crud-table-body');
        tbody.innerHTML = '';
        if (!data || data.length === 0) {
            const colCount = config.columns.length + (config.idKey ? 1 : 0);
            tbody.innerHTML = '<tr><td colspan="' + colCount + '" class="text-center text-muted py-4">Aucune donnee</td></tr>';
            return;
        }
        data.forEach(function (item) {
            const tr = document.createElement('tr');
            config.columns.forEach(function (col) {
                const td = document.createElement('td');
                td.innerHTML = formatValue(item[col.key], col.type);
                tr.appendChild(td);
            });
            if (config.idKey) {
                const td = document.createElement('td');
                td.innerHTML =
                    '<button type="button" class="btn btn-sm btn-outline-primary me-1 crud-edit-btn">Modifier</button>' +
                    '<button type="button" class="btn btn-sm btn-outline-danger crud-delete-btn">Supprimer</button>';
                td.querySelector('.crud-edit-btn').addEventListener('click', function () {
                    openModal('edit', item);
                });
                td.querySelector('.crud-delete-btn').addEventListener('click', function () {
                    deleteItem(item[config.idKey]);
                });
                tr.appendChild(td);
            }
            tbody.appendChild(tr);
        });
    }

    function fetchSelectOptions(field) {
        if (selectOptionsCache[field.key]) {
            return Promise.resolve(selectOptionsCache[field.key]);
        }
        return fetch(field.select.url)
            .then(function (res) { return res.json(); })
            .then(function (data) {
                selectOptionsCache[field.key] = data;
                return data;
            });
    }

    function buildFormFields(data) {
        const container = el('crud-form-fields');
        container.innerHTML = '';
        const pending = [];

        config.fields.forEach(function (field) {
            const wrapper = document.createElement('div');
            wrapper.className = 'mb-3';

            const label = document.createElement('label');
            label.className = 'form-label';
            label.textContent = field.label + (field.required ? ' *' : '');
            label.setAttribute('for', 'field-' + field.key);
            wrapper.appendChild(label);

            let input;
            if (field.type === 'select') {
                input = document.createElement('select');
                input.className = 'form-select';
                input.innerHTML = '<option value="">-- Choisir --</option>';
                pending.push(
                    fetchSelectOptions(field).then(function (options) {
                        options.forEach(function (opt) {
                            const o = document.createElement('option');
                            o.value = opt[field.select.valueKey];
                            o.textContent = field.select.labelFormat(opt);
                            input.appendChild(o);
                        });
                        if (data && data[field.key] !== undefined && data[field.key] !== null) {
                            input.value = data[field.key];
                        }
                    })
                );
            } else if (field.type === 'textarea') {
                input = document.createElement('textarea');
                input.className = 'form-control';
                input.rows = 3;
            } else if (field.type === 'bool') {
                wrapper.className = 'mb-3 form-check';
                input = document.createElement('input');
                input.type = 'checkbox';
                input.className = 'form-check-input';
                label.className = 'form-check-label';
                wrapper.innerHTML = '';
                wrapper.appendChild(input);
                wrapper.appendChild(label);
            } else {
                input = document.createElement('input');
                input.type = field.type || 'text';
                input.className = 'form-control';
                if (field.step) input.step = field.step;
            }

            input.id = 'field-' + field.key;
            input.name = field.key;
            if (field.required) input.required = true;
            if (field.placeholder) input.placeholder = field.placeholder;

            if (field.type !== 'bool') {
                wrapper.appendChild(input);
            }
            container.appendChild(wrapper);

            if (data && field.type !== 'select') {
                if (field.type === 'bool') {
                    input.checked = data[field.key] === true;
                } else if (data[field.key] !== undefined && data[field.key] !== null) {
                    input.value = data[field.key];
                }
            }
        });

        return Promise.all(pending);
    }

    function openModal(mode, data) {
        hideAlert();
        editingId = mode === 'edit' ? data[config.idKey] : null;
        el('crud-modal-title').textContent = mode === 'edit' ? 'Modifier' : 'Ajouter';
        buildFormFields(data || null).then(function () {
            const modal = new bootstrap.Modal(el('crud-modal'));
            modal.show();
        });
    }

    function collectFormData() {
        const result = {};
        config.fields.forEach(function (field) {
            const input = el('field-' + field.key);
            if (!input) return;
            if (field.type === 'bool') {
                result[field.key] = input.checked;
            } else if (field.type === 'number') {
                result[field.key] = input.value === '' ? null : Number(input.value);
            } else if (field.type === 'select') {
                result[field.key] = input.value === '' ? null : Number(input.value);
            } else {
                if (field.optionalOnEdit && editingId && input.value === '') {
                    return;
                }
                result[field.key] = input.value;
            }
        });
        return result;
    }

    function saveItem(e) {
        e.preventDefault();
        hideAlert();
        const payload = collectFormData();
        const isEdit = editingId !== null;
        

        const url = isEdit ? config.apiUrl + '/' + editingId : config.apiUrl;
        const method = isEdit ? 'PUT' : 'POST';

        fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        }).then(function (res) {
            if (!res.ok) throw new Error('Echec de l\'enregistrement (' + res.status + ')');
            return res.json().catch(function () { return null; });
        }).then(function () {
            bootstrap.Modal.getInstance(el('crud-modal')).hide();
            loadTable();
        }).catch(function (err) {
            showAlert(err.message, 'danger');
        });
    }

    function deleteItem(id) {
        if (!confirm('Confirmer la suppression ?')) return;
        fetch(config.apiUrl + '/' + id, { method: 'DELETE' })
            .then(function (res) {
                if (!res.ok) throw new Error('Echec de la suppression (' + res.status + ')');
                loadTable();
            })
            .catch(function (err) {
                alert(err.message);
            });
    }

    function init(cfg) {
        config = cfg;
        buildHead();
        loadTable();

        const addBtn = el('crud-add-btn');
        if (addBtn) {
            addBtn.addEventListener('click', function () {
                openModal('create', null);
            });
        }

        const form = el('crud-form');
        if (form) {
            form.addEventListener('submit', saveItem);
        }
    }

    return { init: init };
})();
