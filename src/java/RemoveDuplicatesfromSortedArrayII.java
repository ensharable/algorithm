package java;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 * 
 *
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int counter = 1;
		int cur = 0;
		int proc = 1;

		while (proc < nums.length) {
			if (nums[cur] != nums[proc]) {
				nums[++cur] = nums[proc];
				counter = 1;
			} else if (nums[cur] == nums[proc] && counter < 2) {
				nums[++cur] = nums[proc];
				counter++;
			}
			proc++;
		}
		return cur + 1;
	}

	public int removeDuplicates2(int[] nums) {
		int counter = 0;
		int cur = 1;
		if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return 1;
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				counter++;
			} else {
				counter = 0;
			}
			if (counter <= 1) {
				nums[cur] = nums[i];
				cur++;
			}
		}
		return cur;
	}
	
	 public int removeDuplicates3(int[] nums) {
	        if(nums==null){
	            return 0;
	        }else if(nums.length<=2){
	            return nums.length;
	        }
	        
	        int cur=0;
	        
	        for(int e:nums){
	            if(cur<2||nums[cur-2]!=e){
	                nums[cur]=e;
	                cur++;
	            }
	        }
	        return cur;
	    }
}
