-- ============================================
-- DONNÉES DE BASE
-- ============================================

-- ROLES
INSERT INTO role (nom) VALUES
('ADMIN'),
('VENDEUR'),
('CAISSIER'),
('MANAGER');


-- TYPES DE PRODUITS
INSERT INTO type_produit (nom) VALUES
('Alimentaire'),
('Boisson'),
('Électronique'),
('Vêtement'),
('Hygiène'),
('Ménager');


-- TYPES DE TRANSACTION STOCK
INSERT INTO type_transation_stock (nom) VALUES
('ENTREE'),
('SORTIE'),
('AJUSTEMENT');

-- TYPES DE TRANSACTION FOURNISSEUR
INSERT INTO type_transaction_fournisseur (nom) VALUES
('ACHAT'),
('RETOUR'),
('AVOIR');

-- TYPES DE PAIEMENT
INSERT INTO type_payement (nom) VALUES
('ESPECES'),
('CARTE BANCAIRE'),
('MOBILE MONEY'),
('CHEQUE');

-- TYPES DE TRANSACTION COMMANDE
INSERT INTO type_transaction_commande (nom) VALUES
('VENTE'),
('RETOUR'),
('AVOIR');

-- STATUTS COMMANDE
INSERT INTO status_commande (nom) VALUES
('EN ATTENTE'),
('CONFIRMEE'),
('EN PREPARATION'),
('EXPEDIEE'),
('LIVREE'),
('ANNULEE');

-- STATUTS LIGNE COMMANDE
INSERT INTO status_ligne_commande (nom) VALUES
('EN ATTENTE'),
('PAYEE'),
('PARTIELLEMENT PAYEE'),
('ANNULEE');

-- TYPES DE CHANGEMENT REMISE
INSERT INTO type_changement_remise (nom) VALUES
('CREATION'),
('MODIFICATION'),
('SUPPRESSION');

-- TYPES DE DEPENSE
INSERT INTO type_depense (nom) VALUES
('LOYER'),
('SALAIRE'),
('ELECTRICITE'),
('EAU'),
('TRANSPORT'),
('MAINTENANCE'),
('AUTRE');

-- CAISSE (solde initial)
INSERT INTO caisse (solde) VALUES (0);