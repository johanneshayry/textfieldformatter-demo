package org.vaadin.textfieldformatter.samples;

import java.time.LocalDate;

import org.vaadin.textfieldformatter.DateFieldFormatter;

public class DateFieldFormatterSample {
	public static DateFieldFormatter getFormatter() {
		// {
return new DateFieldFormatter(
  "yyyyMMdd",
  LocalDate.of(1900, 01, 01),
  LocalDate.of(2019, 9, 3),
  "-");
		// }
	}
}
