package org.di.uminho.cguide.wizard.Create;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JRadioButton;

import org.di.uminho.cguide.wizard.Create.Action.CreateActionPage2;
import org.di.uminho.cguide.wizard.Create.Decision.CreateDecisionPage2;
import org.di.uminho.cguide.wizard.Create.End.CreateEndPage2;
import org.di.uminho.cguide.wizard.Create.Plan.CreatePlanPage2;
import org.di.uminho.cguide.wizard.Create.Question.CreateQuestionPage2;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.AbstractOWLWizardPanel;

//import org.semanticweb.reasonerfactory.pellet.PelletReasonerFactory;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 02-Jul-2006<br>
 * <br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 */
public class SelectClinicalTaskPage extends AbstractOWLWizardPanel {

	public static final String ID = "SelectClinicalTaskPage";

	public static final String title = "Select Clinical Task Type";

	public int choice = -1;

	private JRadioButton plan;
	private JRadioButton action;
	private JRadioButton decision;
	private JRadioButton question;
	private JRadioButton end;

	public SelectClinicalTaskPage(OWLEditorKit owlEditorKit) {
		super(ID, title, owlEditorKit);
	}

	protected void createUI(JComponent parent) {
		setInstructions("Please select the Class you wish to create new Individuals.");
		parent.setLayout(new BorderLayout());

		Box box = new Box(BoxLayout.Y_AXIS);
		parent.add(box, BorderLayout.CENTER);

		plan = new JRadioButton("Plan");
		box.add(plan);
		action = new JRadioButton("Action");
		box.add(action);
		decision = new JRadioButton("Decision");
		box.add(decision);
		question = new JRadioButton("Question");
		box.add(question);
		end = new JRadioButton("End");
		box.add(end);
		ButtonGroup bg = new ButtonGroup();
		bg.add(plan);
		bg.add(action);
		bg.add(decision);
		bg.add(question);
		bg.add(end);

	}

	public Object getBackPanelDescriptor() {
		return SelectClassPage.ID;
	}

	public Object getNextPanelDescriptor() {
		if (plan.isSelected()) {
			choice = 1;
			return CreatePlanPage2.ID;
		} else if (action.isSelected()) {
			choice = 2;
			return CreateActionPage2.ID;
		} else if (decision.isSelected()) {
			choice = 3;
			return CreateDecisionPage2.ID;
		} else if (question.isSelected()) {
			choice = 4;
			return CreateQuestionPage2.ID;
		} else if (end.isSelected()) {
			choice = 5;
			return CreateEndPage2.ID;
		} else
			choice = -1;
		return SelectClinicalTaskPage.ID;
	}

}
