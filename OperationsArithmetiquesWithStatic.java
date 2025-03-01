package tp1;
class OperationsArithmetiquesWithStatic implements Cloneable
{
	//Propriété de classe
	private static int nbOperations = 0;
	
	//Propriétés d'instance
	private double operande1;
	private double operande2;
	
	//Méthode de classe
	public static int getNbOperations()
	{
		return(OperationsArithmetiquesWithStatic.nbOperations);
	}
	
	//Méthodes d'instance
	public double getOperande1()
	{
		return(this.operande1);
	}
	
	public double getOperande2()
	{
		return(this.operande2);
	}
	
	public void setOperande1(double op1)
	{
		this.operande1 = op1;
	}
	
	public void setOperande2(double op2)
	{
		this.operande2 = op2;
	}
	
	public double sommeOperandes()
	{
		OperationsArithmetiquesWithStatic.nbOperations++;
		return(this.getOperande1() + this.getOperande2());
	}
	
	public double diffOperandes()
	{
		OperationsArithmetiquesWithStatic.nbOperations++;
		return(this.getOperande1() - this.getOperande2());
	}
	
	public double prodOperandes()
	{
		OperationsArithmetiquesWithStatic.nbOperations++;
		return(this.getOperande1() * this.getOperande2());
	}
	
	public double divOperandes()
	{
		OperationsArithmetiquesWithStatic.nbOperations++;
		return(this.getOperande1() / this.getOperande2());
	}
	
	public OperationsArithmetiquesWithStatic()
	{
		this(0.0, 0.0);
	}
	
	public OperationsArithmetiquesWithStatic(double op)
	{
		this(op, 0.0);
	}
	
	public OperationsArithmetiquesWithStatic(double op1, double op2)
	{
		this.setOperande1(op1);
		this.setOperande2(op2);
	}
	
	public boolean equals(Object eq)
	{
		if((eq == null)||(this.getClass() != eq.getClass()))
			return(false);
		else
			if(this == eq)
				return(true);
			else
			{
				OperationsArithmetiquesWithStatic test = (OperationsArithmetiquesWithStatic)eq;
				return((this.getOperande1() == test.getOperande1())&&(this.getOperande2() == test.getOperande2()));
			}
	}
	
	public String toString()
	{
		return ("Objet operation arithmetique : operande1 = " + this.getOperande1() + " / operande2 = " + this.getOperande2());
	}
	
	public OperationsArithmetiquesWithStatic clonage() throws CloneNotSupportedException
	{
		return((OperationsArithmetiquesWithStatic)this.clone());
	}
}