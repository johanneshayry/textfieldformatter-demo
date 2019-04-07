package org.vaadin.textfieldformatter.demo;

import org.vaadin.textfieldformatter.CreditCardFieldFormatter;
import org.vaadin.textfieldformatter.samples.BlocksFormatterSample;
import org.vaadin.textfieldformatter.samples.CreditCardFormatterSample;
import org.vaadin.textfieldformatter.samples.CustomNumeralFormatterSample;
import org.vaadin.textfieldformatter.samples.DelimitersFormatterSample;
import org.vaadin.textfieldformatter.samples.NumeralFormatterSample;
import org.vaadin.textfieldformatter.samples.NumericFormatterSample;
import org.vaadin.textfieldformatter.samples.PrefixFormatterSample;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */

@Route("")
public class MainLayout extends VerticalLayout {

	private static final String STYLE_CC_UNKNOWN = "cc-unknown";

	private TextField creditCardField = new TextField();
	private CodeSample creditCardCode = new CodeSample();
	private TextField numeralField = new TextField();
	private CodeSample numeralCode = new CodeSample();
	private TextField customNumeralField = new TextField();
	private CodeSample customNumeralCode = new CodeSample();
	private TextField blocksField = new TextField();
	private CodeSample blocksCode = new CodeSample();
	private TextField numericField = new TextField();
	private CodeSample numericCode = new CodeSample();
	private TextField delimitersField = new TextField();
	private CodeSample delimitersCode = new CodeSample();
	private TextField prefixField = new TextField();
	private CodeSample prefixCode = new CodeSample();

	protected MainLayout() {
		initCodeSamples();
	}

	private void initCodeSamples() {

		CreditCardFieldFormatter formatter = CreditCardFormatterSample.getFormatter();
		creditCardField.setPlaceholder("Enter credit card number");
		creditCardField.setPrefixComponent(new Icon(VaadinIcon.CREDIT_CARD));
		formatter.extend(creditCardField);
		creditCardCode.setSample("Credit card number formatting", creditCardField, CreditCardFormatterSample.class);
		creditCardCode.setMaxWidth("700px");
		// formatter.addCreditCardChangedListener(e -> setCCIcon(demo.creditCardField,
		// e.getCreditCardType()));

		NumeralFormatterSample.getFormatter().extend(numeralField);
		numeralField.setPlaceholder("Enter numeral");
		numeralCode.setSample("Numeral formatting", numeralField, NumeralFormatterSample.class);
		numeralCode.setMaxWidth("700px");

		CustomNumeralFormatterSample.getFormatter().extend(customNumeralField);
		customNumeralField.setPlaceholder("Enter numeral");
		customNumeralCode.setSample("Custom numeral formatter", customNumeralField, CustomNumeralFormatterSample.class);
		customNumeralCode.setMaxWidth("700px");

		BlocksFormatterSample.getFormatter().extend(blocksField);
		blocksField.setPlaceholder("Blocks: [4, 3, 3, 4]");
		blocksCode.setSample("Custom blocks", blocksField, BlocksFormatterSample.class);
		blocksCode.setMaxWidth("700px");

		NumericFormatterSample.getFormatter().extend(numericField);
		numericField.setPlaceholder("Blocks: [4, 3, 3, 4] with numeric only");
		numericCode.setSample("Custom blocks with numeric only", numericField, NumericFormatterSample.class);
		numericCode.setMaxWidth("700px");

		DelimitersFormatterSample.getFormatter().extend(delimitersField);
		delimitersField.setPlaceholder("Delimiters:[\"-\", \".\"]");
		delimitersCode.setSample("Custom delimiters", delimitersField, DelimitersFormatterSample.class);
		delimitersCode.setMaxWidth("700px");

		PrefixFormatterSample.getFormatter().extend(prefixField);
		prefixCode.setSample("Custom blocks and delimiters and a prefix", prefixField, PrefixFormatterSample.class);
		prefixCode.setMaxWidth("700px");

		add(creditCardCode, numeralCode, customNumeralCode, blocksCode, numericCode, delimitersCode, prefixCode);

		setAlignItems(Alignment.CENTER);

	}

	// private void setCCIcon(TextField field, CreditCardType ccType) {
	// if (ccType.equals(CreditCardType.UNKNOWN)) {
	// field.addStyleName(STYLE_CC_UNKNOWN);
	// } else {
	// field.removeStyleName(STYLE_CC_UNKNOWN);
	// }
	// switch (ccType) {
	// case VISA:
	// field.setIcon(FontAwesome.CC_VISA);
	// break;
	// case AMEX:
	// field.setIcon(FontAwesome.CC_AMEX);
	// break;
	// case DINERS:
	// field.setIcon(FontAwesome.CC_DINERS_CLUB);
	// break;
	// case DISCOVER:
	// field.setIcon(FontAwesome.CC_DISCOVER);
	// break;
	// case MASTERCARD:
	// field.setIcon(FontAwesome.CC_MASTERCARD);
	// break;
	// case JCB:
	// field.setIcon(FontAwesome.CC_JCB);
	// break;
	// default:
	// field.setIcon(FontAwesome.CREDIT_CARD);
	// break;
	// }
	// }
}
