package com.example.mail.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(ExampleMailClickTest.class);
		suite.addTestSuite(MailAssertThatTest.class);
		//$JUnit-END$
		return suite;
	}

}
