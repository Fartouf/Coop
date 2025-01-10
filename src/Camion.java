
public class Camion {

    private int capaciteCamion;

    Camion(int capaciteCamion){
        this.capaciteCamion = capaciteCamion;
    }

    public int getCapaciteCamion() {
        return capaciteCamion;
    }

    public void setCapaciteCamion(int capaciteCamion) {
        this.capaciteCamion = capaciteCamion;
    }

    
    //livraison vers un entrepot depuis le stock d'un producteur
    public void livraisonEntrepot(Producteur producteur, Entrepot entrepot){

        //verification de la capacité restante de l'entrot
        int capacitéDisponible = entrepot.getCapatiteDisponible();
        int capaciteCamion = this.getCapaciteCamion();

        //on cree une nouvelle livraison et on l'ajoute au livraisons dans l'entrpot si il y a de la place.
         for(int c = 0; c < capaciteCamion; c++){

            
            //si il reste du stock on ajoute dans le campion si il reste de la place
            if(capacitéDisponible > 0 && producteur.getStock().size() > 0){

                Livraison livraisonActuelle = producteur.getStock().getFirst();
                producteur.removeStock();
                entrepot.addLivraison(livraisonActuelle);
                
            }else if (capacitéDisponible > 0 && producteur.getStock().size() <= 0) {
                //Cas ou l'entrepot est pas rempli mais le stock du fournisseur est vide on passe a l'iteration suivante
                break;
            }else {
                //Cas ou l'entrepot est rempli ==> on livre une parie avant de passer a l'itteration suivante ==> possiblitlté d'eliminer une des etapes 
                //livrer directement apres chaque livraison vers l'entrpot
                this.LivraisonHypemarché(entrepot, entrepot.getHypermarche());
                break;            
            }
        }

    }
    

    //livraison vers un hypermarché  
    public void LivraisonHypemarché(Entrepot entrepot, Hypermarche hypermarche){

        int capaciteCamion = this.getCapaciteCamion();

        //on enleve du stock de l'entrepot
        for(int c = 0; c < capaciteCamion; c++){
            if (entrepot.getLivraisons().size() > 0){
                //System.out.println("livraison vers le hypermarche");
                Livraison livraisonActuelle = entrepot.getLivraisons().getFirst();
                entrepot.removeLivraison();
                hypermarche.addStock(livraisonActuelle);
            }else{
                //System.out.println("toute les livraisons sont effectué vers le hypermarché");
                break;
            }
        }
    }

}
