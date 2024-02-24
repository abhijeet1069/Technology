package swing.javaBook.eventHandling.otherClass.mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StringLengthUI{
	JFrame frame;
	JPanel panel;
	JTextField textField;
	JButton button;
	JLabel label;
	
	StringLengthUI(){
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculate string length");
		frame.setSize(400,400);
		
		label = new JLabel("test_label");
		button = new MyButton("Click");
		textField = new JTextField("text");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new FlowLayout());
		panel.add(button);
		//panel.add(label);
		//panel.add(textField);
		frame.add(panel,BorderLayout.NORTH);
		
		frame.setVisible(true);
		
	}
}
