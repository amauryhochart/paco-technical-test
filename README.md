# Test Technique FullStack - TravelQuest

Salut et bienvenue ici. Auchan te propose de consacrer un peu de temps pour nous exposer tes talents.

Tu trouveras ici le squelette d'un projet Spring Reactive (JAVA) / MongoDB (technical-test-api) et la partie front sera
en Thymeleaf (technical-test-renderer).

TravelQuest est une application de réservation de voyages qui offre une expérience utilisateur fluide. Les utilisateurs
peuvent rechercher, sélectionner et réserver des voyages tout en bénéficiant de fonctionnalités avancées telles que des
filtres de recherche personnalisés et une présentation claire des détails du voyage.

# Partie Back

## Partie 1: Chasse aux Bugs

1. **Impossible de lancer l'API**
    - **Description :** Un développeur frauduleux a cassé l'API sans aucun scrupule.
    - **Tâche :** Trouver le problème et le réparer.

2. **Impossible de récupérer les résultats de nos vols**
    - **Description :** Un ami du premier développeur frauduleux n'a pas testé son code, nous n'arrivons à récupérer les
      informations de vol
    - **Tâche :** Réparer la récupération des vols

## Partie 2: Évolutions Éclair

1. **Créer des vols**
    - **Description :** Permettre de créer des vols dans un espace d'administration (pas besoin de la sécuriser)
    - **Tâche :** Avoir un endpoint qui permet l'insertion des vols en base

2. **Rajouter des filtres**
    - **Description :** Permettre à l'utilisateur de trier les résultats par prix ou par localisation.
    - **Tâche :** Ajouter la notion de filtre.

3. **Bonus : Rajouter la pagination**
    - **Description :** Permettre de paginer les résultats.
    - **Tâche :** On aimerait avoir uniquement 6 résultats par page afin d'optimiser les performances de notre
      application.

# Partie Front

## Partie 1: Chasse aux Bugs

1. **Problème d'affichage des tarifs :**
    - **Description :** Certains tarifs ne s'affichent pas correctement sur la page de réservation.
    - **Tâche :** Corrigez le problème d'affichage pour assurer la clarté et la précision des tarifs.

2. **Lenteur de chargement des images :**
    - **Description :** Les images des destinations mettent trop de temps à charger, affectant l'expérience utilisateur.
    - **Tâche :** Optimisez le chargement des images pour améliorer les temps de réponse de la page.

## Partie 2: Évolutions Éclair

1. **Page d'administration pour créer des vols :**
    - **Description :** Utilise le endpoint précédemment créé pour permettre de créer des vols dans une page front.
    - **Tâche :** Pas besoin de la sécuriser, ni de créer un compte admin pour y accéder.
    -
2. **Filtrage des résultats de recherche :**
    - **Description :** Ajoutez une fonctionnalité de filtrage basique pour permettre aux utilisateurs de trier les
      résultats par prix, par localisation et/ou par dates.
    - **Tâche :** Implémentez un système de filtres pour permettre à l'utilisateur de retrouver facilement son vol

3. **Filtrage avancé des résultats de recherche :**
    - **Description :** Permettre la sélection d'un vol et, lors du retour à la page de recherche des vols, conserver le
      filtre précédemment appliqué.
    - **Tâche :** Tu peux très bien le faire en QueryParams ou en Javascript, à toi de voir.

4. **Bonus : Rajouter la pagination**
    - **Description :** Permettre de paginer les résultats.
    - **Tâche :** On aimerait avoir uniquement 6 résultats par page afin d'optimiser les performances de notre
      application.

## Consignes

- N'hésite pas à fouiller sur Google, StackOverflow, la documentation Spring pour trouver les réponses à tes questions.
- Sois prêt à discuter de tes choix et de ton approche lors de l'entretien.
- Have fun !

## Si tu rencontres un problème n'hésite pas à créer une issue sur le repo que tu as fork et on répondra aussi vite que possible !
