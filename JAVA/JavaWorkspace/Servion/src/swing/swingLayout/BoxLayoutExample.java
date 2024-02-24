package swing.swingLayout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BoxLayoutExample extends JFrame{
	
	public BoxLayoutExample() {
		setSize(640,400);
		//setLocation(1920,0);
		setTitle("JFrame");
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel label1 = new JLabel("Label 1");
		label1.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(label1);
		
		JButton button1 = new JButton("Button 1");
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button1);
		
		JLabel label2 = new JLabel("Label 2");
		label1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(label2);
		
		JButton button2 = new JButton("Button 2");
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BoxLayoutExample();
	}
}
