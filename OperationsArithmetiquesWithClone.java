package tp1;
class OperationsArithmetiquesWithClone implements Cloneable
{
	private double operande1;
	private double operande2;
	
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
		return(this.getOperande1() + this.getOperande2());
	}
	
	public double diffOperandes()
	{
		return(this.getOperande1() - this.getOperande2());
	}
	
	public double prodOperandes()
	{
		return(this.getOperande1() * this.getOperande2());
	}
	
	public double divOperandes()
	{
		return(this.getOperande1() / this.getOperande2());
	}
	
	public OperationsArithmetiquesWithClone()
	{
		this(0.0, 0.0);
	}
	
	public OperationsArithmetiquesWithClone(double op)
	{
		this(op, 0.0);
	}
	
	public OperationsArithmetiquesWithClone(double op1, double op2)
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
				OperationsArithmetiquesWithClone test = (OperationsArithmetiquesWithClone)eq;
				return((this.getOperande1() == test.getOperande1())&&(this.getOperande2() == test.getOperande2()));
			}
	}
	
	public String toString()
	{
		return ("Objet operation arithmetique : operande1 = " + this.getOperande1() + " / operande2 = " + this.getOperande2());
	}
	
	public OperationsArithmetiquesWithClone clonage() throws CloneNotSupportedException
	{
		return((OperationsArithmetiquesWithClone)this.clone());
	}
}