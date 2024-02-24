package swing.swingLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GridLayoutExample extends JFrame{
	
	public GridLayoutExample() {
		setSize(640,400);
		//setLocation(1920,0);
		setTitle("JFrame");
		setLayout(new GridLayout(2,2));
		
		JLabel label1 = new JLabel("Label 1");
		//label1.setBounds(10,10,100,20);
		add(label1);
		
		JButton button1 = new JButton("Button 1");
		//button1.setBounds(200,10,100,20);
		add(button1);
		
		JLabel label2 = new JLabel("Label 2");
		//label2.setBounds(150,40,100,20);
		add(label2);
		
		JButton button2 = new JButton("Button 2");
		//button2.setBounds(300,40,100,20);
		add(button2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutExample();
	}
}
