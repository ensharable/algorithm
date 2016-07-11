package java;

import java.util.ArrayList;

public class CountandSay {
	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append('1');
		
		if(n>1){
			for(int i=2; i<=n; i++){
				sb = work(sb);
			}
		}
		return sb.toString();
	}
	
	private StringBuilder work(StringBuilder nums){
		StringBuilder sb = new StringBuilder();
		char lastdigi='0';
		int counter=0;
		for (int i=0; i<nums.length(); i++){
			if(lastdigi!='0' && lastdigi!=nums.charAt(i)){
				sb.append(counter);
				sb.append(lastdigi);
				lastdigi=nums.charAt(i);
				counter=1;
			}else{
				lastdigi=nums.charAt(i);
				counter++;
			}
		}	
		sb.append(counter);
		sb.append(lastdigi);
		return sb;
	}
	
	 public String countAndSay2(int n) {
	        if(n<=0) return "";
	        
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        res.add(1);
	        while(n>1){
	            ArrayList<Integer> temp = new ArrayList<Integer>();
	            int index=0;
	            int digi=res.get(index);
	            int counter=0;
	            while(index<res.size()){
	                if(digi==res.get(index)){
	                    counter++;
	                }else{
	                    //digi is not equal
	                    temp.add(counter);
	                    temp.add(digi);
	                    digi=res.get(index);
	                    counter=1;
	                }
	                index++;
	            }
	            //handle the last count
	            temp.add(counter);
	            temp.add(digi);
	            res=temp;
	            n--;
	        }
	        StringBuilder sb = new StringBuilder();
	        for(int element: res){
	            sb.append(element);
	        }
	        return sb.toString();
	    }
}
