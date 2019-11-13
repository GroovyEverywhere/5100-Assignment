package Assignment8;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BasicCalculator extends BasicFrame{
	private JLabel firstNumber;
	private JLabel secondNumber;
	private JLabel computationMethod;
	private JLabel Result;
	private JTextField textOfFirstNumber;
	private JTextField textOfSecondNumber;
	private JComboBox options;
	private JButton computeButton;
	
	@Override
	public void create() {
		
		firstNumber = new JLabel ("First Number: ");
		secondNumber = new JLabel ("Second Number: ");
		computationMethod = new JLabel("Computation Method: ");
		Result = new JLabel ("Result of Your Computation: ");
		
		textOfFirstNumber = new JTextField(10);
		textOfSecondNumber = new JTextField(10);
		
		options = new JComboBox(new String [] { "+", "-", "*", "/"});
		computeButton = new JButton("Get Result");
	}
	
	
	@Override
	public void add(Container con) {
		JFrame frame = new JFrame("Calculator");
		GridLayout bl = new GridLayout(5,1);
		con.setLayout(bl);
		con.add(textOfFirstNumber);
		con.add(options);
		con.add(textOfSecondNumber);
		con.add(computeButton);
		con.add(Result);
	}
	
	public void calculation() {
			int a = 0;
			try {
				a = Integer.parseInt(textOfFirstNumber.getText());
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(this, "Number should be entered in the first text field");
				throw e;
			}
			int b = Integer.parseInt(textOfSecondNumber.getText());
			String choice = options.getSelectedItem().toString();
			int result = getResult(a, b, choice);
			Result.setText(Integer.toString(result));
		
	}
	
	
	public int getResult(int a, int b, String choice) {
		if (choice.equals("+")) {
			return a + b;
		}
		if (choice.equals("-")) {
			return a - b;
		}
		if (choice.equals("/") && b != 0) {
			return a / b;
		}
		return a * b;
	}
	
	
	@Override
	public void addListeners() {
		computeButton.addActionListener((e) -> calculation());
		
	}
	
	public static void main(String args []) {
		new BasicCalculator();
	}
}
