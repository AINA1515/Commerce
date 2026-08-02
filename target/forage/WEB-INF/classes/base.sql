create database commerce;
use commerce;

-- USER 

create table role (
    id integer primary key autoincrement,
    nom text not null
);

create table utilisateur (
    id integer primary key autoincrement,
    nom text not null,
    prenom text not null,
    email text unique,
    id_role integer not null references role(id),
    mot_de_passe text not null,
    date_creation timestamp default current_timestamp
);

-- PRODUIT

create table type_produit (
    id integer primary key autoincrement,
    nom text not null
);

create table produit (
    id integer primary key autoincrement,
    nom text not null,
    description text,
    id_type_produit integer not null references type_produit(id),
    stock_minimum integer not null,
    date_creation timestamp default current_timestamp
);


-- STOCK

create table stock_produit (
    id integer primary key autoincrement,
    id_produit integer not null references produit(id),
    prix_achat real not null,
    prix_vente real not null,
    quantite_stock integer not null,
    date_modification timestamp default current_timestamp
);

create table type_transation_stock (
    id integer primary key autoincrement,
    nom text not null
);

create table journal_stock (
    id integer primary key autoincrement,
    id_produit integer not null references produit(id),
    id_type_transaction_stock integer not null references type_transation_stock(id),
    quantite integer not null,
    id_utilisateur integer not null references utilisateur(id),
    date_modification timestamp default current_timestamp
);

-- FOURNISSEUR

create table fournisseur (
    id integer primary key autoincrement,
    nom text not null,
    prenom text not null,
    email text unique,
    telephone text not null,
    adresse text not null,
    date_creation timestamp default current_timestamp
);

create table type_transaction_fournisseur (
    id integer primary key autoincrement,
    nom text not null
);

create table transaction_fournisseur (
    id integer primary key autoincrement,
    id_type_transaction_fournisseur integer not null references type_transaction_fournisseur(id),
    id_utilisateur integer not null references utilisateur(id),
    montantTotal real not null,
    date_modification timestamp default current_timestamp
);

create table transaction_fournisseur_ligne (
    id integer primary key autoincrement,
    id_fournisseur integer not null references fournisseur(id),
    id_transaction_fournisseur integer not null references transaction_fournisseur(id),
    id_produit integer not null references produit(id),
    quantite integer not null,
    montant real not null,
    date_modification timestamp default current_timestamp
);

-- CLIENT

create table client (
    id integer primary key autoincrement,
    nom text not null,
    prenom text not null,
    email text unique,
    telephone text not null,
    date_creation timestamp default current_timestamp
);

-- COMMANDE CLIENT

create table type_payement (
    id integer primary key autoincrement,
    nom text not null
);

create table type_transaction_commande (
    id integer primary key autoincrement,
    nom text not null
);

create table status_commande (
    id integer primary key autoincrement,
    nom text not null
);

create table commande(
    id integer primary key autoincrement,
    prix_total real not null,
    id_type_transaction_commande integer not null references type_transaction_commande(id),
    id_utilisateur integer not null references utilisateur(id),
    id_client integer not NULL REFERENCES client(id),
    montant_payee real not NULL,
    date_modification timestamp default current_timestamp
);

create table status_ligne_commande (
    id integer primary key autoincrement,
    nom text not null
);

create table ligne_commande(
    id integer primary key autoincrement,
    id_commande integer not null references commande(id),
    id_produit integer not null references produit(id),
    quantite integer not null,
    id_status_ligne_commande integer not null references status_ligne_commande(id),
    montant_payee real not NULL,
    date_modification timestamp default current_timestamp,
    prix real not null
);

create table payement(
    id integer primary key autoincrement,
    id_ligne_commande integer not null references ligne_commande(id),
    id_type_payement integer not null references type_payement(id),
    montant real not null,
    date_modification timestamp default current_timestamp
);

create table journal_commande(
    id INTEGER PRIMARY KEY autoincrement,
    id_commande INTEGER not NULL REFERENCES commande(id),
    id_utilisateur INTEGER NOT NULL REFERENCES utilisateur(id),
    id_client INTEGER not NULL REFERENCES client(id),
    montant_total REAL not NULL,
    montant_payee real not NULL,
);

create table journal_commande_fille(
    id INTEGER PRIMARY KEY autoincrement,
    id_ligne_commande INTEGER not NULL REFERENCES ligne_commande(id),
    id_utilisateur INTEGER NOT NULL REFERENCES utilisateur(id),
    id_client INTEGER not NULL REFERENCES client(id),
    montant_total REAL not NULL,
    montant_payee real not NULL
);

-- REMISE

create table remise(
    id integer primary key autoincrement,
    id_utilisateur int not null REFERENCES utilisateur(id),
    id_produit integer not null references produit(id),
    pourcentage real not null,
    date_debut timestamp not null,
    date_fin timestamp not null,
    disponiblite BOOLEAN not NULL
);

create table type_changement_remise(
    id INTEGER PRIMARY key autoincrement,
    nom TEXT not null
);

create table historique_remise(
    id INTEGER PRIMARY KEY autoincrement,
    id_utilisateur integer not null REFERENCES utilisateur(id),
    pourcentage real not NULL,
    date_retour TIMESTAMP not null,
    date_fin TIMESTAMP not NULL,
    disponibilite BOOLEAN not null,
    id_type_changement INTEGER not NULL REFERENCES type_changement_remise(id)
);

-- SOLDE

create table caisse (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    solde REAL NOT NULL,
    date_modification TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- DEPENSE

create table type_depense(
    id integer primary key autoincrement,
    nom text not null
);

create table historique_depense(
    id integer primary key autoincrement,
    id_utilisateur integer not null references utilisateur(id),
    id_type_depense integer not null references type_depense(id),
    montant real not null,
    description text,
    date_creation timestamp default current_timestamp
);