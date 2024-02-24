package swing.oracleDocs.start;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class P1_HelloWorldSwing {
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Hello,World");
		frame.getContentPane().add(label);
		
		//frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
				System.out.println("Hello,WOrld");
				
			}
		});

	}

}
