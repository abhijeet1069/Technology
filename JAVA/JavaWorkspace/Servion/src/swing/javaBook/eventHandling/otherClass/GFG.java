package swing.javaBook.eventHandling.otherClass;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;

public class GFG extends Frame{
	
	private static final long serialVersionUID = 1L;
	
	TextField textField;
	
	GFG(){
		textField = new TextField();
		
		textField.setBounds(60,50,180,25);
		Button button = new Button("Click");
		button.setBounds(100,120,80,30);
		
		Other other = new Other(this);
		button.addActionListener(other); //register
		
		add(textField);
		add(button);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		new GFG();
	}
	
}
