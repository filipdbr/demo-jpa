<h1>Bibliothèque - JPA</h1>
<h2>Description</h2>

Ce projet est une implémentation des TP 1, 2 et 3 de notre cours sur la modélisation JPA (Java Persistence API) chez Diginamic. L'objectif est de comprendre et d'utiliser JPA pour gérer les entités et les relations au sein d'une base de données représentant une bibliothèque simplifiée. Ce projet inclut la configuration de la base de données, la création d'entités, et l'exécution de requêtes pour manipuler les données.

<h2>Entités et Relations Clés</h2>

    Entités Créées :
        Client : Représente un client de la bibliothèque.
        Livre : Représente un livre disponible dans la bibliothèque.
        Emprunt : Représente un emprunt de livre par un client.

    Relations Implémentées :
        Client - Emprunt : Relation OneToMany, un client peut avoir plusieurs emprunts.
        Livre - Emprunt : Relation ManyToMany, un livre peut être emprunté plusieurs fois par divers clients, et un emprunt peut concerner plusieurs livres.

<h2>Fonctionnalités Implémentées</h2>

    Gestion des Clients : Création, lecture, mise à jour et suppression des clients.
    Gestion des Livres : Gestion des livres disponibles pour emprunt.
    Gestion des Emprunts : Création et suivi des emprunts, avec l'affichage des livres empruntés par chaque client.

<h2>Structure du Projet</h2>

    Package des Entités (entites) : Contient les classes Client, Livre, et Emprunt avec les annotations JPA appropriées.
    Classe Principale (ConnexionJpa) : Point d'entrée de l'application, responsable de la gestion des transactions et de la persistance des entités.

<h2>Commentaire d'auteur</h2>

    Implémentation Manuelle : Tout le code et la logique ont été développés manuellement, respectant les exigences des TP.
    Génération du README : Ce fichier README a été généré avec l'aide de l'IA pour une présentation claire et structurée.

<h2>Comment Exécuter</h2>

    Configuration de la Base de Données : Créez une base de données MariaDB avec le nom "bibliotheque".
    Configuration du persistence.xml : Assurez-vous que le fichier persistence.xml est correctement configuré avec l'URL de la base de données, les identifiants et autres propriétés nécessaires.
    Exécution de l'Application : Lancez l'application depuis un environnement Java compatible.

<h3>Informations Supplémentaires</h3>

Le projet est conforme aux spécifications des TP et suit les meilleures pratiques en matière de conception orientée objet et d'utilisation de JPA. Le code est conçu pour être clair, maintenable et extensible.

<h2>Auteur</h2>

<p>Filip Dabrowski</p>
<p>L'auteur a développé l'entier du projet, y compris la mise en place de la base de données, les entités, et les opérations CRUD, tout en suivant les directives et les objectifs pédagogiques des TP.</p>
