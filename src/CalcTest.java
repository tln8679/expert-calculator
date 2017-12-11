/*
 * @author Taylor Noble
 * Assignment 5: My Calculator
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CalcTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double windowWidth;
	private double windowHeight;
	

	public CalcTest() {
		setTitle("Taylor Noble's Calculator");	
		windowWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		windowHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setSize((int)windowWidth/3, (int)windowHeight/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		CalcTest ct = new CalcTest();
		Container c = ct.getContentPane();
		c.setLayout(new FlowLayout());

		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		c.add(new Calculator(width/3-50, height/2-50));
		
		ct.setVisible(true);

	}

}
