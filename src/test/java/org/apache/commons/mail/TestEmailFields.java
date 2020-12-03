package org.apache.commons.mail;

import static org.junit.Assert.assertArrayEquals;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import javax.mail.internet.InternetAddress;

import junit.framework.TestCase;

public class TestEmailFields extends TestCase{
	
	Email testEmail;
	
	public void setUp() {
		testEmail = new SimpleEmail();
	}
	
	public void testAddBccMultiple() throws EmailException {
		String message = "testAddBccMultiple()\nTest adding multiple recipients to the BCC field of an email\nmxk";
		System.out.println(message);
		
		String[] bccs = {"a@b.com", "b@c.org", "c@d.net", "d@e.co.uk"};
		testEmail.addBcc(bccs);  // Passing Array is the same as multiple arguments.
		
		String[] tbccs = new String[bccs.length];
		int i = 0;
		// Get email addresses from objects.
		for(InternetAddress s : testEmail.getBccAddresses()) {
			tbccs[i++] = s.toString();
		}
		
		assertArrayEquals(bccs, tbccs);
	}
	
	public void testAddCc() throws EmailException {
		String message = "testAddCc()\nTest adding recipient to the CC field of an email\nmxk";
		System.out.println(message);
		
		testEmail.addCc("a@b.com");
		assertEquals("a@b.com", testEmail.getCcAddresses().get(0).toString());
	}
}
