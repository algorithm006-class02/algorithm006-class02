class Solution {
    public void rotate(int[] nums, int k) {
        int[] array = new int[nums.length];

        for (int i = 0; i < nums.length ; i++){
            array[(i+k)%nums.length] = nums[i];
        }

        System.arraycopy(array, 0, nums, 0, array.length);

    }
}

