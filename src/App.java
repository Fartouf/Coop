import java.util.HashSet;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        //Temps de la simulation en semaines.
        int tempsDeSim = 12;

        //liste de producteurs ==> hashset pour eviter des doublons
        HashSet<Producteur> producteurs = new HashSet<Producteur>();

        //liste de camions ==> hashset pour eviter des doublons
        HashSet<Camion> camions = new HashSet<Camion>();

        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("Veuillez entrer le nombre de Camions à Disposition:");

            int nbCam = userInput.nextInt();

            System.out.println("Veuillez entrer le nombre de producteurs:");

            int nbProducteur = userInput.nextInt();

            System.out.println("Veuillez entrer la capacité de l'entrepot:");

            int capaciteEntrepot = userInput.nextInt();

            //TODO : remove capacité
            Hypermarche hypermarche = new Hypermarche(500);

            
            //liste des noms d'agriculteurs possibles
            String[] nomsProducteurs = {"Aggregate Agro",
            "Agricultural Gain",
            "Agventure",
            "Fresh Fields",
            "Succulent Seeds",
            "AgroAcres",
            "Blueswan Poultry",
            "Blackburrow Ranch",
            "Whitecreek Farms",
            "Bignest Farms",
            "Oakwood Farms",
            "Dewberry Farm",
            "Nature Hills",
            "Farmington",
            "Vertigo Farms",
            "Vertical Farming",
            "Farm Fund",
            "Living Livestock",
            "AgroPro",
            "Lifelong Livestock"};

            //liste des noms deja utilisé
            HashSet<String> nomsUtilise = new HashSet<String>();

            //TODO : verifier
            //on commence par creer les instances des producteurs
            for(int i = 0; i < nbProducteur; i++){
                int index = (int)(Math.random() * nomsProducteurs.length); 
                while(!(nomsUtilise.contains(nomsProducteurs[index]))){
                    nomsUtilise.add(nomsProducteurs[index]);
                    producteurs.add(new Producteur(nomsProducteurs[index], 3));
                }     

            }

            //System.out.println(producteurs);

            //on cree l'entrpot en fonction de la taille choisie:
            Entrepot entrepot = new Entrepot(capaciteEntrepot, 0, hypermarche);


            //on commence par creer les instances des camions
            for(int i = 0; i < nbCam; i++){
                //capacité du camion
                //int capacité = (int)((Math.random() * 5)+1);
                int capacité = 1;
                camions.add(new Camion(capacité));
            }



            //Loop pour la simulation
            for(int semaine = 0; semaine < tempsDeSim; semaine++){
                //livraisons des producteurs vers l'entrepot chaque semaine 
                for(Producteur produteur : producteurs){
                    produteur.productuctionHebdo();
                    System.out.println("Nouvelle livraison disponibles chez le producteur : " + produteur.getNomProducteur());
                    while(produteur.getStock().size() > 0){
                        System.out.println("Nombre de livraisons en stock chez " + produteur.getNomProducteur() + " : " + produteur.getStock().size());
                        for(Camion camion: camions){
                            if(produteur.getStock().size() > 0){
                                System.out.println("Il reste " + entrepot.getCapatiteDisponible() + "  De capatié de stoquage à l'entrepot");
                                camion.livraisonEntrepot(produteur, entrepot);
                                //System.out.println("Livraison vers l'entrepot enffectué, il reste " + produteur.getStock().size() + " Livraisons chez le producteur");

                            }else{
                                System.out.println("Toute la marchandise est à l'entrepot");
                                break;
                            }
                        }
                    }

                    System.out.println(entrepot.getLivraisons());
                }

                /*
                 * Une fois que toutes les livraisons sont effectuées des fournisseurs vers l'entrepot, on vide l'entrepot vers le supermarché
                 */
                while(entrepot.getLivraisons().size()>0){
                    System.out.println("Le stock de l'entrepot s'élève à  " + entrepot.getLivraisons().size() + " unitées");

                    for(Camion camion : camions){

                        if(entrepot.getLivraisons().size()>0){
                            System.out.println("Livraisons au hypermarché effectué par le camion " + camion);

                            camion.LivraisonHypemarché(entrepot, hypermarche);
                        } else {
                            System.out.println("Tout le stock est livré au hypermarche");
                            break;
                        }
                    }
                }

                System.out.println("Le stock dans le hypermarché s'éleve à " + hypermarche.getStock().size());
                
            }
        }
   
    }
}
