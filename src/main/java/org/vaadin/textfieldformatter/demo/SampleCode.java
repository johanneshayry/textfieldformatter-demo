package org.vaadin.textfieldformatter.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.github.appreciated.prism.element.Language;
import com.github.appreciated.prism.element.PrismHighlighterUnstyled;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@CssImport(value = "./prism-atom-dark.css", id = "prism-theme")
public class SampleCode extends PrismHighlighterUnstyled implements HasSize {

	private final static String SKIPPED_KEYWORD = "return";

	public SampleCode(Class<?> sample) {
		super(parseCode(sample), Language.java);
	}

	private static String parseCode(Class<?> sample) {
		boolean found = false;
		StringBuilder out = new StringBuilder();
		InputStream in = sample.getResourceAsStream("/" + sample.getSimpleName() + ".java");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("import")) {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toString();
	}
}
