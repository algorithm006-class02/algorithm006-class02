/**
 * Created by HuGuodong on 3/1/20.
 */
public class LeetCode_45_364 {

  class Solution {

    /**
     * The main idea is based on greedy. Let's say the range of the current jump is [curBegin,
     * curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
     * Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with
     * curFarthest, then keep the above steps, as the following:
     *
     * @param A
     * @return
     */
    public int jump(int[] A) {
      int jumps = 0, curEnd = 0, curFarthest = 0;
      for (int i = 0; i < A.length - 1; i++) {
        curFarthest = Math.max(curFarthest, i + A[i]);
        if (i == curEnd) {
          jumps++;
          curEnd = curFarthest;
        }
      }
      return jumps;
    }
  }
}
