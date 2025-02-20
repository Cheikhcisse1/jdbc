package tp1;
public class MainWithArguments {
    public static void main(String[] args   )  throws CloneNotSupportedException{
        
        if (args.length == 2) {
            
            double arg0 = Double.parseDouble(args[0]);
            double arg1 = Double.parseDouble(args[1]);
            OpérationsArithmétiquesWithArguments opArith1 = new OpérationsArithmétiquesWithArguments(arg0,arg1);
            OpérationsArithmétiquesWithArguments opArith2= new OpérationsArithmétiquesWithArguments(arg0,arg1);
                //Affichage de la propriété de classe
            System.out.println("\nNombre d'operations arihtmetiques effectuees jusque-la : " + OpérationsArithmétiquesWithArguments.getNbOperations());
            
            //Opérations sur opArith1
            System.out.println("\nResultat de la somme entre " + opArith1.getOperande1() + " et " + opArith1.getOperande2() + " = " + opArith1.sommeOperandes());
            System.out.println("Resultat de la soustraction entre " + opArith1.getOperande1() + " et " + opArith1.getOperande2() + " = " + opArith1.diffOperandes());
            System.out.println("Resultat du produit entre " + opArith1.getOperande1() + " et " + opArith1.getOperande2() + " = " + opArith1.prodOperandes());
            System.out.println("Resultat de la division entre " + opArith1.getOperande1() + " et " + opArith1.getOperande2() + " = " + opArith1.divOperandes());
            
            //Opérations sur opArith2
            System.out.println("\nResultat de la somme entre " + opArith2.getOperande1() + " et " + opArith2.getOperande2() + " = " + opArith2.sommeOperandes());
            System.out.println("Resultat de la soustraction entre " + opArith2.getOperande1() + " et " + opArith2.getOperande2() + " = " + opArith2.diffOperandes());
            System.out.println("Resultat du produit entre " + opArith2.getOperande1() + " et " + opArith2.getOperande2() + " = " + opArith2.prodOperandes());
            System.out.println("Resultat de la division entre " + opArith2.getOperande1() + " et " + opArith2.getOperande2() + " = " + opArith2.divOperandes());
            
            //Affichage de la propriété de classe
            System.out.println("\nNombre d'operations arihtmetiques effectuees jusque-la : " + OpérationsArithmétiquesWithArguments.getNbOperations());
            
            //Tests d'égalité/équivalence
            System.out.println("\nTest d'egalite : " + (opArith1 == opArith2));
            System.out.println("Test d'equivalence opArith2 avec opArith1 : " + opArith1.equals(opArith2));
            System.out.println("Test d'equivalence opArith1 avec opArith2 : " + opArith2.equals(opArith1));
            
            //Affichage des objets
            System.out.println("\nObjet#1 : " + opArith1);
            System.out.println("Objet#2 : " + opArith2);
            
            //Clonage d'un objet
            opArith2 = opArith1.clonage();
            System.out.println("Objet apres clonage : " + opArith2);
            
            //Destruction d'un objet
            System.out.println("\nDestruction de opArith2...");
            //Rend 'inutile' dans le tas l'objet référencé par opArith2
            opArith2 = null;
            //On force l'exécution du garbage collector
            System.gc();
        }
        else{
            System.out.println("le nombre d'argument dépasse");
        }
	}
        
    
}
