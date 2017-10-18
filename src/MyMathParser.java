/*
 * @author Taylor Noble
 * Assignment 5: My Calculator
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMathParser {
	/**
	 * 
	 * @param expression: This takes in a mathematical expression as a string with operators and operands delimited by a space.
	 * @return the evaluated expression, taking precedence into account.
	 */
	public String parse(String expression) {
		// Breaking the operators and operands into pieces and storing in an ArrayList
		String[] items = expression.trim().split(" ");
		List<String> tokens = new ArrayList<String>(Arrays.asList(items));
		// While there is a multiplication or division operator left in the ArrayList, do those operations first then remove the operators
		// and the operands; Replace them with the quotient or product
		if(tokens.size() == 1){
			return tokens.get(0);
		}
		while (tokens.contains("x") || tokens.contains("/")) {
			for (int i = 0; i < tokens.size() - 1; i++) {
				if (tokens.get(i).equals("x")) {
					tokens.add(i, String
							.valueOf(Double.parseDouble(tokens.get(i - 1)) * Double.parseDouble(tokens.get(i + 1))));
					tokens.remove(i + 1);
					tokens.remove(i + 1);
					tokens.remove(i - 1);}
				else if (tokens.get(i).equals("/")) {
					tokens.add(i, String
							.valueOf(Double.parseDouble(tokens.get(i - 1)) / Double.parseDouble(tokens.get(i + 1))));
					tokens.remove(i + 1);
					tokens.remove(i + 1);
					tokens.remove(i - 1);
				}
			}
		}

		while (tokens.contains("-") || tokens.contains("+")) {
			// After multiplication and division is done, iterate through the rest and do any adding and subtraction.
			for (int i = 0; i < tokens.size() - 1; i++) {
				if (tokens.get(i).equals("-")) {
					tokens.add(i, String
							.valueOf(Double.parseDouble(tokens.get(i - 1)) - Double.parseDouble(tokens.get(i + 1))));
					tokens.remove(i + 1);
					tokens.remove(i + 1);
					tokens.remove(i - 1);
				} else if(tokens.get(i).equals("+")) {
					tokens.add(i, String
							.valueOf(Double.parseDouble(tokens.get(i - 1)) + Double.parseDouble(tokens.get(i + 1))));
					tokens.remove(i + 1);
					tokens.remove(i + 1);
					tokens.remove(i - 1);
				}				
			}	
		}
		// Tokens is now a list of size 1. Extract that value as a string.
		return tokens.get(0);

	}
}
