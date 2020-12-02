package org.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import junit.framework.TestCase;

public class TestEmailContentType extends TestCase {
	
	Email testEmail;
	
	public void setUp() {
		testEmail = new SimpleEmail();
	}
	
	public void testUpdateContentType() {
		testEmail.updateContentType("text/html");
		assertEquals("text/html", testEmail.contentType);
	}
	
	public void testUpdateContentTypeAndSetCharset() {
		// Set character set and content type in separate methods.
		testEmail.setCharset("utf-16");
		testEmail.updateContentType("text/html");
		assertEquals("text/html; charset=UTF-16", testEmail.contentType);
	}
	
	public void testUpdateContentTypeWithCharset() {
		// Set character set and content type in the same method.
		testEmail.updateContentType("text/html; charset=utf-16");
		assertEquals("text/html; charset=utf-16", testEmail.contentType);
	}
}
