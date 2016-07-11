package java;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(a==null || b==null || a.length()==0 || b.length()==0){
            return "";
        }
        
        char[] aa=a.toCharArray();
        char[] ba=b.toCharArray();
        
        int ai=aa.length-1;
        int bi=ba.length-1;
        int carry=0;
        
        StringBuilder sb = new StringBuilder();
        
        while(ai>=0 && bi>=0){
            int av=aa[ai]-'0';
            int bv=ba[bi]-'0';
            int cbit=(av+bv+carry)%2;
            carry=(av+bv+carry)>>1;
            sb.insert(0, cbit);
            ai--;
            bi--;
        }
        
        if(ai>=0){
            while(ai>=0){
                int av=aa[ai]-'0';
                int cbit=(av+carry)%2;
                carry=(av+carry)>>1;
                sb.insert(0, cbit);
                ai--;
            }
        }else if(bi>=0){ //bi>=0
            while(bi>=0){
                int bv=ba[bi]-'0';
                int cbit=(bv+carry)%2;
                carry=(bv+carry)>>1;
                sb.insert(0, cbit);
                bi--;
            }
        }
        
        //both are less than 0
        if(carry!=0){
            sb.insert(0, carry);
        }
        
        return sb.toString();
    }
}