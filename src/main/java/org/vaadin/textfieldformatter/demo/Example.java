package org.vaadin.textfieldformatter.demo;

import java.util.function.Supplier;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Example extends VerticalLayout {

	public Example(Supplier<Component> componentSupplier, Class<?> codeSampleClass) {
		Component field = componentSupplier.get();
		SampleCode sample = new SampleCode(codeSampleClass);
		getElement().getStyle().set("max-width", "700px");
		
		if (field instanceof HasSize) {
			((HasSize) field).setWidthFull();
		}
		sample.setWidthFull();
		add(field, sample);
	}
}
