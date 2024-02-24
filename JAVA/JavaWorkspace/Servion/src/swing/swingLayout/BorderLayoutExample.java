package swing.swingLayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderLayoutExample extends JFrame{
	
	public BorderLayoutExample() {
		setSize(640,400);
		//setLocation(1920,0);
		setTitle("JFrame");
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("Label 1");
		//label1.setBounds(10,10,100,20);
		add(label1, BorderLayout.NORTH);
		
		JButton button1 = new JButton("Button 1");
		//button1.setBounds(200,10,100,20);
		add(button1, BorderLayout.WEST);
		
		JLabel label2 = new JLabel("Label 2");
		//label2.setBounds(150,40,100,20);
		add(label2, BorderLayout.SOUTH);
		
		JButton button2 = new JButton("Button 2");
		//button2.setBounds(300,40,100,20);
		add(button2, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutExample();
	}
}
