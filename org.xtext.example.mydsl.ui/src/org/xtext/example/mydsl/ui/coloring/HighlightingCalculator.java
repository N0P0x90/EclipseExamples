package org.xtext.example.mydsl.ui.coloring;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.xtext.example.mydsl.myDsl.Greeting;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.util.MyDslSwitch;

public class HighlightingCalculator implements ISemanticHighlightingCalculator {


	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null) {
			return;
		}

		HighlightingSwitch switcher = new HighlightingSwitch(acceptor);

		Iterator<EObject> iter = EcoreUtil.getAllContents(resource, true);
		while (iter.hasNext()) {
			EObject current = iter.next();
			switcher.doSwitch(current);
		}
	}

	private class HighlightingSwitch extends MyDslSwitch<Void> {

		private final IHighlightedPositionAcceptor acceptor;

		public HighlightingSwitch(IHighlightedPositionAcceptor acceptor) {
			this.acceptor = acceptor;
		}

		@Override
		public Void caseGreeting(Greeting object) {
			INode node = getFirstNode(object);
			highlightNode(node, HighlightingConfiguration.HELLO);
			
			node = getFirstFeatureNode(object, MyDslPackage.eINSTANCE.getGreeting_Name());
			highlightNode(node, HighlightingConfiguration.NAME);
			return null;
		}

		private void highlightNode(INode node, String id) {
			if (node == null)
				return;
			if (node instanceof ILeafNode) {
				acceptor.addPosition(node.getOffset(), node.getLength(), id);
			} else {
				for (ILeafNode leaf : node.getLeafNodes()) {
					if (!leaf.isHidden()) {
						acceptor.addPosition(leaf.getOffset(), leaf.getLength(), id);
					}
				}
			}
		}
	}

	public INode getFirstFeatureNode(EObject semantic, EStructuralFeature feature) {
		if (feature == null)
			return NodeModelUtils.findActualNodeFor(semantic);
		List<INode> nodes = NodeModelUtils.findNodesForFeature(semantic, feature);
		if (!nodes.isEmpty())
			return nodes.get(0);
		return null;
	}

	public INode getFirstNode(EObject semantic) {

		ICompositeNode node = NodeModelUtils.findActualNodeFor(semantic);

		return node;
	}

}
