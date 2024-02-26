package com.satyam.xmlValidator.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.satyam.xmlValidator.gui.GUI;



public class ResetButtonListener implements ActionListener{

	GUI gui;
	
	/**
	* Get current status of GUI to be manipulated via button
	*/
	public ResetButtonListener(GUI gui){
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.setStatusLabelText("");
		gui.setXsdTextAreaText("");
		gui.setXmlTextAreaText("");
		
	}
}
