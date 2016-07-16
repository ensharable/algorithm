package java;

/**
 * iven a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author Marcus
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
			return "";
		}
		int begin = 0;
		int end = 0;
		int foundBegin = 0;
		int foundEnd = 0;
		int size = Integer.MAX_VALUE;
		int totalNeedToFound = t.length();
		int totalCurrentFound = 0;
		int[] needToFound = new int[256]; // 256 different character in Ascii
		int[] found = new int[256];

		for (int i = 0; i < t.length(); i++) {
			needToFound[(int) t.charAt(i)]++;
		}

		while (end < s.length()) {
			int ci = (int) s.charAt(end);
			found[ci]++;
			if (needToFound[ci] > 0 && found[ci] <= needToFound[ci]) {
				totalCurrentFound++;
			}
			end++;

			while (totalCurrentFound == totalNeedToFound) {
				if (size > (end - begin)) {
					// we found it, let's update the size
					size = end - begin;
					foundBegin = begin;
					foundEnd = end;
				}
				int bci = (int) s.charAt(begin);
				found[bci]--;
				if (needToFound[bci] > 0 && found[bci] < needToFound[bci]) {
					totalCurrentFound--;
				}
				begin++;
			}
		}
		return s.substring(foundBegin, foundEnd);
	}
}
