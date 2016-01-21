package org.xtext.example.mydsl.ui;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.xtext.example.mydsl.myDsl.Model;
import org.xtext.example.mydsl.ui.internal.MyDslActivator;

import com.google.inject.Injector;

import hehe.ModelRoot;

@SuppressWarnings("restriction")
public class HeheFormPage extends FormPage {

	private ModelRoot root;

	private StyledText styledText;

	private EmbeddedEditor embeddedEditor;
	
	private XtextResource xtextResource;
	
	

	public HeheFormPage() {
		super("hehe", "Hehe");
	}

	/**
	 * Create the form page.
	 * 
	 * @param id
	 * @param title
	 */
	public HeheFormPage(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public HeheFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}
	
	Model getXtextModel() {
		return (Model) xtextResource.getContents().get(0);
	}


	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		
		root = (ModelRoot)((HeheEditor)getEditor()).getEditedResource().getContents().get(0);
		
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Dsl Editor");

		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.VERTICAL));

		Section sctnNewSection = managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
				Section.TWISTIE | Section.SHORT_TITLE_BAR);
		managedForm.getToolkit().paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Comment");
		sctnNewSection.setExpanded(true);

		TextViewer textViewer = new TextViewer(sctnNewSection, SWT.BORDER);
		styledText = textViewer.getTextWidget();
		managedForm.getToolkit().paintBordersFor(styledText);
		sctnNewSection.setClient(styledText);

		Section sctnNewSection_1 = managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
				Section.TWISTIE | Section.TITLE_BAR);
		managedForm.getToolkit().paintBordersFor(sctnNewSection_1);
		sctnNewSection_1.setText("Dsl Edition");
		sctnNewSection_1.setExpanded(true);

		Composite editorComposite = new Composite(sctnNewSection_1, SWT.NO_SCROLL);
		managedForm.getToolkit().adapt(editorComposite);
		sctnNewSection_1.setClient(editorComposite);
		editorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createDslEditor(editorComposite);
		editorComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		
		// Warning bindings do not use editing domain possible but not done here !
		initDataBindings();
	}

	private void createDslEditor(Composite parent) {

		MyDslActivator activator = MyDslActivator.getInstance();
		Injector injector = activator.getInjector(MyDslActivator.ORG_XTEXT_EXAMPLE_MYDSL_MYDSL);
		IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {
			public XtextResource createResource() {
				MyDslActivator activator = MyDslActivator.getInstance();
				Injector injector = activator.getInjector(MyDslActivator.ORG_XTEXT_EXAMPLE_MYDSL_MYDSL);

				XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
				rs.setClasspathURIContext(getClass());

				IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
				URI uri = URI.createFileURI("whatever.mydsl");
				xtextResource = (XtextResource) resourceFactory.createResource(uri);
				rs.getResources().add(xtextResource);
				
				EcoreUtil.resolveAll(xtextResource);

				if (!xtextResource.getErrors().isEmpty()) {
					// handle error?
				}
				return xtextResource;
			}
		};

		EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);
		embeddedEditor = factory.newEditor(resourceProvider).withParent(parent);
		embeddedEditor.createPartialEditor();
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();

		IObservableValue widget = WidgetProperties.text(SWT.Modify).observe(styledText);
		IObservableValue value = PojoProperties.value("comment").observe(root);
		bindingContext.bindValue(widget, value, null, null);
		
		widget = WidgetProperties.text(SWT.Modify).observe(embeddedEditor.getViewer().getTextWidget());
		value = PojoProperties.value("xtextString").observe(root);
		bindingContext.bindValue(widget, value, null, null);
		
		for(Object bindingObject : bindingContext.getBindings()) {
			Binding binding = (Binding)bindingObject;
			binding.getTarget().addChangeListener(new IChangeListener() {

				@Override
				public void handleChange(ChangeEvent event) {
					((HeheEditor) getEditor()).setDirty(true);
				}
				
			});
		}

		return bindingContext;
	}
}
