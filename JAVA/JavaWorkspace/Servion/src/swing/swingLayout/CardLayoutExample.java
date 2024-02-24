package swing.swingLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardLayoutExample extends JFrame{
	
	public CardLayoutExample() {
		setSize(640,400);
		//setLocation(1920,0);
		setTitle("JFrame");
		
		CardLayout cards = new CardLayout();
		setLayout(cards);
		
		JLabel label1 = new JLabel("Label 1");
		add(label1, "LABEL1");
		
		JButton button1 = new JButton("Button 1");
		add(button1, "BUTTON1");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cards.show(CardLayoutExample.this.getContentPane(),"BUTTON2");
			}
			
		});
		
		JLabel label2 = new JLabel("Label 2");
		add(label2, "LABEL2");
		
		JButton button2 = new JButton("Button 2");
		add(button2, "BUTTON2");
		
		cards.show(this.getContentPane(),"BUTTON1");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CardLayoutExample();
	}
}
