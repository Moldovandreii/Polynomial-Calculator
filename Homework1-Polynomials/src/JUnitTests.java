import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class JUnitTests {

	@Test
	void testMonomAddition() {
		Monom m1 = new Monom(6, 2);
		Monom m2 = new Monom(3, 2);
		Monom m3 = m1.addMonoms(m2);
		String output = m3.monomToString();
		assertEquals("+9x^2", output);
	}

	@Test
	void testMonomSubtraction() {
		Monom m1 = new Monom(6, 2);
		Monom m2 = new Monom(3, 2);
		Monom m3 = m1.subbMonoms(m2);
		String output = m3.monomToString();
		assertEquals("+3x^2", output);
	}
	
	@Test
	void testMonomMultiplication() {
		Monom m1 = new Monom(6, 2);
		Monom m2 = new Monom(3, 2);
		Monom m3 = m1.multpMonoms(m2);
		String output = m3.monomToString();
		assertEquals("+18x^4", output);
	}

	@Test
	void testMonomDivision() {
		Monom m1 = new Monom(6, 2);
		Monom m2 = new Monom(3, 2);
		Monom m3 = m1.divMonoms(m2);
		String output = m3.monomToString();
		assertEquals("+2", output);
	}

	@Test
	void testMonomDifferentiation() {
		Monom m1 = new Monom(6, 2);
		Monom m2 = m1.derivMonom();
		String output = m2.monomToString();
		assertEquals("+12x^1", output);
	}
	
	@Test
	void testMonomIntergration() {
		Monom m1 = new Monom(6, 2);
		Monom m2 = m1.integrMonom();
		String output = m2.monomToString();
		assertEquals("+2x^3", output);
	}
	
	@Test
	void testPolynomAddition() {
		List<Monom> pol1 = new ArrayList<Monom>();
		List<Monom> pol2 = new ArrayList<Monom>();
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(4,1);
		Monom m3 = new Monom(1,1);
		Monom m4 = new Monom(-4,0);
		pol1.add(m1);
		pol1.add(m2);
		pol2.add(m3);
		pol2.add(m4);
		Polynom p1 = new Polynom(pol1);
		Polynom p2 = new Polynom(pol2);
		Polynom rez = p1.addPolynoms(p2);
		String output = rez.polynomToString();
		assertEquals("+3x^2+5x^1-4", output);
	}
	
	@Test
	void testPolynomSubtraction() {
		List<Monom> pol1 = new ArrayList<Monom>();
		List<Monom> pol2 = new ArrayList<Monom>();
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(4,1);
		Monom m3 = new Monom(1,1);
		Monom m4 = new Monom(-4,0);
		pol1.add(m1);
		pol1.add(m2);
		pol2.add(m3);
		pol2.add(m4);
		Polynom p1 = new Polynom(pol1);
		Polynom p2 = new Polynom(pol2);
		Polynom rez = p1.subbPolynoms(p2);
		String output = rez.polynomToString();
		assertEquals("+3x^2+3x^1+4", output);
	}
	
	@Test
	void testPolynomMultiplication() {
		List<Monom> pol1 = new ArrayList<Monom>();
		List<Monom> pol2 = new ArrayList<Monom>();
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(4,1);
		Monom m3 = new Monom(1,1);
		Monom m4 = new Monom(-4,0);
		pol1.add(m1);
		pol1.add(m2);
		pol2.add(m3);
		pol2.add(m4);
		Polynom p1 = new Polynom(pol1);
		Polynom p2 = new Polynom(pol2);
		Polynom rez = p1.multpPolynoms(p2);
		String output = rez.polynomToString();
		assertEquals("+3x^3-8x^2-16x^1", output);
	}
	
	@Test
	void testPolynomDivision() {
		List<Monom> pol1 = new ArrayList<Monom>();
		List<Monom> pol2 = new ArrayList<Monom>();
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(4,1);
		Monom m3 = new Monom(1,1);
		Monom m4 = new Monom(-4,0);
		pol1.add(m1);
		pol1.add(m2);
		pol2.add(m3);
		pol2.add(m4);
		Polynom p1 = new Polynom(pol1);
		Polynom p2 = new Polynom(pol2);
		Polynom[] rez = p1.divPolynoms(p2);
		String output = p1.polynomArrToString(rez);
		assertEquals("q=+3x^1+16, r=+64", output);
	}
	
	@Test
	void testPolynomDifferentiation() {
		List<Monom> pol1 = new ArrayList<Monom>();
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(4,1);
		pol1.add(m1);
		pol1.add(m2);
		Polynom p1 = new Polynom(pol1);
		Polynom rez = p1.derivPolyynom();
		String output = rez.polynomToString();
		assertEquals("+6x^1+4", output);
	}
	
	@Test
	void testPolynomIntegration() {
		List<Monom> pol1 = new ArrayList<Monom>(); 
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(4,1);
		pol1.add(m1);
		pol1.add(m2);
		Polynom p1 = new Polynom(pol1);
		Polynom rez = p1.integrPolyynom();
		String output = rez.polynomToString();
		assertEquals("+1x^3+2x^2", output); 
	}	
	
}
