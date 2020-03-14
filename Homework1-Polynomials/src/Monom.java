import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Monom {
	
	private int power;
	
	private double coeff;
	
	public Monom(double coeff, int power) {
		this.power = power;
		this.coeff = coeff;    
	}
	
	public int getPower() {
		return power;
	}
	
	public double getCoeff() {
		return coeff;
	}
	
	
	public Monom addMonoms(Monom secondMonom) {
		Monom Add = new Monom((this.getCoeff() + secondMonom.getCoeff()), this.biggestMonomPower(secondMonom));
		return Add;
	}
	
	public Monom subbMonoms(Monom secondMonom) {
		Monom Subb = new Monom((this.getCoeff() - secondMonom.getCoeff()), this.biggestMonomPower(secondMonom));
		return Subb;
	}
	
	public Monom multpMonoms(Monom secondMonom) {
		Monom Multp = new Monom((this.getCoeff() * secondMonom.getCoeff()), this.getPower() + secondMonom.getPower());
		return Multp;
	}
	
	public Monom multpMonomsMinus(Monom SecondMonom) {
		Monom Multp = new Monom((this.getCoeff() * SecondMonom.getCoeff() * -1), this.getPower() + SecondMonom.getPower());
		return Multp;
	}
	
	public Monom divMonoms(Monom SecondMonom) {
		Monom Div = new Monom((this.getCoeff() / SecondMonom.getCoeff()), this.getPower() - SecondMonom.getPower());
		return Div;
	}
	
	public Monom derivMonom() {
		Monom Deriv = new Monom((this.getCoeff() * this.getPower()), (this.getPower() - 1));
		return Deriv;
	}
	
	public Monom integrMonom() {
		Monom Integr = new Monom((this.getCoeff() / (this.getPower() + 1)), (this.getPower() + 1));
		return Integr;  
	}
	
	public int biggestMonomPower(Monom secondMonom){
		if(this.getPower() >= secondMonom.getPower())
		{
			return this.getPower();
		}
		else
		{
			return secondMonom.getPower();  
		}
	}
	
	
	public String monomToString() {
		String result;
		if(this.getPower() == 0 || this.getPower() == -1)
		{
			if(this.getCoeff() >= 0) {
				result = '+' + String.valueOf(new DecimalFormat("##.##").format(this.getCoeff()));
			}
			else 
			{
				result = String.valueOf(new DecimalFormat("##.##").format(this.getCoeff()));
			}
		}
		else
		{
			if(this.getCoeff() >= 0) {
				result = '+' + String.valueOf(new DecimalFormat("##.##").format(this.getCoeff())) + "x^" + this.getPower();
			}
			else 
			{
				result =  String.valueOf(new DecimalFormat("##.##").format(this.getCoeff())) + "x^" + this.getPower();
				
			}
		}
		 
		return result;
  } 
	
	public int addThree(int x) {
		x = x+3;
		return x;
	}
	
	public static void main(String[] args) {
		Monom mon1 = new Monom(2,0);
		Monom mon2 = new Monom(3,2);
		Monom mon3 = mon1.integrMonom();
		String rez = mon3.monomToString();
		
		System.out.println(rez);
		
	}


}





