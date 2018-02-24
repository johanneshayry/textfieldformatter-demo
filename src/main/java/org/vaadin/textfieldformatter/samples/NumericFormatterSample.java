package org.vaadin.textfieldformatter.samples;

import org.vaadin.textfieldformatter.CustomStringBlockFormatter;
import org.vaadin.textfieldformatter.CustomStringBlockFormatter.Options;

public class NumericFormatterSample {
	public static CustomStringBlockFormatter getFormatter() {
		// {
		Options options = new Options();
		options.setBlocks(4, 3, 3, 4);
		options.setNumericOnly(true);
		return new CustomStringBlockFormatter(options);
		// }
	}
}
