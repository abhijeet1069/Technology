package com.satyam.xmlValidator.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.satyam.xmlValidator.control.ResetButtonListener;
import com.satyam.xmlValidator.control.ValidateButtonListener;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel xmlPanel, xsdPanel, statusPanel, buttonPanel, centerPanel, southPanel;
	private JLabel statusLabel;
	private JTextArea xmlTextArea, xsdTextArea;
	private JScrollPane xmlScrollPane, xsdScrollPane;
	JButton validateButton, resetButton;

	/**
	* Renders GUI and add action listeners
	*/
	public GUI(){
		setTitle("XML Validator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(800, 600);

		xmlPanel = new JPanel(new BorderLayout());
		xmlTextArea = new JTextArea();
		xmlScrollPane = new JScrollPane(xmlTextArea);
		TextLineNumber tln1 = new TextLineNumber(xmlTextArea);
		xmlScrollPane.setRowHeaderView(tln1);
		xmlPanel.add(xmlScrollPane, BorderLayout.CENTER);
		xmlPanel.setBorder(BorderFactory.createTitledBorder("XML"));

		xsdPanel = new JPanel(new BorderLayout());
		xsdTextArea = new JTextArea();
		xsdScrollPane = new JScrollPane(xsdTextArea);
		TextLineNumber tln2 = new TextLineNumber(xsdTextArea);
		xsdScrollPane.setRowHeaderView(tln2);
		xsdPanel.add(xsdScrollPane, BorderLayout.CENTER);
		xsdPanel.setBorder(BorderFactory.createTitledBorder("XSD"));

		centerPanel = new JPanel(new GridLayout(1, 2));

		centerPanel.add(xsdPanel);
		centerPanel.add(xmlPanel);

		add(centerPanel, BorderLayout.CENTER);

		statusPanel = new JPanel(new BorderLayout());
		statusLabel = new JLabel("");
		statusPanel.add(statusLabel, BorderLayout.CENTER);

		buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.setPreferredSize(new Dimension(getWidth(),getHeight()/15));
		validateButton = new JButton("Validate");
		resetButton = new JButton("Reset");
		buttonPanel.add(validateButton);
		buttonPanel.add(resetButton);

		southPanel = new JPanel(new GridLayout(2, 1));
		southPanel.add(statusPanel);
		southPanel.add(buttonPanel);

		add(southPanel, BorderLayout.SOUTH);

		//add action Listeners
		validateButton.addActionListener(new ValidateButtonListener(this));
		resetButton.addActionListener(new ResetButtonListener(this));

		setVisible(true);
	}
	
	/**
	* Get text of status label
	*/
	public String getStatusLabelText() {
		return statusLabel.getText();
	}
	
	/**
	* Set text of status label
	*/
	public void setStatusLabelText(String str) {
		this.statusLabel.setText(str);
	}

	/**
	* Get text of XSD text area
	*/
	public String getXsdTextAreaText() {
		return this.xsdTextArea.getText();
	}

	/**
	* Set text of XSD text area
	*/
	public void setXsdTextAreaText(String str) {
		this.xsdTextArea.setText(str);
	}
	
	/**
	* Get text of XML text area
	*/
	public String getXmlTextAreaText() {
		return this.xmlTextArea.getText();
	}

	/**
	* Set text of XML text area
	*/
	public void setXmlTextAreaText(String str) {
		this.xmlTextArea.setText(str);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new GUI();
		});
	}
}