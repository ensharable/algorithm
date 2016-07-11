package java;

/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * @author Marcus
 *
 */
public class FirstBadVersion {
	public int firstBadVersion(int n) {
		if (n == 1) {
			return 1;
		}

		int left = 1;
		int right = n;

		while (left < right) {
			int mid = (right - left) / 2 + left;
			boolean mid_bad = isBadVersion(mid);
			if (!mid_bad) {
				left = mid + 1;// must be mid +1
			} else {
				right = mid;
			}
		}
		return left;

	}
}
