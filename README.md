# Modélisation Business : Machine à Café

## **Description du Business**
Vente de cafés via une machine automatique .

## Scénarios d'Utilisation  (Use Cases)

### 1. Paiement

**Acteurs** : Client, Monnayeur
**Étapes** :

* Le client insère de l’argent.
* Le système vérifie si le montant est suffisant.
* S’il y a un excédent, le monnayeur rend la monnaie.
* Sinon, il affiche un message d’erreur.

### 2. Choix du Café

**Acteurs** : Client, MachineACafé
**Étapes** :

* Le client sélectionne un type de café.
* Le système vérifie si les ingrédients nécessaires sont disponibles.
* S’il manque un ingrédient, il notifie l’utilisateur.

### 3. Préparation du Café

**Acteurs** : MachineACafé
**Étapes** :

* Préparation des ingrédients.
* Temps d’attente.
* Livraison dans la tasse.

### 4. Livraison du Café

**Acteurs** : MachineACafé, Client
**Étapes** :

* Le client récupère sa boisson.
* Le stock est automatiquement mis à jour.

---

## Cas d’Erreurs Supplémentaires

| Erreur                      | Message Utilisateur                                 |
| --------------------------- | --------------------------------------------------- |
| Plus de lumière (panne LED) | "Éclairage inactif. Merci de contacter le support." |
| Plus d’eau                  | "Réservoir vide. Veuillez patienter..."             |
| Plus de parfum (VIP)        | "Arôme indisponible temporairement."                |
| Temps de réponse trop long  | "Temps d’attente prolongé. Veuillez réessayer."     |

---

## Modélisation

### Classes et Relations :

* **MachineACafé**

  * Attributs : `stock`, `monnayeur`
  * Méthodes : `choisirCafé()`, `préparerCafé()`, `verifierStock()`
* **Client**

  * Attributs : `solde`, `préférences`
  * Méthodes : `payer()`, `choisirCafé()`
* **Café**

  * Attributs : `nom`, `prix`, `ingrédients`
* **Stock**

  * Attributs : `quantité_café`, `quantité_lait`, `quantité_sucre`, `tasses`, `eau`
  * Méthodes : `mettreAJour()`, `vérifierDisponibilité()`
* **Monnayeur**

  * Attributs : `fonds_disponibles`
  * Méthodes : `accepterPaiement()`, `rendreMonnaie()`

**Relations :**

* Le `Client` interagit avec la `MachineACafé`.
* La `MachineACafé` utilise le `Stock`, le `Monnayeur` et prépare un `Café`.

