package org.vaadin.textfieldformatter;

import javax.servlet.annotation.WebServlet;

import org.vaadin.textfieldformatter.CreditCardFieldFormatter.CreditCardType;
import org.vaadin.textfieldformatter.samples.BlocksFormatterSample;
import org.vaadin.textfieldformatter.samples.CreditCardFormatterSample;
import org.vaadin.textfieldformatter.samples.CustomNumeralFormatterSample;
import org.vaadin.textfieldformatter.samples.DelimitersFormatterSample;
import org.vaadin.textfieldformatter.samples.NumeralFormatterSample;
import org.vaadin.textfieldformatter.samples.NumericFormatterSample;
import org.vaadin.textfieldformatter.samples.PrefixFormatterSample;

import com.kbdunn.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private static final String STYLE_CC_UNKNOWN = "cc-unknown";

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		DemoLayout demo = new DemoLayout();
		setContent(demo);
		initCodeSamples(demo);
	}

	private void initCodeSamples(DemoLayout demo) {
		CreditCardFieldFormatter formatter = CreditCardFormatterSample.getFormatter();
		formatter.extend(demo.creditCardField);
		demo.creditCardCode.setCode(CreditCardFormatterSample.class);
		formatter.addCreditCardChangedListener(e -> setCCIcon(demo.creditCardField, e.getCreditCardType()));

		NumeralFormatterSample.getFormatter().extend(demo.numeralField);
		demo.numeralCode.setCode(NumeralFormatterSample.class);

		CustomNumeralFormatterSample.getFormatter().extend(demo.customNumeralField);
		demo.customNumeralCode.setCode(CustomNumeralFormatterSample.class);

		BlocksFormatterSample.getFormatter().extend(demo.blocksField);
		demo.blocksCode.setCode(BlocksFormatterSample.class);

		NumericFormatterSample.getFormatter().extend(demo.numericField);
		demo.numericCode.setCode(NumericFormatterSample.class);

		DelimitersFormatterSample.getFormatter().extend(demo.delimitersField);
		demo.delimitersCode.setCode(DelimitersFormatterSample.class);

		PrefixFormatterSample.getFormatter().extend(demo.prefixField);
		demo.prefixCode.setCode(PrefixFormatterSample.class);
	}

	private void setCCIcon(TextField field, CreditCardType ccType) {
		if (ccType.equals(CreditCardType.UNKNOWN)) {
			field.addStyleName(STYLE_CC_UNKNOWN);
		} else {
			field.removeStyleName(STYLE_CC_UNKNOWN);
		}
		switch (ccType) {
		case VISA:
			field.setIcon(FontAwesome.CC_VISA);
			break;
		case AMEX:
			field.setIcon(FontAwesome.CC_AMEX);
			break;
		case DINERS:
			field.setIcon(FontAwesome.CC_DINERS_CLUB);
			break;
		case DISCOVER:
			field.setIcon(FontAwesome.CC_DISCOVER);
			break;
		case MASTERCARD:
			field.setIcon(FontAwesome.CC_MASTERCARD);
			break;
		case JCB:
			field.setIcon(FontAwesome.CC_JCB);
			break;
		default:
			field.setIcon(FontAwesome.CREDIT_CARD);
			break;
		}
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
