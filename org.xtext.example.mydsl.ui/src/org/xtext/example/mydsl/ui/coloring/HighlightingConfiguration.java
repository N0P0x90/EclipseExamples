package org.xtext.example.mydsl.ui.coloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class HighlightingConfiguration implements  IHighlightingConfiguration {

	public final static String HELLO = "Hello";
	public final static String NAME = "Name";

	public HighlightingConfiguration() {
		
	}
	
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(HELLO, "Hello", myHelloTextStyle());
		acceptor.acceptDefaultHighlighting(NAME, "Name", myNameTextStyle());
	}

	public TextStyle myHelloTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setStyle(SWT.BOLD);
		textStyle.setColor(new RGB(255, 0, 0));
		return textStyle;
	}
	
	public TextStyle myNameTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setStyle(SWT.BOLD);
		textStyle.setColor(new RGB(0, 255, 0));
		return textStyle;
	}

}
