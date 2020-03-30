public class Solution {
	public int reverseBits(int n) {
		int ret = 0;
		for(int i = 31; i >= 0; i--) {
			ret = ret | (((n>>(31-i)) & 1) << i);
		}
		return ret;
	}
}