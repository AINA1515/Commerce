-- USER 

create table if not exists role (
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists utilisateur (
    id integer primary key autoincrement,
    nom text not null,
    prenom text not null,
    email text unique,
    id_role integer not null references role(id),
    mot_de_passe text not null,
    date_creation timestamp default current_timestamp
);

-- PRODUIT

create table if not exists type_produit (
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists produit (
    id integer primary key autoincrement,
    nom text not null,
    description text,
    id_type_produit integer not null references type_produit(id),
    stock_minimum integer not null,
    date_creation timestamp default current_timestamp
);


-- STOCK

create table if not exists stock_produit (
    id integer primary key autoincrement,
    id_produit integer not null references produit(id),
    prix_achat real not null,
    prix_vente real not null,
    quantite_stock integer not null,
    date_modification timestamp default current_timestamp
);

create table if not exists type_transation_stock (
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists journal_stock (
    id integer primary key autoincrement,
    id_produit integer not null references produit(id),
    id_type_transaction_stock integer not null references type_transation_stock(id),
    quantite integer not null,
    id_utilisateur integer not null references utilisateur(id),
    date_modification timestamp default current_timestamp
);

-- FOURNISSEUR

create table if not exists fournisseur (
    id integer primary key autoincrement,
    nom text not null,
    prenom text not null,
    email text unique,
    telephone text not null,
    adresse text not null,
    date_creation timestamp default current_timestamp
);

create table if not exists type_transaction_fournisseur (
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists transaction_fournisseur (
    id integer primary key autoincrement,
    id_type_transaction_fournisseur integer not null references type_transaction_fournisseur(id),
    id_utilisateur integer not null references utilisateur(id),
    montantTotal real not null,
    date_modification timestamp default current_timestamp
);

create table if not exists transaction_fournisseur_ligne (
    id integer primary key autoincrement,
    id_fournisseur integer not null references fournisseur(id),
    id_transaction_fournisseur integer not null references transaction_fournisseur(id),
    id_produit integer not null references produit(id),
    quantite integer not null,
    montant real not null,
    date_modification timestamp default current_timestamp
);

-- CLIENT

create table if not exists client (
    id integer primary key autoincrement,
    nom text not null,
    prenom text not null,
    email text unique,
    telephone text not null,
    date_creation timestamp default current_timestamp
);

-- COMMANDE CLIENT

create table if not exists type_payement (
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists type_transaction_commande (
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists status_commande (
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists commande(
    id integer primary key autoincrement,
    prix_total real not null,
    id_type_transaction_commande integer not null references type_transaction_commande(id),
    id_utilisateur integer not null references utilisateur(id),
    id_client integer not NULL REFERENCES client(id),
    montant_payee real not NULL,
    date_modification timestamp default current_timestamp
);

create table if not exists status_ligne_commande (
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists ligne_commande(
    id integer primary key autoincrement,
    id_commande integer not null references commande(id),
    id_produit integer not null references produit(id),
    quantite integer not null,
    id_status_ligne_commande integer not null references status_ligne_commande(id),
    montant_payee real not NULL,
    date_modification timestamp default current_timestamp,
    prix real not null
);

create table if not exists payement(
    id integer primary key autoincrement,
    id_ligne_commande integer not null references ligne_commande(id),
    id_type_payement integer not null references type_payement(id),
    montant real not null,
    date_modification timestamp default current_timestamp
);

create table if not exists journal_commande(
    id INTEGER PRIMARY KEY autoincrement,
    id_commande INTEGER not NULL REFERENCES commande(id),
    id_utilisateur INTEGER NOT NULL REFERENCES utilisateur(id),
    id_client INTEGER not NULL REFERENCES client(id),
    montant_total REAL not NULL,
    montant_payee real not NULL
);

create table if not exists journal_commande_fille(
    id INTEGER PRIMARY KEY autoincrement,
    id_ligne_commande INTEGER not NULL REFERENCES ligne_commande(id),
    id_utilisateur INTEGER NOT NULL REFERENCES utilisateur(id),
    id_client INTEGER not NULL REFERENCES client(id),
    montant_total REAL not NULL,
    montant_payee real not NULL
);

-- REMISE

create table if not exists remise(
    id integer primary key autoincrement,
    id_utilisateur int not null REFERENCES utilisateur(id),
    id_produit integer not null references produit(id),
    pourcentage real not null,
    date_debut timestamp not null,
    date_fin timestamp not null,
    disponiblite BOOLEAN not NULL
);

create table if not exists type_changement_remise(
    id INTEGER PRIMARY key autoincrement,
    nom TEXT not null
);

create table if not exists historique_remise(
    id INTEGER PRIMARY KEY autoincrement,
    id_utilisateur integer not null REFERENCES utilisateur(id),
    pourcentage real not NULL,
    date_retour TIMESTAMP not null,
    date_fin TIMESTAMP not NULL,
    disponibilite BOOLEAN not null,
    id_type_changement INTEGER not NULL REFERENCES type_changement_remise(id)
);

-- SOLDE

create table if not exists caisse (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    solde REAL NOT NULL,
    date_modification TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- DEPENSE

create table if not exists type_depense(
    id integer primary key autoincrement,
    nom text not null
);

create table if not exists historique_depense(
    id integer primary key autoincrement,
    id_utilisateur integer not null references utilisateur(id),
    id_type_depense integer not null references type_depense(id),
    montant real not null,
    description text,
    date_creation timestamp default current_timestamp
);