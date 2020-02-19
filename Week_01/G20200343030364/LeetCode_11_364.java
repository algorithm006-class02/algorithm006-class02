/**
 * Created by HuGuodong on 2/14/20.
 */
public class LeetCode_11_364 {

  class Solution {

    public int maxArea(int[] height) {
      int max = 0;
      for (int i = 0, j = height.length - 1; i < j; ) {
        int minHeight = height[i] < height[j] ? height[i++] : height[j--];
        int area = minHeight * (j - i + 1);
        max = Math.max(area, max);
      }
      return max;
    }
  }
}
