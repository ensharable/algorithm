package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * @author Marcus
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList();

		if (strs == null || strs.length == 0) {
			return result;
		}

		HashMap<String, List<String>> map = new HashMap();

		for (String s : strs) {
			String key = getHash(s);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}
		// get result back
		return new ArrayList<List<String>>(map.values());

	}

	private String getHash(String s) {
		// use sort
		char[] ca = s.toCharArray();
		Arrays.sort(ca);
		return new String(ca);
	}
}
