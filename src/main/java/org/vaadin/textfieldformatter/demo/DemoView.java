package org.vaadin.textfieldformatter.demo;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the demo-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("demo-view")
@JsModule("demo-view.js")
public class DemoView extends PolymerTemplate<DemoView.DemoViewModel> {


    @Id("creditCardCode")
	protected SampleCode creditCardCode;
    
    @Id
    protected TextField creditCardField;

	/**
     * Creates a new DemoView.
     */
    public DemoView() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between DemoView and demo-view
     */
    public interface DemoViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
