import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View view;
	
	public Controller(View view) {
		this.view = view;
		view.addActionListener(new Add(), new Subb(), new Multp(), new Deriv(), new Integr(), new Div());
	}
	
	class Add implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Polynom pol1 = view.textToPolynom(view.getPolTxt1());
			Polynom pol2 = view.textToPolynom(view.getPolTxt2());
			Polynom rez = pol1.addPolynoms(pol2);
			String s = rez.polynomToString();
			view.setPolRez(s);
		}
	}
	
	class Subb implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Polynom pol1 =view.textToPolynom(view.getPolTxt1());
			Polynom pol2 = view.textToPolynom(view.getPolTxt2());
			Polynom rez = pol1.subbPolynoms(pol2);
			String s = rez.polynomToString();
			view.setPolRez(s);
		}
	}
	
	class Multp implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Polynom pol1 =view.textToPolynom(view.getPolTxt1());
			Polynom pol2 = view.textToPolynom(view.getPolTxt2());
			Polynom pol3 = pol1.multpPolynoms(pol2);
			String s = pol3.polynomToString();
			view.setPolRez(s);
		}
	}
	
	class Div implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Polynom pol1 =view.textToPolynom(view.getPolTxt1());
			Polynom pol2 = view.textToPolynom(view.getPolTxt2());
			if(pol2.getMonomList().get(0).getCoeff() != 0)
			{
				Polynom pol3[] = pol1.divPolynoms(pol2);
				String s = pol1.polynomArrToString(pol3);
				view.setPolRez(s);
			}
			else
			{
				view.setPolRez("Can not divide by 0");
			}
			
		}
		
	}
	
	class Deriv implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Polynom pol = view.textToPolynom(view.getPolTxt1());
			Polynom rez = pol.derivPolyynom();
			String s = rez.polynomToString();
			view.setPolRez(s);
		}
	}
	
	class Integr implements  ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Polynom pol = view.textToPolynom(view.getPolTxt1());
			Polynom rez = pol.integrPolyynom();
			String s = rez.polynomToString();
			view.setPolRez(s);
		}
	}
	
}
