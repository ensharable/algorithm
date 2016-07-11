package java;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author Marcus
 *
 * Faster way to do 
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
 */
public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return 0;
		} else if (haystack.length() < needle.length()) {
			return -1;
		} else if (needle.length() == 0) {
			return 0;
		}

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int cur = i;
			boolean match = true;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(cur) != needle.charAt(j)) {
					match = false;
					break;
				}
				cur++;
			}
			if (match){
				return i;
			}
		}
		return -1;
	}
}
