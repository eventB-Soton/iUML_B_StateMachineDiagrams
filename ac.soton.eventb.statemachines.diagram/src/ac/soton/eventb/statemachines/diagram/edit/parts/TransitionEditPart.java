/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.parts;

import java.util.Collection;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Witness;

import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.diagram.edit.policies.TransitionItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesDiagramEditorPlugin;
import ac.soton.eventb.statemachines.diagram.preferences.SpecificDiagramAppearancePreferencePage;

/**
 * @generated
 */
public class TransitionEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	protected static final IPreferenceStore prefStore = StatemachinesDiagramEditorPlugin
			.getInstance().getPreferenceStore();

	/**
	 * @generated
	 */
	public TransitionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new TransitionItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TransitionLabelEditPart) {
			((TransitionLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureTransitionLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TransitionLabelEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new TransitionFigure();
	}

	/**
	 * @generated
	 */
	public TransitionFigure getPrimaryShape() {
		return (TransitionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class TransitionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureTransitionLabelFigure;

		/**
		 * @generated
		 */
		public TransitionFigure() {

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureTransitionLabelFigure = new WrappingLabel();

			fFigureTransitionLabelFigure.setText("");

			this.add(fFigureTransitionLabelFigure);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setFill(false);
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTransitionLabelFigure() {
			return fFigureTransitionLabelFigure;
		}

	}

	/**
	 * Refresh the colour of the connection from the preferences.
	 * 
	 * @generated
	 */
	protected void refreshForegroundColor() {
		org.eclipse.swt.graphics.RGB rgb = null;
		// set foreground line color
		EObject element = resolveSemanticElement();
		if (element != null) {
			EClass eClazz = element.eClass();
			rgb = PreferenceConverter.getColor(prefStore,
					SpecificDiagramAppearancePreferencePage
							.getLineColorPreference(eClazz, false));
		}

		if (rgb != null) {
			setForegroundColor(new Color(null, rgb));
		} else {
			super.refreshForegroundColor();
		}
	}

	/**
	 * Set the line width of the connection.
	 * 
	 * @param width - the new line width
	 * @generated
	 */
	protected void setLineWidth(int width) {
		getPrimaryShape().setLineWidth(width);
	}

	/**
	 * handle notification events.
	 * increases the line width when enabled operations attached.
	 * 
	 * @param event - the notification event
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		String featureName = event.getFeature() instanceof EStructuralFeature ? ((EStructuralFeature) event
				.getFeature()).getName() : "";
		// update line width and color if state of enabled operations changes
		if ("operations".equals(featureName)) {
			boolean active = event.getNewValue() == null ? false
					: !((Collection<?>) event.getNewValue()).isEmpty();
			setLineWidth(1 + (active ? 2 : 0));
		}

		super.handleNotificationEvent(event);
	}

	/////////// mouse-over feedback text ///////////	
	Label feedbackFigure = null;
	String feedbackText = null;;

	/*
	 * Provides mouse over feedback:
	 * Customised to  show the contents (params, witnesses, guards and actions) of the method
	 * @custom
	 */
	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		// the feedback layer figures do not receive mouse e
		if (feedbackText == null) {
			feedbackText = getMethodText();
			if (feedbackText.length() > 0) {
				feedbackFigure = new Label(feedbackText);
				feedbackFigure.setFont(new Font(null, "Arial", 12, SWT.NORMAL));
				Rectangle bounds = feedbackFigure.getTextBounds().getCopy()
						.expand(10, 10);
				bounds.setLocation(getFigure().getBounds().getLocation()
						.translate(200, -100));
				feedbackFigure.setBounds(bounds);
				feedbackFigure.setForegroundColor(ColorConstants.darkGray); //tooltipForeground);
				feedbackFigure.setBackgroundColor(ColorConstants.lightGray); //tooltipBackground);
				feedbackFigure.setOpaque(true);
				//feedbackFigure.setBorder(new LineBorder());

				IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
				layer.add(feedbackFigure);
			}
		}
	}

	private String getMethodText() {
		Transition transition = (Transition) resolveSemanticElement();

		if (transition.getOperations() != null)
			return ""; //no feedback while animating

		String text = "";
		if (transition.getParameters().size() > 0) {
			text = text + "\nParameters: \n";
			for (TypedParameter p : transition.getParameters()) {
				text = text + "\t" + p.getName() + " : " + p.getType() + "\n";
			}
		}
		if (transition.getWitnesses().size() > 0) {
			text = text + "\nWitnesses: \n";
			for (Witness w : transition.getWitnesses()) {
				text = text + "\t" + w.getName() + " : \n"
						+ indent(2, "", w.getPredicate());
				if (w.getComment() != null && w.getComment().length() > 0) {
					text = text + "\n" + indent(3, "//", w.getComment()) + "\n";
				}
			}
		}
		if (transition.getGuards().size() > 0) {
			text = text + "\nGuards: \n";
			for (Guard w : transition.getGuards()) {
				text = text + "\t" + w.getName()
						+ (w.isTheorem() ? "(THEOREM) :\n" : " :\n");
				text = text + indent(2, "", w.getPredicate());
				if (w.getComment() != null && w.getComment().length() > 0) {
					text = text + "\n" + indent(3, "//", w.getComment()) + "\n";
				}
			}
		}
		if (transition.getActions().size() > 0) {
			text = text + "\nActions: \n";
			for (Action w : transition.getActions()) {
				text = text + "\t" + w.getName() + " : \n"
						+ indent(2, "", w.getAction());
				if (w.getComment() != null && w.getComment().length() > 0) {
					text = text + "\n" + indent(3, "//", w.getComment()) + "\n";
				}
			}
		}

		if (text.length() > 0) {
			text = transition.getLabel()
					+ (transition.isExtended() ? "  [extended]" : "")
					+ (transition.getComment() != null
							&& transition.getComment().length() > 0 ? "  //"
							+ transition.getComment() : "") + "\n" + text;
		}

		return text;
	}

	private static String indent(int tabs, String prefix, String text) {
		if (text == null || text.length() < 1)
			return "";
		String indent = "";
		for (int i = 0; i < tabs; i++) {
			indent = indent + "\t";
		}
		indent = indent + prefix;
		return indent + text.replace("\n", "\n" + indent);
	}

	/* Erases mouse-over feedback.
	 * @custom
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		if (request instanceof CreateConnectionRequest)
			return;
		if (getViewer() == null)
			return;
		IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
		if (layer != null && feedbackFigure != null
				&& feedbackFigure.getParent() != null) {
			layer.remove(feedbackFigure);
		}
		feedbackFigure = null;
		feedbackText = null;
	}

}
