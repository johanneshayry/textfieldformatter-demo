package org.vaadin.textfieldformatter.it;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.internal.junitrunner.DriverPathLoader;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.TextFieldElement;

public class SimpleIT extends AbstractIT {

	@Test
	public void starts() {
		getDriver().get("http://localhost:8080");
		TextFieldElement textField = $(TextFieldElement.class).first();
		textField.sendKeys("text");
		Assert.assertEquals("text", textField.getValue());
	}
}
