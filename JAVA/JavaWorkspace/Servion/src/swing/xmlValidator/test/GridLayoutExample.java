package swing.xmlValidator.test;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExample {

	JFrame frame;
	int btnCount = 10;
	
	GridLayoutExample(){
		frame = new JFrame();
		JButton[] btnArr = new JButton[btnCount];
		
		for(int i = 0;i < btnCount; i++) {
			btnArr[i] = new JButton(""+(i+1));
			frame.add(btnArr[i]);
		}
		
		frame.setLayout(new GridLayout(2,5));
		frame.setSize(300,300);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new GridLayoutExample();

	}

}
