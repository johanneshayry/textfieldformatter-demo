package org.vaadin.textfieldformatter.samples;

import org.vaadin.textfieldformatter.CustomStringBlockFormatter;
import org.vaadin.textfieldformatter.CustomStringBlockFormatter.ForceCase;
import org.vaadin.textfieldformatter.CustomStringBlockFormatter.Options;

public class DelimitersFormatterSample {
	public static CustomStringBlockFormatter getFormatter() {
		// {
Options options = new Options();
options.setBlocks(3, 3, 2);
options.setDelimiters("-", ".");
options.setForceCase(ForceCase.UPPER);
return new CustomStringBlockFormatter(options);
		// }
	}
}
