package tp1;
class OperationsArithmetiquesWithConstructors
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
	
	public OperationsArithmetiquesWithConstructors()
	{
		this(0.0, 0.0);
	}
	
	public OperationsArithmetiquesWithConstructors(double op)
	{
		this(op, 0.0);
	}
	
	public OperationsArithmetiquesWithConstructors(double op1, double op2)
	{
		this.setOperande1(op1);
		this.setOperande2(op2);
	}
}