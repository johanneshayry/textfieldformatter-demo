package org.vaadin.textfieldformatter.samples;

import org.vaadin.textfieldformatter.CustomStringBlockFormatter;
import org.vaadin.textfieldformatter.CustomStringBlockFormatter.Builder;

public class PrefixFormatterSample {
	public static CustomStringBlockFormatter getFormatter() {
		// {
		return new Builder()
				.blocks(4, 3, 3, 4)
				.delimiters(".", ".")
				.prefix("PREFIX", "-")
				.numeric()
				.build();
		// }
	}
}
