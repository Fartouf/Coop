import java.util.LinkedList;

public class Producteur {

    private String nomProducteur;
    private int frequenceDeProduction;

    private LinkedList<Livraison> stock = new LinkedList<Livraison>();


    public LinkedList<Livraison> getStock() {
        return stock;
    }


    public void addStock(Livraison livraison) {
        this.stock.add(livraison);
    }

    public void removeStock() {
        this.stock.removeFirst();
    }



    Producteur(String nomProducteur, int frequenceDeProduction){
        //TODO : changer 
        this.frequenceDeProduction = frequenceDeProduction;
        this.nomProducteur = nomProducteur;
    }


    public int getFrequenceDeProduction() {
        return frequenceDeProduction;
    }

    public void setFrequenceDeProduction(int frequenceDeProduction) {
        this.frequenceDeProduction = frequenceDeProduction;
    }

        
    public String getNomProducteur() {
        return nomProducteur;
    }


    public void setNomProducteur(String nomProducteur) {
        this.nomProducteur = nomProducteur;
    }

    public void productuctionHebdo(){
        for(int c = 0; c < this.getFrequenceDeProduction(); c++){
            //on cree une nouvelle livraison en focntion de la frequence de production
            this.addStock(new Livraison(this));
        }
    }
    
}
