package org.vaadin.textfieldformatter.it;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.github.webdriverextensions.internal.junitrunner.DriverPathLoader;
import com.vaadin.testbench.TestBenchTestCase;

public abstract class AbstractIT extends TestBenchTestCase {

	@BeforeClass
	public static void setupClass() {
		DriverPathLoader.loadDriverPaths(null);
	}

	@Before
	public void setup() {
		ChromeOptions opt = new ChromeOptions();
		String headless = System.getProperty("test.headless");
		if (headless != null && Boolean.valueOf(headless)) {
			opt.setHeadless(true);
		}
		ChromeDriver driver = new ChromeDriver(opt);
		setDriver(driver);
		WebDriverExtensionsContext.setDriver(driver);
	}

	@After
	public void teardown() {
		getDriver().quit();
	}
}
