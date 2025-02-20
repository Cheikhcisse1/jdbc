package tp1;
class OperationsArithmetiquesWithMain
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
}