package java;

/**
 * Implement int sqrt(int x).
 *	Compute and return the square root of x.
 *
 */
public class Sqrt {
	public int sqrt(int x) {
        // write your code 
        if(x==0||x==1){
            return x;
        }
        
        int left=1;
        int right=x;
        
        while(left<=right){
            int mid=(right-left)/2+left;
            if(x/mid==mid){ //we find it
                return mid;
            }else if(x/mid>mid){
                //mid is too small to be a sqrt(x), search right side
                left=mid;
            }else{// mid is too big
                if(x/(mid-1)>(mid-1)){
                    //if(mid-1) is too big, then we find it
                    return mid-1;
                }
                //search the left side
                right=mid;
            }
        }
        
        return 0;
    }
}
}
