package org.vaadin.textfieldformatter.demo;

import org.vaadin.textfieldformatter.CreditCardFieldFormatter;
import org.vaadin.textfieldformatter.CreditCardFieldFormatter.CreditCardType;
import org.vaadin.textfieldformatter.samples.CreditCardFormatterSample;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme(Lumo.class)
@Route("")
@PWA(name = "Project Base for Vaadin Flow", shortName = "Project Base")
public class MyUI extends DemoView {

	private static final String STYLE_CC_UNKNOWN = "cc-unknown";

	@Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        initCodeSamples();
	}

	private void initCodeSamples() {
		CreditCardFieldFormatter formatter = CreditCardFormatterSample.getFormatter();
		formatter.extend(creditCardField);
		creditCardCode.setCode(CreditCardFormatterSample.class);
//		formatter.addCreditCardChangedListener(e -> setCCIcon(creditCardField, e.getCreditCardType()));
//		new CodeHighlightExtension().extend(creditCardCode);
//
//		NumeralFormatterSample.getFormatter().extend(numeralField);
//		numeralCode.setCode(NumeralFormatterSample.class);
//		new CodeHighlightExtension().extend(numeralCode);
//
//		CustomNumeralFormatterSample.getFormatter().extend(customNumeralField);
//		customNumeralCode.setCode(CustomNumeralFormatterSample.class);
//		new CodeHighlightExtension().extend(customNumeralCode);
//
//		BlocksFormatterSample.getFormatter().extend(blocksField);
//		blocksCode.setCode(BlocksFormatterSample.class);
//		new CodeHighlightExtension().extend(blocksCode);
//
//		NumericFormatterSample.getFormatter().extend(numericField);
//		numericCode.setCode(NumericFormatterSample.class);
//		new CodeHighlightExtension().extend(numericCode);
//
//		DelimitersFormatterSample.getFormatter().extend(delimitersField);
//		delimitersCode.setCode(DelimitersFormatterSample.class);
//		new CodeHighlightExtension().extend(delimitersCode);
//
//		PrefixFormatterSample.getFormatter().extend(prefixField);
//		prefixCode.setCode(PrefixFormatterSample.class);
//		new CodeHighlightExtension().extend(prefixCode);
	}

	private void setCCIcon(TextField field, CreditCardType ccType) {
//		if (ccType.equals(CreditCardType.UNKNOWN)) {
//			field.addStyleName(STYLE_CC_UNKNOWN);
//		} else {
//			field.removeStyleName(STYLE_CC_UNKNOWN);
//		}
//		switch (ccType) {
//		case VISA:
//			field.setIcon(FontAwesome.CC_VISA);
//			break;
//		case AMEX:
//			field.setIcon(FontAwesome.CC_AMEX);
//			break;
//		case DINERS:
//			field.setIcon(FontAwesome.CC_DINERS_CLUB);
//			break;
//		case DISCOVER:
//			field.setIcon(FontAwesome.CC_DISCOVER);
//			break;
//		case MASTERCARD:
//			field.setIcon(FontAwesome.CC_MASTERCARD);
//			break;
//		case JCB:
//			field.setIcon(FontAwesome.CC_JCB);
//			break;
//		default:
//			field.setIcon(FontAwesome.CREDIT_CARD);
//			break;
//		}
	}
}
