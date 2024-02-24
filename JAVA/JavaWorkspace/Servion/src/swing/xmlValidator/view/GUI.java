package swing.xmlValidator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GUI extends JFrame{

	private JTextArea textArea1, textArea2;
	private JButton copyButton;
	private JLabel label;
	
	public GUI(){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create a JFrame
                JFrame frame = new JFrame("BorderLayout Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                // Add components to different regions
                frame.add(new JButton("North"), BorderLayout.NORTH);
                frame.add(new JButton("South"), BorderLayout.SOUTH);
                frame.add(new JButton("West"), BorderLayout.WEST);
                frame.add(new JButton("East"), BorderLayout.EAST);

                // Create JPanel for first text area
                JPanel textAreaPanel1 = new JPanel(new BorderLayout());
                JTextArea textArea1 = new JTextArea();
                textAreaPanel1.add(textArea1, BorderLayout.CENTER);
                textAreaPanel1.setBorder(BorderFactory.createTitledBorder("XML"));

                // Create JPanel for second text area
                JPanel textAreaPanel2 = new JPanel(new BorderLayout());
                JTextArea textArea2 = new JTextArea();
                textAreaPanel2.add(textArea2, BorderLayout.CENTER);
                textAreaPanel2.setBorder(BorderFactory.createTitledBorder("XSD"));

                // Create JPanel to hold both text area panels
                JPanel centerPanel = new JPanel(new GridLayout(1, 2));
                centerPanel.add(textAreaPanel1);
                centerPanel.add(textAreaPanel2);

                // Add the center JPanel to the center of the BorderLayout
                frame.add(centerPanel, BorderLayout.CENTER);

                // Make the frame visible
                frame.setSize(600, 400);
                frame.setVisible(true);
            }
        });
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GUI();
				
			}
		});
	}
}
