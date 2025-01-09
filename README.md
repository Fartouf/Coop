## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).



L’objectif est de modéliser le système d’une coopérative agricole et d’en simuler le fonctionnement :

Dans une coopérative, plusieurs producteurs  livrent leur marchandise dans un entrepôt commun
L’entrepôt a forcément une taille limitée
Les agriculteurs livrent à une fréquence différente, entre 1 et 5 fois par semaine
La coopérative dispose de plusieurs camions qui fonctionnent en 24/7 pour charger la marchandise depuis l’entrepôt et la livrer vers un hypermarché
 

L’objectif est de modéliser ce système et ensuite d’en simuler le fonctionnement sur une durée déterminée (plusieurs mois) avec différents paramètres :

Nombre d’agriculteurs
Taille de l’entrepôt
Nombre de camions
On peut se contenter de faire un log à chaque livraison dans l’entrepôt ou vers un hypermarché