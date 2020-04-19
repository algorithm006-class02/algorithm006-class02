package Week_07.G20200343030512;

 public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i =0 ;
        int mask =1;

        for(int j=0;j<32;j++){
            if ((n & mask) !=0){
                i++;
            }
            mask <<=1;
        }
        return i;
    }
}