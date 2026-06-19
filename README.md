# Gestionnaire de Notes — Examen TP Mobile 2025/2026

Application Android (Java) de gestion de notes personnelles, développée selon le sujet d'examen.
Le code source est entièrement en français : noms de classes, de méthodes, de variables, de fichiers
et de dossiers personnalisés, afin d'être compréhensible par n'importe quel lecteur francophone.

## Fonctionnalités implémentées

- Création d'une note avec titre, contenu et couleur
- Consultation de toutes les notes enregistrées
- Modification d'une note (formulaire pré-rempli)
- Gestion des favoris par double clic sur une note
- Recherche d'une note par titre
- Filtre Favoris
- Persistance locale avec SQLite (les notes restent après fermeture/redémarrage)
- Vérification qu'une note vide ne peut pas être enregistrée

## Fonctionnalités bonus ajoutées

- Suppression d'une note (icône dans l'écran de modification, avec confirmation)
- Tri des notes (plus récentes / titre A-Z)
- Compteur de notes
- Mode sombre (persisté, accessible via l'icône lune)
- Partage d'une note (icône dans l'écran de modification)
- Possibilité de changer la couleur d'une note même après sa création (icône palette)

## Organisation du code (entièrement en français)

Package racine : `com.tpmobile.gestionnairenotes`

- `modele/Note.java` : la classe représentant une note
- `donnees/GestionnaireBaseDeDonnees.java` : toutes les opérations de lecture/écriture SQLite
- `adaptateur/AdaptateurNotes.java` : l'affichage de la liste des notes (RecyclerView)
- `utilitaire/PaletteCouleurs.java` : la palette de couleurs imposée par le sujet, centralisée
- `ActivitePrincipale.java` : l'écran liste des notes
- `ActiviteFormulaireNote.java` : l'écran de création/modification d'une note
- `ApplicationNotes.java` : initialisation du mode sombre au démarrage

Les écrans (layouts) sont nommés `ecran_liste_notes.xml`, `ecran_formulaire_note.xml`,
`element_note.xml` et `dialogue_choix_couleur.xml`. Les couleurs sont dans `couleurs.xml`
et les textes dans `textes.xml`.

### Une précision importante sur les dossiers

Les dossiers `res`, `layout`, `drawable`, `values`, `mipmap` et `java` sont des noms imposés
par le système de compilation Android (Gradle) : ils ne peuvent pas être renommés sans casser
le projet, ce ne sont pas du "code" à proprement parler mais des conventions techniques
obligatoires, identiques dans absolument tous les projets Android du monde, quelle que soit
la langue du développeur. Tout ce qui est personnalisable (le package, les classes, les noms
de fichiers à l'intérieur de ces dossiers, les identifiants) a été traduit en français.

## Comment ouvrir le projet

1. Ouvrir Android Studio
2. `File > Open`, puis sélectionner le dossier `GestionnaireNotes`
3. Si Android Studio signale que le wrapper Gradle est manquant, choisir "Use Gradle from local installation" ou laisser l'IDE le régénérer automatiquement, puis cliquer sur "Sync Now"
4. Lancer l'application sur un émulateur ou un téléphone

## Comment déposer le projet sur GitHub

Dans le dossier du projet, ouvrir un terminal et exécuter :

```
git init
git add .
git commit -m "Examen TP Mobile - Gestionnaire de Notes"
git branch -M main
git remote add origin LIEN_DE_TON_DEPOT_GITHUB
git push -u origin main
```

Ensuite, envoyer le lien du dépôt par mail à l'enseignant responsable avec pour objet :
`Rendue Examen TP Intro Android 2026`
