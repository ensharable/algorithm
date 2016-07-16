package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author Marcus
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> com = new ArrayList();
        Arrays.sort(nums);
        //result.add(new ArrayList<Integer>());
        backTrack(result, com, nums, 0);
        return result;
    }
    
    private void backTrack(List<List<Integer>> result, List<Integer> com, int[] nums, int index){
        if(nums.length>=com.size()){
            result.add(new ArrayList<Integer>(com));
        }else{
            return;
        }
        
        for(int i=index; i<nums.length; i++){
            com.add(nums[i]);
            backTrack(result, com, nums, i+1);
            com.remove(com.size()-1);
        }
    }
}
