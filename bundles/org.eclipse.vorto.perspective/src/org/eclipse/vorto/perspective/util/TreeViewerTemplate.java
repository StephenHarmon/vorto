/*******************************************************************************
 *  Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Eclipse Distribution License v1.0 which accompany this distribution.
 *   
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  The Eclipse Distribution License is available at
 *  http://www.eclipse.org/org/documents/edl-v10.php.
 *   
 *  Contributors:
 *  Bosch Software Innovations GmbH - Please refer to git log
 *******************************************************************************/
package org.eclipse.vorto.perspective.util;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;

public class TreeViewerTemplate {

	private final TreeViewer treeViewer;
	
	public TreeViewerTemplate(TreeViewer treeViewer) {
		this.treeViewer = treeViewer;
	}
	
	public void update(final TreeViewerCallback callback) {
		if (!Display.getDefault().isDisposed()) { 
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					try {
						callback.doUpdate(treeViewer);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			});
		}
	}
}
