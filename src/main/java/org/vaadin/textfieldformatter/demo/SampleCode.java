package org.vaadin.textfieldformatter.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * A Designer generated component for the sample-code template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("sample-code")
@JsModule("sample-code.js")
public class SampleCode extends PolymerTemplate<SampleCode.SampleCodeModel> {

	private final static String SKIPPED_KEYWORD = "return";
	
    /**
     * Creates a new SampleCode.
     */
    public SampleCode() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between SampleCode and sample-code
     */
    public interface SampleCodeModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setCode(Class<?> sample) {
		boolean found = false;
		StringBuilder out = new StringBuilder();
		InputStream in = sample.getResourceAsStream("/" + sample.getSimpleName() + ".java");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("import")) {
					out.append("\t");
					out.append(line);
					out.append(System.lineSeparator());
				}
				if (line.endsWith("// }")) {
					br.close();
					break;
				}
				if (found) {
					int indexOf = line.indexOf(SKIPPED_KEYWORD);
					if (indexOf != -1) {
						out.append(line.substring(0, indexOf));
						out.append(line.substring(indexOf + SKIPPED_KEYWORD.length()).trim());
						out.append(System.lineSeparator());
					} else {
						out.append(line);
						out.append(System.lineSeparator());
					}
				}
				if (line.endsWith("// {")) {
					found = true;
					out.append(System.lineSeparator());
				}
			}
			setCode(out.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setCode(String code) {
	    
	    JsonObject detail = Json.createObject();
	    detail.put("code", code);
	    detail.put("lang", "java");
	    
	    getElement().setPropertyJson("detail", detail);
		
	}
}
