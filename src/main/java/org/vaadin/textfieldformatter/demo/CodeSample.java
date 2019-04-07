package org.vaadin.textfieldformatter.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.github.appreciated.prism.element.Language;
import com.github.appreciated.prism.element.PrismHighlighter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CodeSample extends VerticalLayout {

	private final static String SKIPPED_KEYWORD = "return";

	public CodeSample() {
	}

	public void setSample(String caption, Component component, Class<?> sample) {
		boolean found = false;
		StringBuilder out = new StringBuilder();
		InputStream in = sample.getResourceAsStream("/" + sample.getSimpleName() + ".java");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("import")) {
					out.append("\t\t");
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

			add(new H2(caption));
			add(component);
			if (component instanceof HasSize) {
				((HasSize) component).setWidthFull();
			}
			setCode(out.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setCode(String code) {

		PrismHighlighter javaCode = new PrismHighlighter(code, Language.java);
		javaCode.getElement().getStyle().set("width", "100%");
		add(javaCode);
	}
}
