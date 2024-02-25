# BRIEF WEATHER-APP - Application de Prévisions Météorologiques
## Contexte du Projet
En tant que développeur back-end, vous devez créer une application Java console permettant aux utilisateurs de consulter les prévisions météorologiques actuelles et passées pour différentes villes. L'application comprendra deux principales classes : Menu, City et CityHistory.

## Classes Principales
### Classe City (Ville)
Responsable de stocker les informations actuelles de la météo pour une ville donnée.

#### Attributs :

cityId : Identifiant unique pour la ville.
cityName : Nom de la ville.
currentTemperature : Température actuelle.
currentHumidity : Taux d'humidité actuelle.
currentWindSpeed : Vitesse du vent actuelle.
#### Méthodes :

addCity() : Ajoute un nouvel enregistrement de ville dans la base de données.
updateCity() : Met à jour les détails d'un enregistrement de ville existant.
deleteCity() : Supprime un enregistrement de ville spécifique.
searchCity() : Recherche et récupère les informations météorologiques actuelles pour une ville donnée.
### Classe CityHistory (Historique de Ville)
Responsable de stocker l'historique des données météorologiques pour une ville donnée.

#### Attributs :

historicalDataId : Identifiant unique pour les données historiques.
cityId : Identifiant de la ville associée.
eventDate : Date de l'événement météorologique historique.
temperature : Température historique.
#### Méthodes :

addCityHistory() : Ajoute un nouvel enregistrement historique dans la base de données.
updateCityHistory() : Met à jour les détails d'un enregistrement historique existant.
deleteCityHistory() : Supprime un enregistrement historique spécifique.
searchCityHistory() : Recherche et récupère l'historique météorologique pour une ville donnée.
### Classe Menu
Gère l'interface utilisateur en console et permet aux utilisateurs de naviguer dans l'application.

### Connexion à la Base de Données
Les données météorologiques sont stockées dans une base de données MySQL, et la connexion est établie à l'aide de JDBC (Java Database Connectivity).
## Instructions d'exécution
1. Clonez ce dépôt avec la commande `git clone https://github.com/YassineOularbi/BRIEF-WEATHER-APP.git`.
2. Accédez au répertoire du projet avec la commande `cd BRIEF-WEATHER-APP`.
3. Compilez le code source avec la commande `javac Main.java`.
4. Exécutez le programme avec la commande `java Main`.
5. Suivez les instructions affichées dans la console pour utiliser l'application.

## Auteurs
Ce projet a été développé par [Yassine OULARBI], sous la supervision de l'école ENAA Béni Mellal.

## Contact
Pour toute question ou commentaire, veuillez contacter [yassineoularbi4@gmail.com] ou [+212 6 10 44 60 80].
LinkedIn : "www.linkedin.com/in/yassine-oularbi-79730424b"
