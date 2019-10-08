# creditrama-team-d
Main repository for Creditrama project

# Interfaces 
## LoginService
Ce service a pour responsabilité de gérer toute les fonctions de connexion et d'inscription

| LoginService 	| Description                                               	|
|--------------	|-----------------------------------------------------------	|
| /register    	| Permet de s'inscrire sur creditrama                       	|
| /login       	| Permet de se connecter et d'accéder à son espace bancaire 	|

## Notification
Ce service a pour responsabilité de gérer les divers services de notifications

| Notification 	| Description                                                                                        	|
|--------------	|----------------------------------------------------------------------------------------------------	|
| /notify      	| Permet de notifier le service correspondant au message d'envoyer une notification (mail, fax, sms) 	|

## MailService
Ce service a pour responsabilité de gérer les envoient de mail

| Notification 	| Description                                                                                        	|
|--------------	|----------------------------------------------------------------------------------------------------	|
| /sendMail      	| Permet d'envoyer un mail en fonction des paramètres mis en entrés	|

## BankService
Ce service a pour responsabilité de géré les opération de base d'un compte en banque

| BankService                              	| Description                                                            	|
|------------------------------------------	|------------------------------------------------------------------------	|
| /transfer/{id}                           	| Permet de transféré de l'argent a un bénificiaire                      	|
| /clients                                 	| CRUD des comptes client                                                	|
| /clients/{id}/bank/accounts              	| CRUD des comptes en banque d'un client                                 	|
| /clients/{id}/recipients                 	| CRUD des bénéficiaires d'un client                                     	|
| /clients/{id}/bank/accounts/{id}/history 	| Historique des transactions d'un comptes en banques d'un client        	|
| /clients/{id}/bank/accounts/history      	| Historique des transactions de tous les comptes en banques d'un client 	|

## CardService
Ce service a pour responsabilité de géré les opération lié au cartes bancaires

| CardService                    	| Description                 	|
|--------------------------------	|-----------------------------	|
| /clients/{id}/cards            	| CRUD des cartes clients     	|
| /clients/{id}/cards/{id}/block 	| Bloque la carte d'un client 	|
| /clients/{id}/cards/{id}/renew 	| Renouvelle une carte        	|
