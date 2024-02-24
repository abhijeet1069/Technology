package swing.javaBook.eventHandling.sameClass;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class HandleEventWithinClass extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField textField;
	
	HandleEventWithinClass(){
		textField = new TextField();
		textField.setBounds(60,50,180,25);
		
		Button button = new Button("Click?");
		button.setBounds(100,120,80,30);
		
		//register component with listener
		button.addActionListener(this);
		
		add(textField);
		add(button);
		setSize(200,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText("Button clicked!!");
		
	}
	
	public static void main(String[] args) {
		new HandleEventWithinClass();

	}	

}
