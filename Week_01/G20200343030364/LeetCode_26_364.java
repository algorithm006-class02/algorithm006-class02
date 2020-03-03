/**
 * Created by HuGuodong on 2/13/20.
 */
public class LeetCode_26_364 {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] a = {1,1,1,1, 2, 3, 3};
    int result = solution.removeDuplicates(a);
    assert result == 3;
    a = new int[]{1,1,1,1,1};
    result = solution.removeDuplicates(a);
    assert result == 1;
  }

  /**
   * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
   */
  static class Solution {

    public int removeDuplicates(int[] nums) {
      if (nums.length == 0 || nums.length == 1)
        return nums.length;
      int pos = 0;
      for (int i = 1; i < nums.length; i++)
        if (nums[i] > nums[i - 1])
          nums[++pos] = nums[i];
      return pos + 1;
    }
  }
}
