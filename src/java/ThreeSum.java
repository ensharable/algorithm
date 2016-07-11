package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Marcus
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList();

		if (nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int val = nums[i];
				int res = 0 - val;
				int left = i + 1;
				int right = nums.length - 1;
				while (left < right) {
					if ((nums[left] + nums[right]) == res) {
						// found
						List<Integer> temp = new ArrayList();
						temp.add(val);
						temp.add(nums[left]);
						temp.add(nums[right]);
						result.add(temp);

						while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
							left++;
						}
						while (right > i && nums[right] == nums[right - 1]) {
							right--;
						}
					}
					if ((nums[left] + nums[right]) < res) {
						left++;
					} else {
						right--;
					}
				}

			}
		}

		return result;
	}
}
