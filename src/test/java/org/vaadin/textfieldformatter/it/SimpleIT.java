package org.vaadin.textfieldformatter.it;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.TextFieldElement;

public class SimpleIT extends AbstractIT {

	@Test
	public void starts() {
		getDriver().get("http://localhost:8080");
		TextFieldElement textField = $(TextFieldElement.class).first();
		textField.sendKeys("41004100");
		Assert.assertEquals("4100 4100 ", textField.getValue());
	}
}
