package G20200343030448;

public class LeetCode_45_448 {
    public int jump(int[] nums) {
        int steps = 0; //count steps as result
        int tempMax = 0; //from 0 to i, find possible max absolute position
        int currentEnd = 0; //the end of current step
        for (int i = 0; i < nums.length - 1; i++) {
            tempMax = tempMax > nums[i] + i ? tempMax : nums[i] + i;
            if (i == currentEnd) { //if reached the end of current step, reset next end as tempMax.
                currentEnd = tempMax;
                steps++;
            }
        }
        return steps;
    }
}
