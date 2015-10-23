/**
 * Name: Yun-Chung Lin
 * ID: U1010425
 * Ex: Caculator-Innerclass
 * Information: 
 *		
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

public class Main extends JFrame {
	Font font = new Font("Arial", Font.BOLD, 20);// Set a preset font.
	int count = 0, countDot = 0; // count: Make sure +,-,*,/,= could only be
									// pressed one time.
									// counDot: Make sure the problem, such as
									// "54..21" could not be happened.
	static JTextField show = new JTextField(); // Show the expression by
												// Textfield.

	JButton B0 = new JButton("0"); // B0~B9: Button for number 0~9
	JButton B1 = new JButton("1");
	JButton B2 = new JButton("2");
	JButton B3 = new JButton("3");
	JButton B4 = new JButton("4");
	JButton B5 = new JButton("5");
	JButton B6 = new JButton("6");
	JButton B7 = new JButton("7");
	JButton B8 = new JButton("8");
	JButton B9 = new JButton("9");
	JButton BP = new JButton("+"); // BP: Button for PLUS(+).
	JButton BS = new JButton("-"); // BS: Button for SUBTRACT(-).
	JButton BM = new JButton("*"); // BM: Button for MULTIPLY(*).
	JButton BDD = new JButton("/"); // BDD: Button for DIVIDE(/).
	JButton BE = new JButton("="); // BE: Button for EQUAL(=).
	JButton Bd = new JButton("."); // Bd: Button for DOT(.).
	JButton C = new JButton("C"); // C: Button for CLEAR(C).

	public Main() {
		JPanel p1 = new JPanel();

		p1.setLayout(new GridLayout(4, 4));

		p1.add(B7); // Arrange the buttons.
		p1.add(B8);
		p1.add(B9);
		p1.add(BP);

		p1.add(B4);
		p1.add(B5);
		p1.add(B6);
		p1.add(BS);

		p1.add(B1);
		p1.add(B2);
		p1.add(B3);
		p1.add(BM);

		p1.add(B0);
		p1.add(BE);
		p1.add(Bd);
		p1.add(BDD);

		ButtonListener listener=new ButtonListener();

		B0.addActionListener(listener); // Add action listeners for each button.
		B1.addActionListener(listener);
		B2.addActionListener(listener);
		B3.addActionListener(listener);
		B4.addActionListener(listener);
		B5.addActionListener(listener);
		B6.addActionListener(listener);
		B7.addActionListener(listener);
		B8.addActionListener(listener);
		B9.addActionListener(listener);
		BP.addActionListener(listener);
		BS.addActionListener(listener);
		BM.addActionListener(listener);
		BDD.addActionListener(listener);
		BE.addActionListener(listener);
		Bd.addActionListener(listener);
		C.addActionListener(listener);

		JPanel p2 = new JPanel(new BorderLayout()); // Merge the panels into
													// one.
		p2.add(show, BorderLayout.NORTH);
		p2.add(p1, BorderLayout.CENTER);
		show.setEditable(false); // Let the Text field can't be edited through
									// keyboard.

		add(p2, BorderLayout.CENTER); // Put the merged panel onto the frame.
		add(C, BorderLayout.SOUTH); // Insert the CLEAR button at the bottom of
									// the frame.

		B0.setFont(font); // Change the font to the preset one to make the
							// letters more friendly.
		B1.setFont(font);
		B2.setFont(font);
		B3.setFont(font);
		B4.setFont(font);
		B5.setFont(font);
		B6.setFont(font);
		B7.setFont(font);
		B8.setFont(font);
		B9.setFont(font);
		BP.setFont(font);
		BS.setFont(font);
		BM.setFont(font);
		BDD.setFont(font);
		BE.setFont(font);
		Bd.setFont(font);
		C.setFont(font);
		show.setFont(font);
	}

	public static Main main1;

	public static void main(String[] args) {
		main1 = new Main();
		main1.setTitle("Calculator");
		main1.setSize(400, 400);
		main1.setLocationRelativeTo(null);
		main1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main1.setVisible(true);
	}

	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==B0) show.setText(show.getText() + "0");
			if(e.getSource()==B1) show.setText(show.getText() + "1");
			if(e.getSource()==B2) show.setText(show.getText() + "2");
			if(e.getSource()==B3) show.setText(show.getText() + "3");
			if(e.getSource()==B4) show.setText(show.getText() + "4");
			if(e.getSource()==B5) show.setText(show.getText() + "5");
			if(e.getSource()==B6) show.setText(show.getText() + "6");
			if(e.getSource()==B7) show.setText(show.getText() + "7");
			if(e.getSource()==B8) show.setText(show.getText() + "8");
			if(e.getSource()==B9) show.setText(show.getText() + "9");
			if(e.getSource()==BP){
				if (count < 10) {
					show.setText(show.getText() + "+");
					countDot = 0;
				}
				count = 10;
			}
			if(e.getSource()==BS){
				if (count < 10) {
					show.setText(show.getText() + "-");
					countDot = 0;
				}
				count = 11;
			}
			if(e.getSource()==BM){
				if (count < 10) {
					show.setText(show.getText() + "*");
					countDot = 0;
				}
				count = 12;
			}
			if(e.getSource()==BDD){
				if (count < 10) {
					show.setText(show.getText() + "/");
					countDot = 0;
				}
				count = 13;
			}
			if(e.getSource()==BE){
				double ans = 0, a = 0, b = 0;
				if (count != 0) {
					switch (count) {
						case 10:
							String aa[] = show.getText().split("\\+");
							a = Double.valueOf(aa[0]).doubleValue();
							b = Double.valueOf(aa[1]).doubleValue();
							ans = Add.addd(a, b);
							break;
						case 11:
							String as[] = show.getText().split("\\-");
							a = Double.valueOf(as[0]).doubleValue();
							b = Double.valueOf(as[1]).doubleValue();
							ans = Sub.sub(a, b);
							break;
						case 12:
							String am[] = show.getText().split("\\*");
							a = Double.valueOf(am[0]).doubleValue();
							b = Double.valueOf(am[1]).doubleValue();
							ans = Mul.mul(a, b);
							break;
						case 13:
							String ad[] = show.getText().split("\\/");
							a = Double.valueOf(ad[0]).doubleValue();
							b = Double.valueOf(ad[1]).doubleValue();
							ans = Dev.dev(a, b);
							break;
					}
					show.setText(String.valueOf(ans));// Don't forget to show
															// the full
															// equation.
					count = 0; // And let count back to zero.
				}
			}
			if(e.getSource()==Bd){
				if (countDot == 0) {
					show.setText(show.getText() + ".");
				}
				countDot = 1;
			}
			if(e.getSource()==C){
					show.setText("");
					countDot = 0;
					count = 0;
			}
			}
		}
	}
class Add {
	public static double addd(double a, double b) {
		BigDecimal b1 = new BigDecimal(Double.toString(a));
		BigDecimal b2 = new BigDecimal(Double.toString(b));
		return b1.add(b2).doubleValue();
	}
}
class Dev {
	public static double dev(double a, double b) {
		BigDecimal b1 = new BigDecimal(Double.toString(a));
		BigDecimal b2 = new BigDecimal(Double.toString(b));
		return b1.divide(b2).doubleValue();
	}
}
class Mul {
	public static double mul(double a, double b) {
		BigDecimal b1 = new BigDecimal(Double.toString(a));
		BigDecimal b2 = new BigDecimal(Double.toString(b));
		return b1.multiply(b2).doubleValue();
	}
}
class Sub {
	public static double sub(double a, double b) {
		BigDecimal b1 = new BigDecimal(Double.toString(a));
		BigDecimal b2 = new BigDecimal(Double.toString(b));
		return b1.subtract(b2).doubleValue();
	}
}
