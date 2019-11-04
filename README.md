#Projet d'API de Renovation Man

##Contexte

Réalisation d'une API de gestion de questionnaire pour la création de projet de travaux sur Renovation Man

## Technologies utilisées

* Java 11
* Spring Boot 2
* Hibernate 5
* Mysql
* flyway pour la gestion des schémas de base
* JUnit 5

## Configuration

Pour paramètrer l'application, il faut renseigner quatre éléments : 
- le serveur de la base de données (`PROJET_RENOVATION_MAN_SERVER`)
- le nom de la base de données (`PROJET_RENOVATION_MAN_DATABASE`)
- le nom de l'utilisateur devant accèder à la base de données (`PROJET_RENOVATION_MAN_SERVER`)
- le mot de passe de l'utilisateur de la base de données (`PROJET_RENOVATION_MAN_SERVER`)

Il est possible de renseigner ces valeurs dans les variables d'environnements ou en modifiant directement le fichier `application.yml`.

## Liste des enpoints

- `GET :  /questions`   
Permet de récupérer la liste des questions et leur réponses  
- `POST : /questionnaire`  
Permet d'envoyer un questionnaire à l'API
- `GET : /questionnaire?email=***`  
Permet de récupérer la liste des questionnaires envoyés 
- `GET : /v2/api-docs`
Permet de récupérer toutes les informations concernant l'API
- `GET : /swagger-ui.html`
Permet d'afficher une page OpenApi contenant les informations de l'API

## Lancement du projet

`mvn spring-boot:run`

## Lancement des tests

`mvn test`


 



