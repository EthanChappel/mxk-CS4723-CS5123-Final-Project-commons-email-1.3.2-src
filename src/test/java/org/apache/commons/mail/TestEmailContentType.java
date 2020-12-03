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
		String message = "testUpdateContentType()\nTest updating content type of an email.\nmxk";
		System.out.println(message);
		
		testEmail.updateContentType("text/html");
		assertEquals("text/html", testEmail.contentType);
	}
	
	public void testUpdateContentTypeAndSetCharset() {
		String message = "testUpdateContentTypeAndSetCharset()\nTest updating content type and character set separately.\nmxk";
		System.out.println(message);
		
		// Set character set and content type in separate methods.
		testEmail.setCharset("utf-16");
		testEmail.updateContentType("text/html");
		assertEquals("text/html; charset=UTF-16", testEmail.contentType);
	}
	
	public void testUpdateContentTypeWithCharset() {
		String message = "testUpdateContentTypeWithCharset()\nTest updating content type that includes a character set.\nmxk";
		System.out.println(message);
		
		// Set character set and content type in the same method.
		testEmail.updateContentType("text/html; charset=utf-16");
		assertEquals("text/html; charset=utf-16", testEmail.contentType);
	}
}
