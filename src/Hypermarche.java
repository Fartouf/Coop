import java.util.LinkedList;

public class Hypermarche {

    private int capaciteStock;

    private LinkedList<Livraison> stockHypermarche = new LinkedList<Livraison>();

    Hypermarche(int capacite){
        this.capaciteStock = capacite;
    }

    public int getCapaciteStock() {
        return capaciteStock;
    }

    public LinkedList<Livraison> getStock(){
        return this.stockHypermarche;
    }

    public void addStock(Livraison livraison){
        this.stockHypermarche.add(livraison);
    }


}
