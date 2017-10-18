/*
 * @author Taylor Noble
 * Assignment 5: My Calculator
 */
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Calculator extends JPanel {
	private static final long serialVersionUID = 1L;
	private Display display;
	private Keypad keypad;
	/**
	 * 
	 * @param width: width of the calculator JPanel
	 * @param height: height of the calculator JPanel
	 */
	public Calculator(int width, int height) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.black, 6));

		display = new Display(width);
		keypad = new Keypad(width, height - 50, display);
		
		// add the display and the keypad to the calculator.
		add(display, BorderLayout.NORTH);
		add(keypad, BorderLayout.CENTER);

	}

}
