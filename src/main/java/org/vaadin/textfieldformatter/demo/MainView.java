package org.vaadin.textfieldformatter.demo;

import java.util.Arrays;
import java.util.List;

import org.vaadin.textfieldformatter.CreditCardFieldFormatter;
import org.vaadin.textfieldformatter.CreditCardFieldFormatter.CreditCardType;
import org.vaadin.textfieldformatter.samples.BlocksFormatterSample;
import org.vaadin.textfieldformatter.samples.CreditCardFormatterSample;
import org.vaadin.textfieldformatter.samples.CustomNumeralFormatterSample;
import org.vaadin.textfieldformatter.samples.DelimitersFormatterSample;
import org.vaadin.textfieldformatter.samples.NumeralFormatterSample;
import org.vaadin.textfieldformatter.samples.NumericFormatterSample;
import org.vaadin.textfieldformatter.samples.PrefixFormatterSample;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
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
public class MainView extends VerticalLayout {

	private static final String STYLE_CC_UNKNOWN = "cc-unknown";

	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);
		setWidthFull();
		setSpacing(true);
		setAlignItems(Alignment.CENTER);
		add(new H1("TextField Formatter Usage Examples"));
		initCodeSamples();
	}

	private void initCodeSamples() {
		Example creditCardExample = new Example(this::createCreditCardField, CreditCardFormatterSample.class);
		Example numeralExample = new Example(this::createNumeralField, NumeralFormatterSample.class);
		Example customNumeralExample = new Example(this::createCustomNumeralField, CustomNumeralFormatterSample.class);
		Example blocksExample = new Example(this::createBlocksField, BlocksFormatterSample.class);
		Example numericExample = new Example(this::createNumericField, NumericFormatterSample.class);
		Example delimitersExample = new Example(this::createDelimitersField, DelimitersFormatterSample.class);
		Example prefixExample = new Example(this::createPrefixField, PrefixFormatterSample.class);
		addWithFullWidth(Arrays.asList(creditCardExample, numeralExample, customNumeralExample, blocksExample,
				numericExample, delimitersExample, prefixExample));
	}

	private <T extends Component & HasSize> void addWithFullWidth(List<T> components) {
		components.forEach(c -> {
			c.setWidthFull();
			add(c);
		});
	}

	private Component createCreditCardField() {
		TextField creditCardField = new TextField("Credit card number formatting", "Enter a dummy credit card number");
		Icon icon = VaadinIcon.CREDIT_CARD.create();
		creditCardField.setPrefixComponent(icon);
		CreditCardFieldFormatter formatter = CreditCardFormatterSample.getFormatter();
		formatter.extend(creditCardField);
//		formatter.addCreditCardChangedListener(e -> setCCIcon(creditCardField, e.getCreditCardType()));
		return creditCardField;
	}

	private Component createNumeralField() {
		TextField field = new TextField("Default numeral formatting", "Enter numeral");
		NumeralFormatterSample.getFormatter().extend(field);
		return field;
	}

	private Component createCustomNumeralField() {
		TextField field = new TextField("Custom numeral formatting", "Enter numeral");
		CustomNumeralFormatterSample.getFormatter().extend(field);
		return field;
	}

	private Component createBlocksField() {
		TextField field = new TextField("Custom options", "xxxx xxx xxx xxxx");
		BlocksFormatterSample.getFormatter().extend(field);
		return field;
	}

	private Component createNumericField() {
		TextField field = new TextField();
		field.setPlaceholder("####-###-###-####");
		NumericFormatterSample.getFormatter().extend(field);
		return field;
	}

	private Component createDelimitersField() {
		TextField field = new TextField();
		field.setPlaceholder("XXX-XXX.XX");
		DelimitersFormatterSample.getFormatter().extend(field);
		return field;
	}

	private Component createPrefixField() {
		TextField field = new TextField();
		field.setPlaceholder("PREFIX-");
		PrefixFormatterSample.getFormatter().extend(field);
		return field;
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
