package hack1;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ImagePanelDemo {

	public static void main(String[] args) {
		ImagePanel panel = new ImagePanel(
				new ImageIcon("images/background.png").getImage());
		
		JFrame frame = new JFrame("Hack #1 : Create image-theme components");
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}
