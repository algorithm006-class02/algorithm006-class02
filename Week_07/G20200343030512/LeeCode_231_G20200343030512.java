
package Week_07.G20200343030512;

public  class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n!=0)&&((n&(n-1))==0);
    }
}