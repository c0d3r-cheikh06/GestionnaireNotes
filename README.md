# Gestionnaire de Notes

Ce projet a été réalisé dans le cadre de l'examen de TP Mobile 2025/2026. Il s'agit d'une application Android développée en Java permettant à un utilisateur de créer, consulter et organiser ses notes personnelles directement depuis son téléphone.

L'objectif principal était de mettre en pratique les notions étudiées en développement Android, notamment la gestion des interfaces, la navigation entre activités, l'utilisation d'une base de données SQLite et la manipulation des composants Android.

## Fonctionnalités réalisées

L'application permet de :

* Créer une nouvelle note en renseignant un titre, un contenu et une couleur ;
* Consulter la liste de toutes les notes enregistrées ;
* Modifier une note existante ;
* Ajouter ou retirer une note des favoris à l'aide d'un double clic ;
* Rechercher une note à partir de son titre ;
* Afficher uniquement les notes favorites ;
* Conserver les données grâce à une base SQLite locale ;
* Empêcher l'enregistrement d'une note vide.

## Fonctionnalités supplémentaires

En plus des fonctionnalités demandées dans le sujet, plusieurs améliorations ont été ajoutées :

* Suppression d'une note avec confirmation ;
* Tri des notes par date ou par ordre alphabétique ;
* Affichage du nombre total de notes ;
* Mode sombre mémorisé automatiquement ;
* Partage du contenu d'une note ;
* Modification de la couleur d'une note après sa création.

## Organisation du projet

Le projet est structuré de manière à séparer les différentes responsabilités de l'application :

* Le package `modele` contient les classes représentant les données ;
* Le package `donnees` regroupe les opérations liées à SQLite ;
* Le package `adaptateur` gère l'affichage des notes dans le RecyclerView ;
* Le package `utilitaire` contient les classes utilitaires utilisées dans l'application.

Les principales activités sont :

* `ActivitePrincipale` : affichage de la liste des notes ;
* `ActiviteFormulaireNote` : création et modification des notes ;
* `ApplicationNotes` : configuration générale de l'application.

## À propos des noms de fichiers

Les classes, méthodes, variables et fichiers créés pour ce projet ont été nommés en français afin de rendre le code plus accessible et plus facile à comprendre.

Certains dossiers tels que `java`, `res`, `layout`, `drawable`, `values` ou encore `mipmap` conservent toutefois leur nom d'origine, car ils font partie de l'architecture standard imposée par Android Studio et le système de compilation Android.

## Exécution du projet

Pour ouvrir le projet :

1. Lancer Android Studio ;
2. Choisir **File > Open** ;
3. Sélectionner le dossier du projet ;
4. Attendre la synchronisation Gradle ;
5. Exécuter l'application sur un émulateur ou un appareil Android.

## Dépôt GitHub

Pour publier le projet sur GitHub :

```bash
git init
git add .
git commit -m "Examen TP Mobile - Gestionnaire de Notes"
git branch -M main
git remote add origin LIEN_DU_DEPOT
git push -u origin main
```

Une fois le dépôt créé, il suffit de transmettre le lien GitHub à l'enseignant conformément aux consignes de l'examen.

## Conclusion

Ce projet a permis de mettre en pratique les concepts fondamentaux du développement Android en Java, notamment la gestion des activités, l'utilisation de SQLite, la persistance des données et la conception d'interfaces utilisateur. Les fonctionnalités supplémentaires ajoutées ont également permis d'améliorer l'expérience utilisateur et d'approfondir la maîtrise des outils Android.
