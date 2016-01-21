/**
 * generated by Xtext
 */
package org.xtext.example.mydsl.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.xtext.example.mydsl.ui.contentassist.AbstractMyDslProposalProvider;

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
@SuppressWarnings("all")
public class MyDslProposalProvider extends AbstractMyDslProposalProvider {
  @Override
  public void completeGreeting_Name(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.completeGreeting_Name(model, assignment, context, acceptor);
    ICompletionProposal _createCompletionProposal = this.createCompletionProposal("foo", context);
    acceptor.accept(_createCompletionProposal);
    ICompletionProposal _createCompletionProposal_1 = this.createCompletionProposal("bar", context);
    acceptor.accept(_createCompletionProposal_1);
  }
}