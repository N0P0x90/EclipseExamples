/*
 * generated by Xtext
 */
package org.xtext.example.mydsl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.xtext.example.mydsl.ui.coloring.HighlightingCalculator;
import org.xtext.example.mydsl.ui.coloring.HighlightingConfiguration;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used within the IDE.
 */
public class MyDslUiModule extends org.xtext.example.mydsl.ui.AbstractMyDslUiModule {
	public MyDslUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}


	@Override
	public void configure(Binder binder) {
		// TODO Auto-generated method stub
		super.configure(binder);
		binder.bind(ISemanticHighlightingCalculator.class).to(HighlightingCalculator.class);
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return HighlightingConfiguration.class;
	}
}
