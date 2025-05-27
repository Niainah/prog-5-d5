# Modélisation Business : Machine à Café

## **Description du Business**
Vente de cafés via une machine automatique .

## **Key Objects (Entités Clés)**
- **MachineACafé** : Contient la logique de préparation et de gestion des stocks.
- **Client** : Utilisateur qui commande un café.
- **Café** : Produit final (différents types).
- **Stock** : Gère les consommables (sucre, café, lait, etc.).
- **Monnayeur** : Gère l'argent inséré et la monnaie rendue.

## **UseKeys (Composants Nécessaires)**
- **Café** (grains ou poudre)  
- **Sucre**  
- **Cuillère** (pour mélanger)  
- **Lait** (pour les options "au lait")  
- **Tasse** (récipient pour servir)  
- **Monnayeur** (pour accepter les paiements)  

---

## **Types de Cafés (Produits)**
1. **Café Simple** : Café noir + option sucre.
2. **Café au Lait** : Café + lait + option sucre.
3. **Café VIP** : Café haut de gamme (ex : double espresso, mousse de lait, sucre vanillé).

---

## **Use Cases (Cas d'Utilisation)**
1. **Commander un Café**  
   - Le client sélectionne un type de café.  
   - La machine vérifie le stock et le paiement.  
   - Si OK, prépare et sert le café.  

2. **Insérer de l'Argent**  
   - Le client insère des pièces/billets.  
   - La machine valide le montant et met à jour le crédit.  

3. **Gérer le Stock**  
   - Alerte si niveau de sucre/café/lait/tasses est faible.  

4. **Rendre la Monnaie**  
   - Si le client annule ou paie trop, la machine rend la monnaie.  

---

## **Errors (Erreurs Possibles)**
- **Paiement Insuffisant** → "Veuillez insérer plus d'argent."  
- **Stock Épuisé** → "Ingrédient manquant. Choix indisponible."  
- **Tasse Manquante** → "Aucune tasse disponible."  
- **Monnaie Non Rendue** → "Erreur de monnayeur. Contactez le support."  

---

## **Diagramme Simplifié (Exemple)**
```
sequenceDiagram
    Client ->> MachineACafé: Sélectionne "Café au Lait"
    MachineACafé->>Monnayeur: Vérifie paiement
    alt Paiement OK
        MachineACafé->>Stock: Vérifie ingrédients
        alt Stock OK
            MachineACafé->>MachineACafé: Prépare café
            MachineACafé->>Client: Serre café
        else Stock KO
            MachineACafé->>Client: "Ingrédient manquant"
        end
    else Paiement KO
        MachineACafé->>Client: "Paiement insuffisant"
    end