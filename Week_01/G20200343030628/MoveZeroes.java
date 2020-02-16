public class MoveZeroes {
    public void moveZeroes(int [] nums) {
        //排除两种特殊情况
        if (nums == null || nums.length == 1) {
            return;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                count++;
            } else if (count >0) {
                //交换位置
                nums[i-count] = nums[i];
                nums[i]  =  0;
            }
        }
    }

}
