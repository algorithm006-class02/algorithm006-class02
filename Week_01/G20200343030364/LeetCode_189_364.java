/**
 * Created by HuGuodong on 2/13/20.
 */
public class LeetCode_189_364 {

  static class Solution {

    public void rotate(int[] nums, int k) {
      k %= nums.length;
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, k - 1);
      reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
      while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }
    }

    /**
     * use a new array to store rotated values then copy back
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
      k %= nums.length;
      int[] tmp = new int[nums.length];
      System.arraycopy(nums, 0, tmp, k, nums.length - k);
      System.arraycopy(nums, nums.length - k, tmp, 0, k);
      System.arraycopy(tmp, 0, nums, 0, nums.length);
    }
  }

  public static void main(String[] args) {

  }
}
