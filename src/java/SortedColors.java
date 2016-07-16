package java;

/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortedColors {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int first_pos_after_zero = 0;
		int first_pos_before_two = nums.length - 1;
		int cur = 0;

		while (cur <= first_pos_before_two) {
			if (nums[cur] == 0) {
				int temp = nums[first_pos_after_zero]; // do swap cur with
														// first_pos_after_zero
				nums[first_pos_after_zero] = nums[cur];
				nums[cur] = temp;
				first_pos_after_zero++;

				cur++;
			} else if (nums[cur] == 2) {
				int temp = nums[first_pos_before_two]; // do swap cur with
														// first_pos_at_two
				nums[first_pos_before_two] = nums[cur];
				nums[cur] = temp;
				first_pos_before_two--;
				// after swap, the new nums[cur] is from the back of the array,
				// didn't process before, so cur can't increase
			} else {
				// if nums[cur]==1, skip to next
				cur++;
			}
		}
	}
	
	public void sortColors2(int[] nums) {
        if(nums==null || nums.length<2){
            return;
        }
        
        int[] record = new int[3]; //three colors
        for(int c:nums){
            record[c]++; //count how many for the colors
        }
        
        int i=0;
        //for color 0
        while(record[0]>0){
            nums[i]=0;
            record[0]--;
            i++;
        }
        //for color 1
        while(record[1]>0){
            nums[i]=1;
            record[1]--;
            i++;
        }
        //for color 2
        while(record[2]>0){
            nums[i]=2;
            record[2]--;
            i++;
        }
        
    }
}
