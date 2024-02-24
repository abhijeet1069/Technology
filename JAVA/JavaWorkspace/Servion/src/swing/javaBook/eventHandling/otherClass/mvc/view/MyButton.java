package swing.javaBook.eventHandling.otherClass.mvc.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class MyButton extends JButton{
	MyButton button;
	MyButton(String str){
		super(str);
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(null);
		setBounds(10,10,10,10);
		
	}
}
