package com.satyam.xmlValidator.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.satyam.xmlValidator.core.XMLValidator;
import com.satyam.xmlValidator.gui.GUI;


public class ValidateButtonListener implements ActionListener{

	GUI gui;
	
	/**
	* Get current status of GUI to be manipulated via button
	*/
	public ValidateButtonListener(GUI gui){
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String xsd = gui.getXsdTextAreaText();
		String xml = gui.getXmlTextAreaText();
		
		XMLValidator xmlValidator = new XMLValidator();
		
		String status = xmlValidator.xmlValidate(xsd, xml);
		
		gui.setStatusLabelText(status);
	}
}
