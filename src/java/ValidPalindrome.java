package java;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * @author Marcus
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}

		int left = 0;
		int right = s.length() - 1;

		while (left <= right) {
			char l = s.charAt(left);
			if (!isAlphaNum(l)) {
				left++;
				continue;
			}
			char r = s.charAt(right);
			if (!isAlphaNum(r)) {
				right--;
				continue;
			}

			if (Character.toLowerCase(l) == Character.toLowerCase(r)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isAlphaNum(char c) {
		int ascii = (int) c;

		if ((ascii > 47 && ascii < 58) || (ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123)) {
			return true;
		}
		return false;
	}
}
