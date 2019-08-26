package org.vaadin.textfieldformatter.samples;

import org.vaadin.textfieldformatter.NumeralFieldFormatter;

public class CustomNumeralFormatterSample {
	public static NumeralFieldFormatter getFormatter() {
		// {
return new NumeralFieldFormatter(" ", ",", 1);
		// }
	}
}
