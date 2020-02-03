# Tondeuse_Gazon_AXIV_IT

# Introduction 

La société Axiv IT développe une tondeuse à gazon automatique capable de tondre
des surfaces rectangulaires. 
 

La tondeuse peut être programmée pour parcourir l'intégralité de la surface.
La position de la tondeuse est représentée par une combinaison de coordonnées et d'une lettre indiquant l'orientation selon la notation cardinale anglaise (N-E-S-W). La pelouse est divisée en grille pour simplifier la navigation.

## Les choix d'implémentation 
Afin de répondre aux besoins de la société Axiv IT, on peut diviser notre probléme en plusieurs parties :

● La gestion de la pelouse et sa position

● La gestion du mouvement de  la tondeuse et sa position

● Les directions (Coordonnées et Orientation NORTH, EAST, SOUTH et WEST)

● La gestion du script de commandes (Parser)

● L'exécution du programme (Traitements)

● L'implémentation des tests


##  La pelouse 

La pelouse est représentée par la class Pelouse.

La pelouse est définie par les coordonnées de sa Longuer et sa Largeur.

## La tondeuse

Une tondeuse est représentée par la class Tondeuse.
Une tondeuse est définie par deux entiers (x, y) ainsi que par une orientation.
Le choix d'utiliser une class est en partie justifié par le fait que le programme effectue un nombre important de switch/case sur les coordonnées et l'orientation de la tondeuse.



## Coordonnées 

Class Permettant de vérifier si les coordonnées de la tondeuse après mouvement sont en dehors de celles de la pelouse.


## Parametres

Class Permettant de vérifier les mouvements possibles .

## Parser_Donnees
Class contenant les méthodes permettant de valider le format des lignes dans le fichier texte parser la position de la tondeuse et son orientation .

La position et l'orientation sont fournies sous la forme de 2 chiffres et une lettre,séparés par un espace.


## ParserTondeuse

 Class permetant de valider les informations qui permettent de lancer une tandeuse
 et de récuperer la position de la tondeuse qui est définit par ses coordonnées et son orientation.



# Compiler le programme 

Tondeuse_Gazon_AXIV_IT est un projet dévelopé avec Java sous Netbeans. Ainsi, il est possible de télécharger le projet sur votre machine en utilisant la commande :

```bash
git clone https://github.com/Klodovskyy/Tondeuse_Gazon_AXIV_IT.git
```

 Importer le projet compiler le projet en l'important dans un IDE comme Netbeans, Eclipse ou IntelliJ.


# Tester le programme 

Il faut saisir la commande test afin de lancer tous les tests du programme (encours d'implémentation) . Il est possible de lancer individuellement chaque test lorsque le projet est importé dans un IDE comme Eclipse ou IntelliJ.

NB : la Class Main ne possède pas de test. En effet, les méthodes ne renvoyant aucune valeur, cela n'avait pas de sens de leur rédiger des tests.


# Contributing
Veuillez vous assurer de mettre à jour les tests, le cas échéant.
