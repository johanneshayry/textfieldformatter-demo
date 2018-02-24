package org.vaadin.textfieldformatter.samples;

import org.vaadin.textfieldformatter.CreditCardFieldFormatter;

public class CreditCardFormatterSample {

	public static CreditCardFieldFormatter getFormatter() {
		// {
		// American Express: starts with 34/37
		// VISA: starts with 4
		// Diners Club: starts with 300-305/309...
		// MasterCard: starts with 51-55/22-27
		// JCB: starts with 2131/1800/35
		// Discover: starts with 6011|65|644-649
		CreditCardFieldFormatter formatter = new CreditCardFieldFormatter();
		formatter.addCreditCardChangedListener(e -> {
			// Any custom behavior based on the event
			e.getCreditCardType();
		});
		// }
		return formatter;
	}
}
