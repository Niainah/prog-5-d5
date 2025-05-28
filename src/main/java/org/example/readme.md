# Simulation de Machine à Café

## Présentation

Ce projet est une simulation d'une machine à café automatique développée en Java. Il a pour objectif de reproduire le processus complet de commande de café : du paiement jusqu'à la distribution, tout en respectant une architecture logicielle propre, modulaire et orientée objet. Le système prend également en compte les erreurs possibles comme les paiements insuffisants, le manque d'ingrédients, d’eau ou une panne de courant.

## Fonctionnalités principales

L'utilisateur peut :

- Effectuer un paiement
- Choisir un type de café parmi plusieurs options (`c1`, `c2`, `c3`, etc.)
- Obtenir son café préparé si toutes les conditions sont remplies

Le tout en recevant des messages clairs en cas d'erreur (paiement insuffisant, panne, etc.).

## Architecture du projet

L'application suit les principes de la Clean Architecture et de la programmation orientée objet, avec une séparation claire des responsabilités. Voici les principaux modules :

### Module d’Alimentation

Vérifie que la machine est bien sous tension avant toute opération.

### Module de Paiement

Gère la réception et la validation des paiements. Il empêche la suite du processus en cas de fonds insuffisants.

### Module de Sélection de Café

Permet à l'utilisateur de choisir un café. Il vérifie :
- Que les ingrédients sont disponibles
- Que l’eau est suffisante
- Que la machine est alimentée

### Module d’Inventaire

Suit le stock de café, lait, sucre, etc. Il est mis à jour après chaque préparation.

### Module de Réservoir d’Eau

Contrôle le niveau d’eau disponible pour la préparation.

### Module de Distribution

Coordonne la préparation et la distribution du café en fonction des vérifications précédentes.

### Interface Utilisateur

Affiche les options, collecte les choix, transmet les informations aux modules concernés et affiche les messages d’erreur ou de succès.

## Schéma du flux utilisateur

1. Section d'un café
2. Paiement
3. Vérifications (alimentation, ingrédients, eau)
4. Préparation et distribution du café
5. Affichage d’un message de succès ou d’erreur
