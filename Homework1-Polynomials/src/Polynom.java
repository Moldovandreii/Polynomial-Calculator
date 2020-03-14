import java.util.ArrayList;
import java.util.List;

public class Polynom {
	
	private List<Monom> monomList = new ArrayList<Monom>();  
	
	public Polynom(List<Monom> monomListt) {
		List<Monom> newListt = this.arrangeTermsInList(monomListt);  
		int power = newListt.get(0).getPower();
		int temp = 0;
		int size = newListt.size();
		for(int i=0; i<=newListt.get(0).getPower(); i++) {
			if(size != 0 && newListt.get(temp).getPower() == power)  
			{
				monomList.add(newListt.get(temp));
				power--;
				temp++;
				size--;
			}
			else
			{
				Monom aux = new Monom(0,power);
				monomList.add(aux);
				power--;
			}
		}
	}
	
	public Polynom addPolynoms(Polynom secondPolynom) {
		List<Monom> result = new ArrayList<Monom>(); 
		int coeff = this.biggestPower(secondPolynom);
		for(int i=0; i<=this.biggestPower(secondPolynom); i++)
		{
			Monom mon1 = this.monWithPower(coeff);
			Monom mon2 = secondPolynom.monWithPower(coeff);
			result.add(mon1.addMonoms(mon2));
			coeff--;
		}
		Polynom rez = new Polynom(result);
		return rez;  
	}

	public Monom monWithPower(int power) {
		List<Monom> lst = this.getMonomList();
		for(int i=0; i<lst.size(); i++) {
			if(lst.get(i).getPower() == power)
			{
				return lst.get(i);
			}
		}
		Monom mon = new Monom(0,0);
		return mon;
	}
	
	public int biggestPower(Polynom secondPolynom) {
		if(this.monomList.get(0).getPower() > secondPolynom.getMonomList().get(0).getPower())
		{
			return this.monomList.get(0).getPower();
		}
		else
		{
			return secondPolynom.getMonomList().get(0).getPower();
		}
		
	}
	
	public int biggestPowerInList(List<Monom> lst) {
		int power = 0;
		for(int i=0; i<lst.size(); i++) {
			if(lst.get(i).getPower() > power)
			{
				power = lst.get(i).getPower();
			}
		}
		return power;
	}
	
	public List<Monom> arrangeTermsInList(List<Monom> lst){
		List<Monom> rez = new ArrayList<Monom>();
		int power = this.biggestPowerInList(lst);
		double coeffSum = 0;
		do {
			for(int i=0; i<lst.size(); i++) {
				if(lst.get(i).getPower() == power)
				{
					coeffSum = coeffSum + lst.get(i).getCoeff();
				}
			}
			Monom m = new Monom(coeffSum, power);
			rez.add(m);
			power--;
			coeffSum = 0;
		}while(power != -1);
		return rez;
	}
	
	public Polynom subbPolynoms(Polynom secondPolynom) {
		List<Monom> result = new ArrayList<Monom>(); 
		int coeff = this.biggestPower(secondPolynom);
		for(int i=0; i<=this.biggestPower(secondPolynom); i++)
		{
			Monom mon1 = this.monWithPower(coeff);
			Monom mon2 = secondPolynom.monWithPower(coeff);
			result.add(mon1.subbMonoms(mon2));
			coeff--;
		}
		Polynom rez = new Polynom(result);
		return rez;  
	}
	
	public Polynom multpPolynoms(Polynom secondPolynom) {
		List<Monom> result = new ArrayList<Monom>();
		Polynom[] aux = this.longestPoly(this, secondPolynom);
		for(int i=0; i<aux[0].getMonomList().size(); i++) {
			for(int j=0; j<aux[1].getMonomList().size(); j++) {
				result.add(aux[0].getMonomList().get(i).multpMonoms(aux[1].getMonomList().get(j)));
			}
		}
		Polynom rez = new Polynom(result);
		return rez;
	}
	
	public Polynom derivPolyynom() {
		List<Monom> result = new ArrayList<Monom>(); 
		for(int i=0; i<this.getMonomList().size(); i++) {
			result.add(this.monomList.get(i).derivMonom());
		}
		Polynom rez = new Polynom(result);
		return rez;
	}
	
	public Polynom integrPolyynom() {
		List<Monom> result = new ArrayList<Monom>(); 
		for(int i=0; i<this.getMonomList().size(); i++) {
			result.add(this.monomList.get(i).integrMonom());
		}
		Polynom rez = new Polynom(result);
		return rez;  
	}
	
