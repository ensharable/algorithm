package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * 
 * @author Marcus
 *
 */
public class LetterCombinationsofaPhoneNumber {
	private static char[][] map = { { ' ' }, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations(String digits) {
		char[] digitsArray = digits.toCharArray();
		List<String> result = new ArrayList();
		if (digitsArray.length != 0) {
			backTrack(result, digitsArray, 0, "");
		}
		return result;
	}

	public void backTrack(List<String> result, char[] digits, int index, String tempResult) {
		// end condiction
		if (index >= digits.length) {
			result.add(tempResult);
			return;
		}

		int digit = (int) digits[index] - 48;
		for (int i = 0; i < map[digit].length; i++) {
			String newTempResult = tempResult + map[digit][i];
			backTrack(result, digits, index + 1, newTempResult);
		}

	}
}
