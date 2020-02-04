# Semaine 06

## Done
- Gestion d'erreur et code avec le pattern SAGA 
- Suite tests Cypress
- Début CardService
- Verification de la transaction par mail

## Todo
- Finir intégration SAGA
- Utilisation de Postman pour les tests d'intégration
- Finir les features du CardService
- Historique des transactions

### Flag : Green

# Semaine 05

## Done
- CI/CD terminée
- Début de tests Cypress : page de login
- Erreur d'écriture en BD avec un switch on/off dans le dump
- Début de la vérification de la transaction par email
- Pattern SAGA fonctionnel simple, pas de gestion d'erreurs

## Todo
- Prendre en compte l'erreur d'écriture en BD pour le pattern SAGA
- Amélioration du fail de l'écriture en BD
- Finir la vérification de la transaction
- Début du refactor des tests Cucumber

### Flag : Green

# Semaine 04

## Done
- Recherches pour l'erreur en écriture dans la base MongoDB (piste : throw notre Exception)
- CI
- Tests unitaires sur les nouveaux services
- Avancement dans l'implémentation du pattern SAGA

## Todo 
- Implémentation de l'erreur en écriture
- CD
- Terminer le SAGA
- Ajout du token de validation
- Corriger Dump après refactor

### Flag : Yellow

# Semaine 03

## Done

- Découpage du BankService en 3 service
- Adaptation de l'IHM
- Changement (en cours) de la migration vers Tekton pour le CI/CD

## Todo 
- Résolution de bug lié au refactor .
- Pipeline CI/CD complete
- Ameilioration du pattern SAGA dans les Transactions
- Ajout du token de validation

### Flag : Yellow

# Semaine 45

## Done

- Tests Services Angular
- Des tests Cucumber
- Instant Pretty Dump
- Amélioration IHM

## Todo

- Préparer les slides
- Ajout de fonctionnalités liées aux bénéficiaires (eg. suppression) et aux comptes bancaires (eg. gestion de plusieurs comptes bancaires)

### Flag : Green

# Semaine 44

## Done

- Intégration des fonctionnalités de bénéficiaires et de transferts dans le front
- Projet d'intégration avec Cucumber
- Dockerisation

## Todo

- Préparation de la démonstration
- Préparer la carte bancaire
- Tests services Angular
- Gestion de la contrainte géographique pour Docker
- Instant Pretty Dump

### Flag : Green

# Semaine 43

## Done

- Fin de la logique de connexion
- Formalisation des isssues sur le Kanban
- Intégration de kafka et des mails de notification
- Backend bénéficiaires et transferts
- Intégration Login et Bank
- Intégration Login et Notification 
- Intégration en cours de Notification et de Bank
- Commencer template email

## Todo

- Projet d'intégration avec Cucumber
- Intégration des fonctionnalités de bénéficiaires et de transferts dans le front
- Mettre en place les différents types de notification
- Lier les templates avec les notifications

### Flag : Green

# Semaine 42

## Done

- Implémentation du service de login avec le OAuth
- BankService, comptes bancaires et montant du compte
- Bus kafka pour les notifications, envoie de mails ok
- Intégration avec le front en cours
- Partie DevOps : pipelines Jenkins

## Todo

- Projet d'intégration avec Cucumber
- Finaliser logique de connexion
- Intégration les services de Login Bank et Notification
- Template de mails

### Flag : Green

# Semaine 41

## Done

- Mise en place des repos.
- Discussions par rapport au feedback du premier rendu.
- Légères modifications pour le périmètre global (eg. importance de la carte).

## Todo 

- Formaliser le rendu pour mercredi (diagramme de composants et roadmap)

# Semaine 40

## Done

- Définition et écrire du périmètre du projet.
- Premier diagramme d'architecture pour notre MVP.

## Todo 

- Mise en place des repos.
- Début du développement des modules spécifiés en tant que MVP.
- Setup de la partie DevOps (Intégration Continue avec Jenkins X et Nexus).

