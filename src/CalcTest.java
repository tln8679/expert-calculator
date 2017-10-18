/*
 * @author Taylor Noble
 * Assignment 5: My Calculator
 */
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class CalcTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalcTest() {
		setTitle("Calc Test");
		setSize(800, 800);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		CalcTest ct = new CalcTest();
		Container c = ct.getContentPane();
		c.setLayout(new FlowLayout());

		int width = 800;
		int height = 800;
		c.add(new Calculator(width, height));

		ct.setVisible(true);

	}

}
