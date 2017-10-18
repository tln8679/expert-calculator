/*
 * @author Taylor Noble
 * Assignment 5: My Calculator
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 * New keypad that is a JComponenet Will handle the Buttons on the calculator
 * and how the button interactions are handled Interacts with the display
 */
public class Keypad extends JComponent {
	private static final long serialVersionUID = 1L;
	private Display display;
	private int height;
	private JButton clearButton; // Wrote a separate function to clear the display
	private String prev_answer; // Stores the value of the parsed result of an expression when = is pressed
	private boolean next_expression; // When the = button has been hit this changes to true to show that a new
										// expression is going to start
	MyMathParser Parse = new MyMathParser(); // Parses my mathematical expressions

	/**
	 * 
	 * @param width:
	 *            of JPanel
	 * @param height:
	 *            of JPanel
	 * @param display:
	 *            the display for the calculator (need the text field value, to
	 *            handle button actions and evaluations)
	 */
	public Keypad(int width, int height, Display display) {
		this.display = display;
		this.height = height;
		next_expression = false;
		prev_answer = "0";

		setLayout(new GridLayout(5, 4)); // 5 rows, 4 columns of buttons
		setPreferredSize(new Dimension(width - 100, height - 50));
		setBorder(BorderFactory.createLineBorder(Color.red, 4));

		// adding the buttons to the component using addButton function that creates the
		// button and handles its actions
		addButton("Ans");
		addButton("");
		addButton("");
		// Add clear entry button
		clearButton = new JButton("AC");
		clearButton.setFont(new Font("Arial", Font.BOLD, height / 12));
		add(clearButton);

		// Add digit buttons
		addButton("7");
		addButton("8");
		addButton("9");
		addButton("/");

		addButton("4");
		addButton("5");
		addButton("6");
		addButton("x");

		addButton("1");
		addButton("2");
		addButton("3");
		addButton("-");

		addButton("0");
		addButton(".");
		addButton("=");
		addButton("+");

		class ClearButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				display.setValue(" ");
			}
		}
		clearButton.addActionListener(new ClearButtonListener());
	}

	/**
	 * Adds a button to the button panel and creates an action listener for the
	 * button and sets the font. Handles all actions for each button label.
	 * 
	 * @param label:
	 *            the button label
	 * 
	 */
	private void addButton(final String label) {
		class DigitButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				// Append label text to button
				if (label == "+" || label == "-" || label == "/" || label == "x") {
					next_expression = false;
					// Checking to make sure no two operators are placed next to each other
					if (Character.toString(display.getText().charAt(display.getText().length() - 1)).equals(" ")) {
						return;
					} // Separates an operator from the numbers
					else {
						// Add a space between the operator and operand
						display.setValue(display.getText() + " " + label + " ");
					}
				} else if (label.equals("=")) {
					// Fixes an empty expression error
					if(display.getText().equals(" ")){
						display.setValue("0");
						return;
					}
					else if (display.getText().contains("Ans")) {
						// If the expression includes "Ans" we need to replace it with its value
						String x = display.getText().replaceAll("Ans", prev_answer);
						display.setValue(x);
					}// Checks to see if an operator is at the end
					else if(display.getText().length()>=2) { //did this so i don't get an out of bounds exception
						if(Character.toString(display.getText().charAt(display.getText().length() - 2)).equals("+") || 
							Character.toString(display.getText().charAt(display.getText().length() - 2)).equals("-") || 
							Character.toString(display.getText().charAt(display.getText().length() - 2)).equals("/") || 
							Character.toString(display.getText().charAt(display.getText().length() - 2)).equals("x")){
						return;}
					}
					// Parse the expression
					display.setValue(Parse.parse(display.getText()));
					// Stores the evaluated expression (we need this for the "Ans" function)
					prev_answer = Parse.parse(display.getText());
					// Set this boolean to true, so the calculator knows it's starting a new expression
					next_expression = true;
				} else if (label.equals("Ans")) {
					display.setValue(display.getText() + label);
				} else if (label.equals(".") && display.getText().indexOf(".") != -1) {
					return;
					// Don't want the user to put two decimals next to each other. A decimal
					// followed by no number will be trimmed when
					// parsed.
				} else if (label.equals("x") && display.getText().indexOf(".") != -1) {
					return;
				}

				else {
					// If this is a new expression and the user enters a number, the text field clears
					// If it's new and an operator is entered, the previous result will be included in the expression
					if (next_expression && label.matches("[0-9]")) {
						display.setValue("");
						next_expression = false;
					}
					// Adds numbers to the text field
					display.setValue(display.getText() + label);
				}
			}

		}
		// Creates buttons and gives them listeners and sets a new font
		JButton button = new JButton(label);
		button.setFont(new Font("Arial", Font.BOLD, height / 12));
		add(button);
		ActionListener listener = new DigitButtonListener();
		button.addActionListener(listener);
	}
}
