/*******************************************************************************
 * Copyright (c) 2015 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     University of Southampton - initial API and implementation
 *******************************************************************************/

package ac.soton.eventb.statemachines.validator.tests;

import ac.soton.eventb.statemachines.Transition;

/**
 * <p>
 *
 * </p>
 *
 * @author htson
 * @version
 * @see
 * @since
 */
public class Error_TransitionTargetAnyState extends AbstractErrorDiagnostic
		implements IDiagnosticCause {

	/**
	 * @param transition
	 */
	public Error_TransitionTargetAnyState(Transition transition) {
		super("Transition should not target an Any state", transition);
	}

}
