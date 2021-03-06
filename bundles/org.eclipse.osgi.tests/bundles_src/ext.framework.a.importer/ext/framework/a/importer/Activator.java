/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package ext.framework.a.importer;

import ext.framework.a.FrameworkExtTest;
import java.io.*;
import java.net.URL;
import org.eclipse.osgi.tests.bundles.AbstractBundleTests;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		AbstractBundleTests.simpleResults.addEvent(new FrameworkExtTest().testIt("success")); //$NON-NLS-1$
		AbstractBundleTests.simpleResults.addEvent(getURLContent(this.getClass().getResource("/ext/framework/a/fwkresource.txt"))); //$NON-NLS-1$
	}

	private String getURLContent(URL resource) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()));
		try {
			return br.readLine();
		} finally {
			br.close();
		}
	}

	public void stop(BundleContext context) throws Exception {
		// nothing
	}

}
