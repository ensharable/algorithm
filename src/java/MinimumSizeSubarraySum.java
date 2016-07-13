package java;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum >= s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * @author Marcus
 *
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int size = Integer.MAX_VALUE;
		int sum = 0;

		while (right < nums.length) {
			sum += nums[right++];

			while (sum >= s) {
				size = Math.min(size, (right - left));
				sum -= nums[left++];
			}
		}
		return size == Integer.MAX_VALUE ? 0 : size;
	}
}
