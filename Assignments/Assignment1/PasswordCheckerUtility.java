import java.util.ArrayList;

/**
 * 
 * @author Camron Franklin
 * CMSC 204 CRN 36096
 *
 */
public class PasswordCheckerUtility {
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (password.equals(passwordConfirm))
			return;
		else
			throw new UnmatchedException("The passwords do not match");
	}
	
	/**
	 * Compares passwords, whether they match determines return value
	 * @param password - String to be compared
	 * @param passwordConfirm - String to be compared
	 * @return true if the two strings match, false if they do not
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if (password.equals(passwordConfirm))
			return true;
		else
			return false;
	} 
	
	/**
	 * Checks if password is valid length
	 * @param password - string to be measured
	 * @return true if password meets minimum requirement
	 * @throws LengthException - thrown if password does not meet minimum length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() >= 6)
			return true;
		else
			throw new LengthException("The password must be at least 6 characters long");
	}
	
	/**
	 * Checks the password uppercase requirement
	 * @param password - password string to be checked for uppercase
	 * @return true if the password string has an uppercase letter
	 * @throws NoUpperAlphaException - thrown if password string does not contain an uppercase letter
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		char[] Password = password.toCharArray();
		for (char a: Password)
		{
			if (Character.isUpperCase(a))
				return true;
		}
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}
	
	/**
	 * Checks the password lowercase requirement
	 * @param password - password string to be checked
	 * @return true if password meets lowercase requirement
	 * @throws NoLowerAlphaException - thrown if password does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		char[] Password = password.toCharArray();
		for (char a: Password)
		{
			if (Character.isLowerCase(a))
				return true;
		}
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}
	
	
	/**
	 * Checks the password digit requirement
	 * @param password - password string to be checked
	 * @return true if password meets the digit requirement
	 * @throws NoDigitException - thrown if password does not meet digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		char[] Password = password.toCharArray();
		for (char a: Password)
		{
			if (Character.isDigit(a))
				return true;
		}
		throw new NoDigitException("The password must contain at least one digit");
	}
	
	/**
	 * Checks the password special character requirement
	 * @param password - password string to be checked
	 * @return true if password meets special character requirement
	 * @throws NoSpecialCharacterException - thrown if password does not meet special character requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		char[] Password = password.toCharArray();
		for (char a: Password) {
			if ((a >= 33 && a <= 47) || (a >= 58 && a <= 64) || (a >= 91 && a <= 96) || (a >= 173 && a <= 176)) {
				return true;
			}
		}
		throw new NoSpecialCharacterException("The password must contain at least one special character");
	}
	
	/**
	 * Checks the password for valid sequence requirement
	 * @param password - password string to be checked
	 * @return true if password does not contain to consecutive identical characters
	 * @throws InvalidSequenceException - thrown if password does not meet special character requirement
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		char[] Password = password.toCharArray();
		for (int i = 0; i < Password.length - 1; i++) {
			if (Password[i] == Password[i + 1] && Password[i + 1] == Password[i + 2])
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
		}
		return true;
	}
	 /**
	  * Checks the password for strength
	  * @param password - password string to be checked
	  * @return true if password is strong (between 6 and 9 characters), false otherwise
	  */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() > 5 && password.length() < 10)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns ArrayList of all Invalid Passwords
	 * @param passwords - ArrayList of passwords to be checked for validity
	 * @return ArrayList of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < passwords.size(); i++)
		{
			try {
				isValidPassword(passwords.get(i));
			} catch (Exception e) {
				list.add(passwords.get(i) + " - " + e.getMessage());
			}
		}

		return list;
	}
	
	/**
	 * Checks for strength of password
	 * @param password - password string to be checked
	 * @return false if password has more than 9 characters
	 * @throws WeakPasswordException - thrown if password is between six and nine characters
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		if (hasBetweenSixAndNineChars(password))
			throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
		return false;
	}

	/**
	 * Checks password for validity
	 * @param password - password string to be checked
	 * @return true if password satisfies all requirements, otherwise return false
	 * @throws LengthException - thrown if password does not meet length requirement
	 * @throws NoDigitException - thrown if password does not meet digit requirement
	 * @throws NoUpperAlphaException - thrown if password does not meet uppercase letter requirement
	 * @throws NoLowerAlphaException - thrown if password does not meet lowercase letter requirement
	 * @throws NoSpecialCharacterException - thrown if password does not meet special character requirement
	 * @throws InvalidSequenceException - thrown if password has more than two consecutive identical characters
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoDigitException,
	NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException,
	InvalidSequenceException {
		try {
			if (isValidLength(password)) {
				if (hasUpperAlpha(password)) {
					if (hasLowerAlpha(password)) {
						if (hasDigit(password)) {
							if (hasSpecialChar(password)) {
								if (NoSameCharInSequence(password)) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			throw e;
		}
		return false;
	}
}

