class LeetCode_26_022 {
    /**
     1.遍历后k[n-k,n)位 分配到新的数组中，在将[0,n-k)向后移动k位，最后在将新数组的前k位复制回原数组即可
     时间复杂度O(n) 空间复杂度O(k)

     2.暴力：移动k次，每次都移动1个元素记录最后一个元素，移动完后在将最后一个值赋值给0位
     时间复杂度O(n*k) 空间复杂度O(1)

     3.反转法， 先整体反转，在反转0,k-1 在反转k,n-1

     */
    //方法2
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while(fast != nums.length){
            if(nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    //方法3
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        resverse(nums, 0, nums.length - 1);
        resverse(nums, 0, k-1);
        resverse(nums, k, nums.length - 1);
    }

    public void resverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}