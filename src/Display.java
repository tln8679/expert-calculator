/*
 * @author Taylor Noble
 * Assignment 5: My Calculator
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class Display extends JComponent {
	private static final long serialVersionUID = 1L;
	private JTextField tf;
	/**
	 * 
	 * @param width: takes in the width of the calculator
	 * Constructs the area to display the calculator expressions
	 */
	public Display(int width) {
		setPreferredSize(new Dimension(width, 50));
		setBorder(BorderFactory.createLineBorder(Color.blue, 4));
		setLayout(new FlowLayout());
		tf = new JTextField(" ");
		tf.setPreferredSize(new Dimension(width - 70, 30));
		add(tf);
		
		Font font1 = new Font("Arial", Font.BOLD, 18);
		tf.setFont(font1);
	}
	/**
	 * 
	 * @param exp: Outputs operators and operands into the text field
	 */
	public void setValue(String exp) {
		tf.setText(exp);

	}
	/**
	 * 
	 * @return The text that is displayed in the text field.
	 */
	public String getText() {
		return tf.getText();
	}
	/**
	 * Clears the text field in the display screen
	 */
	public void clear() {
		tf.setText("");
	}

}
