package com.example.mail.test;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swt.UITestCaseSWT;
import com.windowtester.runtime.swt.condition.shell.ShellDisposedCondition;
import com.windowtester.runtime.swt.condition.shell.ShellShowingCondition;
import com.windowtester.runtime.swt.locator.ButtonLocator;
import com.windowtester.runtime.swt.locator.TreeItemLocator;
import com.windowtester.runtime.swt.locator.eclipse.ContributedToolItemLocator;
import com.windowtester.runtime.swt.locator.eclipse.ViewLocator;
import com.windowtester.runtime.swt.locator.eclipse.WorkbenchLocator;

public class MailAssertThatTest extends UITestCaseSWT {

	/* @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		IUIContext ui = getUI();
		ui.ensureThat(new WorkbenchLocator().hasFocus());
		ui.ensureThat(ViewLocator.forName("Welcome").isClosed());
	}

	/**
	 * Main test method.
	 */
	public void testAssertMail() throws Exception {
		IUIContext ui = getUI();
		ui.click(new TreeItemLocator("me@this.com", new ViewLocator(
				"com.example.mail.navigationView")));
		ui.click(new TreeItemLocator("me@this.com/Sent", new ViewLocator(
				"com.example.mail.navigationView")));
		ui.click(new ContributedToolItemLocator("com.example.mail.open"));
		ui.click(new ContributedToolItemLocator("com.example.mail.openMessage"));
		ui.wait(new ShellShowingCondition("Open"));
		ui.click(new ButtonLocator("OK"));
		ui.wait(new ShellDisposedCondition("Open"));
		
		ui.click(new TreeItemLocator("me@this.com/Drafts", new ViewLocator("com.example.mail.navigationView")));
		
		ui.assertThat(new TreeItemLocator("me@this.com/Drafts", new ViewLocator("com.example.mail.navigationView")).isVisible());
		
		ui.assertThat(new TreeItemLocator("me@this.com/Drafts", new ViewLocator("com.example.mail.navigationView")).isSelected(false));
		
	}

}