	public Polynom[] divPolynoms(Polynom secondPolynom) {
		List<Monom> quotient = new ArrayList<Monom>(); 
		List<Monom> rest = new ArrayList<Monom>();
		List<Monom> pol1 = this.monomList;
		List<Monom> pol2 = secondPolynom.getMonomList();
		Polynom aux = new Polynom(pol1);
		boolean divideMore = true;
		int pow = 0;
		int quotindex = 0;
		int pol2Size = pol2.size();
		while(divideMore) {
			if(pol2.get(pow).getCoeff() != 0)
			{
				int polCoeff = aux.fisrtMonomNotNull();
				quotient.add(aux.getMonomList().get(polCoeff).divMonoms(pol2.get(pow)));   
				List<Monom> auxToBeSubbed = new ArrayList<Monom>();  
				int pw = pow;
				for(int i=0; i<pol2Size; i++) {
					auxToBeSubbed.add(quotient.get(quotindex).multpMonomsMinus(pol2.get(pw)));
					pw++;
				}
				quotindex++;
				Polynom p = new Polynom(auxToBeSubbed);
				aux = aux.addPolynoms(p);  
				if(aux.getMonomList().get(quotindex).getPower() < pol2.get(pow).getPower())  
				{
					rest = aux.getMonomList();
					divideMore = false;
				}
			}
			else
			{
				pow++;
				pol2Size--;
			}
		}
		Polynom rst = new Polynom(rest);
		Polynom quot = new Polynom(quotient);
		Polynom[] rez = {quot, rst};
		return rez;
	}
	
	public int fisrtMonomNotNull() {
		List<Monom> lst = this.getMonomList();
		for(int i=0; i<lst.size(); i++) {
			if(lst.get(i).getCoeff() != 0)
			{
				return i;  
			}
		}
		return 0;
	}
	
	public Polynom[] longestPoly(Polynom pol1, Polynom pol2) {
		List<Monom> l1 = new ArrayList<Monom>();
		List<Monom> l2 = new ArrayList<Monom>();
		if(pol1.getMonomList().size() > pol2.getMonomList().size())
		{
			l1 = pol1.getMonomList();
			l2 = pol2.getMonomList();
		}
		else
		{
			l1 = pol2.getMonomList();
			l2 = pol1.getMonomList();
		}
		Polynom p1 = new Polynom(l1); 
		Polynom p2 = new Polynom(l2);
		Polynom[] rez = {p1, p2};
		return rez;
	}
	
	public int longestPolynom(Polynom pol1, Polynom pol2) {
		if(pol1.getMonomList().size() > pol2.getMonomList().size())
		{
			return pol1.getMonomList().size();
		}
		else
		{
			return pol2.getMonomList().size();
		}
	}
	
	public List<Monom> getMonomList() {
		return monomList;  
	}

	public String polynomToString() {
		String text = new String();
		int notZero = 0;
		for(int i=0; i<this.monomList.size(); i++) {
				if(this.monomList.get(i).getCoeff() != 0)
				{
					text = text.concat(this.getMonomList().get(i).monomToString());
					notZero++;
				}		
		}
		if(notZero == 0) {
			text = text.concat("0");
		}
		return text;  
	}
	
	public String polynomArrToString(Polynom[] polArr){
		String text = "q=";
		int qZero = 0;
		int rZero = 0;
		for(int i=0; i<polArr[0].getMonomList().size(); i++) {
			if(polArr[0].getMonomList().get(i).getCoeff() != 0)
			{
				text = text.concat(polArr[0].getMonomList().get(i).monomToString());
				qZero++;
			}  
		}
		if(qZero == 0)
		{
			text = text.concat("0");
		}
		text = text.concat(", r=");
		for(int i=0; i<polArr[1].getMonomList().size(); i++) {
			if(polArr[1].getMonomList().get(i).getCoeff() != 0) 
			{
				text = text.concat(polArr[1].getMonomList().get(i).monomToString());
				rZero++;
			}
		}
		if(rZero == 0)
		{
			text = text.concat("0");
		}
		return text;
	}

	public static void main(String[] args) {
		Monom mon1 = new Monom(3,2);
		Monom mon2 = new Monom(2,1);  
		Monom mon33 = new Monom(1,0);
		Monom mon3 = new Monom(1,1);
		//Monom mon4 = new Monom(1,0);
		List <Monom> l1 = new ArrayList<Monom>();
		List <Monom> l2 = new ArrayList<Monom>();
		l1.add(mon1);
		l1.add(mon2);
		l1.add(mon33);
		//l2.add(mon33);
		l2.add(mon3);
	//	l2.add(mon4);
		Polynom pol1 = new Polynom(l1);
		Polynom pol2 = new Polynom(l2);
		String rez1 = pol1.polynomToString();
		String rez2 = pol2.polynomToString();
		Polynom[] pol3 = pol1.divPolynoms(pol2);
		String rez3 = pol1.polynomArrToString(pol3);
	//	Polynom pol3 = pol1.derivPolyynom();
	//	String rez3 = pol3.polynomToString();
		System.out.println(rez1 + " " + rez2 + " " + rez3 ); 
	}   
}
	







