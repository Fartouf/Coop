import java.util.LinkedList;

public class Entrepot {

    private int capaciteLimite;
    private int capaciteActuelle;
    private Hypermarche hypermarche;
    

    public Hypermarche getHypermarche() {
        return hypermarche;
    }

    //utilisation d'une liste liée pour faciliter le mechanisme FIFO
    private LinkedList<Livraison> Livraisons = new LinkedList<Livraison>();

    public LinkedList<Livraison> getLivraisons() {
        return Livraisons;
    }

    Entrepot(int capaciteLimite, int capaciteActuelle, Hypermarche hypermarche){
        this.capaciteLimite = capaciteLimite;
        this.capaciteActuelle = capaciteActuelle;
        this.hypermarche = hypermarche;
    }

    public int getCapatiteLimite(){
        return this.capaciteLimite;
    }

    public int getCapatiteDisponible(){
        return this.capaciteLimite - Livraisons.size();
    }

    public void setCapaciteActuelle(int variationCapacité){
        this.capaciteActuelle = this.capaciteActuelle + variationCapacité;
    }

    public void addLivraison(Livraison livraison){
        if( Livraisons.size() < capaciteLimite){
            System.out.println("Arivée d'une livraison dans l'entrepot");

            this.Livraisons.add(livraison);
            System.out.println(this.Livraisons);
            
        } else{
            System.out.println("L'entrepot est deja à capacité maximale");
        }
    }

    public void removeLivraison(){
        this.Livraisons.removeFirst();
     }
}
