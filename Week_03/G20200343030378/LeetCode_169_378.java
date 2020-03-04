public class LeetCode_169_378 {
    public int majorityElement(int[] nums) {
        return hepler(nums, 0, nums.length - 1);
    }

    private int hepler(int[] nums, int lo, int hi) {
        //termination
        if (lo == hi)
            return nums[lo];
        //process
        int mid = (hi-lo)/2+lo;
        //down
        int left = hepler(nums, lo, mid);
        int right = hepler(nums, mid + 1, hi);

        //merge
        if (left == right)
            return left;
        int leftCount = numCount(nums, left, lo, hi);
        int rightCount = numCount(nums, right, lo,hi);

        return leftCount > rightCount ? left : right;
    }

    private int numCount(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi;i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }
}
