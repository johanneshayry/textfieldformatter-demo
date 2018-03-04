package org.vaadin.textfieldformatter.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;

public class CodeSample extends Label {

	private final static String SKIPPED_KEYWORD = "return";

	public CodeSample() {
	}

	@Override
	public void attach() {
		super.attach();
	}

	public void setCode(Class<?> sample) {
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
			setCode(out.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setCode(String code) {
		setContentMode(ContentMode.HTML);
		setValue("<pre class=\"language-java\"><code class=\"language-java\">" + code + "</code></pre>");
	}
}
