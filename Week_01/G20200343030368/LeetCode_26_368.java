class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) {
            return 0;
        }//如果空数组，则长度直接为0
        int length=1;//长度初始化，非空数组说明新数组长度至少为1
        int i=0;
        int j=0;
        while(j<nums.length-1) {
            //j从第二个数字开始遍历
            j++;
            if ( nums[i]!=nums[j]) {
                //如果发现不一样的数，把这个新数，放到前面，代替原来重复的数。
                //例如i=0，j=2时，nums[i]!=nums[j]，
                //那么就把nums[j]这个数放到第2个位置，也就是nums[length]
                nums[length]=nums[j];
                //那么新数列的长度+1,下次新数就可以放在第三个位置
                length++;
                //发现新数之后，给i赋新的值，j继续向后与这个新数比较。
                i=j;
            }
        }
        return length;
    }
}
