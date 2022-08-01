📝 `NOTE` Collez ce modèle en haut de votre fichier `README.md` existant de la partie 1 de ce devoir. (🚫 Supprimez ce paragraphe après avoir coché les user stories terminées)

## Flix Partie 2

### Histoires d'utilisateurs

#### OBLIGATOIRE (10pts)

- [x] (8pts) Exposez les détails du film (notes à l'aide de RatingBar, popularité et synopsis) dans une activité distincte.
- [x] (2pts) Autoriser la lecture des publications vidéo en plein écran à l'aide de YouTubePlayerView.

#### PRIME

- [] Implémenter une transition d'élément partagé lorsque l'utilisateur clique sur les détails d'un film (1 point).
- [] Les bandes-annonces des films populaires sont lues automatiquement lorsque le film est sélectionné (1 point).
  - [] Lorsque vous cliquez sur un film populaire (c'est-à-dire un film voté pour plus de 5 étoiles), la vidéo doit être lue immédiatement.
  - [] Les vidéos moins populaires s'appuient sur la page détaillée doivent afficher un aperçu de l'image qui peut lancer la lecture d'une vidéo YouTube.
- [] Ajoutez une superposition d'icône de lecture aux films populaires pour indiquer que le film peut être lu (1 point).
- [ ] Appliquer la liaison de données pour les vues pour aider à supprimer le code passe-partout. (1 point)
- [ ] Ajoutez des coins arrondis pour les images en utilisant les transformations Glide. (1 point)

### App Walkthrough GIF
<img src="apiYoutube.gif" width=250><br>

### Remarques

Décrivez les difficultés rencontrées lors de la création de l'application.

## Bibliothèques open-source utilisées
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Requêtes HTTP asynchrones simples avec analyse JSON
- [Glide](https://github.com/bumptech/glide) - Bibliothèque de chargement et de mise en cache d'images pour Android
