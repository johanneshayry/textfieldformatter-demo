package org.vaadin.textfieldformatter.demo;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.ui.AbstractComponent;

@JavaScript({ "prism.js", "org_vaadin_textfieldformatter_demo_prism_connector.js" })
@StyleSheet("prism.css")
public class CodeHighlightExtension extends AbstractJavaScriptExtension {

	public void extend(AbstractComponent component) {
		super.extend(component);
	}
}
