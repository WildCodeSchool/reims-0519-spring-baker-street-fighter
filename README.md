# reims-0519-spring-baker-street-fighter  
# Baker Street Fighter  
## Projet n° 2 - 05/2019  

**Nom du groupe** : Elementary  

**Membres du projet** :
* Clément Bouakil
* Bryan Nuninger
* Youssef Sabouni
* Nicolas Huraux

**Sujet** :  
Baker Street Fighter est une application web où deux personnages s'affrontent, Sherlock Holmes et Professeur Moriarty !  

**Règles** :  
* Les deux personnages possèdent 100 points de vie
* Les deux personnages disposent de deux attaques :  
    * Un coup de poing faisant 10 points de dégat avec 80% d'efficacité
    * Un uppercut faisant 30 points de dégat avec 50% d'efficacité
* Le premier arrivant à 0 point de vie est déclaré perdant

**Accès à la BDD du jeu**
Créer d'abord sur votre ordinateur local l'utilisateur suivant et accorder lui les droits via ces lignes de code.

```
mysql -u root -p < baker_street_fighter.sql

CREATE USER 'baker'@'localhost' IDENTIFIED BY 'Fighter51!';

GRANT ALL ON baker_street_fighter.* TO 'baker'@'localhost';

EXIT;

```

>_Pour la derniere de commande le prompt de la console doit être dans le dossier où se trouve le fichier .sql_

[Product Backlog](https://drive.google.com/file/d/1Wwa4Lc4f_Gt4hrtEYnLsYHaNOsU3T_lC/view?usp=sharing)  

[Sprint Backlog](https://trello.com/b/z8P7w9z6/bakerstreetfighter)  

[Wireframe](https://transfernow.net/ddl/wireframe-baker-street-fighter)