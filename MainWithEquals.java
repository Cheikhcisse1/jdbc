package tp1;
public class MainWithEquals
{
	public static void main(String[] args)
	{
		OperationsArithmetiquesWithEquals opArith1 = new OperationsArithmetiquesWithEquals(2.1, 3.5);
		OperationsArithmetiquesWithEquals opArith2 = new OperationsArithmetiquesWithEquals(2.1, 3.5);
		
		//Opérations sur opArith1
		System.out.println("Resultat de la somme entre " + opArith1.getOperande1() + " et " + opArith1.getOperande2() + " = " + opArith1.sommeOperandes());
		System.out.println("Resultat de la soustraction entre " + opArith1.getOperande1() + " et " + opArith1.getOperande2() + " = " + opArith1.diffOperandes());
		System.out.println("Resultat du produit entre " + opArith1.getOperande1() + " et " + opArith1.getOperande2() + " = " + opArith1.prodOperandes());
		System.out.println("Resultat de la division entre " + opArith1.getOperande1() + " et " + opArith1.getOperande2() + " = " + opArith1.divOperandes());
		
		//Opérations sur opArith2
		System.out.println("Resultat de la somme entre " + opArith2.getOperande1() + " et " + opArith2.getOperande2() + " = " + opArith2.sommeOperandes());
		System.out.println("Resultat de la soustraction entre " + opArith2.getOperande1() + " et " + opArith2.getOperande2() + " = " + opArith2.diffOperandes());
		System.out.println("Resultat du produit entre " + opArith2.getOperande1() + " et " + opArith2.getOperande2() + " = " + opArith2.prodOperandes());
		System.out.println("Resultat de la division entre " + opArith2.getOperande1() + " et " + opArith2.getOperande2() + " = " + opArith2.divOperandes());
		
		//Tests d'égalité/équivalence
		System.out.println("Test d'egalite : " + (opArith1 == opArith2));
		System.out.println("Test d'equivalence : " + opArith1.equals(opArith2));
		System.out.println("Test d'equivalence : " + opArith2.equals(opArith1));
	}
}