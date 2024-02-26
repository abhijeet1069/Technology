package com.satyam.swingxmlValidator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.satyam.xmlValidator.core.XMLValidator;

public class XMLValidatorTest {

	@Test
	public void test() {
		XMLValidator xmlValidator = new XMLValidator();
		
		xmlValidator.xmlValidate("", "");
	}

}
