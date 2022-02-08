
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	String one;
	String two;
	String three;
	String four;
	@Before
	public void setUp() throws Exception {
		one = "abcde";
		two = "Abcdef1!";
		three = "ABCDEEEFGHI1";
		four = "Abcdefghi1!";
	}

	@After
	public void tearDown() throws Exception {
		one = two = three = four = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
		assertTrue(PasswordCheckerUtility.isValidLength(four));
		assertTrue(PasswordCheckerUtility.isValidLength(one));
		} catch (LengthException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
		assertTrue(PasswordCheckerUtility.hasUpperAlpha(two));
		assertTrue(PasswordCheckerUtility.hasUpperAlpha(one));
		} catch (NoUpperAlphaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
		assertTrue(PasswordCheckerUtility.hasLowerAlpha(one));
		assertTrue(PasswordCheckerUtility.hasLowerAlpha(three));
		} catch (NoLowerAlphaException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
		assertFalse(PasswordCheckerUtility.isWeakPassword(four));
		assertTrue(PasswordCheckerUtility.isWeakPassword(two));
		} catch (WeakPasswordException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws InvalidSequenceException 
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() throws InvalidSequenceException
	{
		try {
		assertTrue(PasswordCheckerUtility.NoSameCharInSequence(one));
		assertTrue(PasswordCheckerUtility.NoSameCharInSequence(three));
		} catch (InvalidSequenceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
		assertTrue(PasswordCheckerUtility.hasDigit(two));
		assertTrue(PasswordCheckerUtility.hasDigit(one));
		} catch (NoDigitException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 *
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
		assertTrue(PasswordCheckerUtility.isValidPassword(four));
		assertTrue(PasswordCheckerUtility.isValidPassword(one));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> list = new ArrayList<String>();
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		list = PasswordCheckerUtility.getInvalidPasswords(list);
		assertTrue(list.size() == 2);
	}
	
}
