package java;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null||n==0){
            return;
        }
        int totalCount=m+n;
        int index = totalCount-1;
        m--;    //use it for index so reduce 1
        n--;    //use it for index, so reduce 1
        
        while(m>=0&&n>=0){
            if(nums1[m]>nums2[n]){
                nums1[index]=nums1[m];
                m--;
            }else{
                nums1[index]=nums2[n];
                n--;
            }
            index--;
        }
        //if m>=0, we don't need to copy, so don't need to care
        //we only care about the array nums2 need to copy
        while(n>=0){
            nums1[index]=nums2[n];
            n--;
            index--;
        }
    }
}
