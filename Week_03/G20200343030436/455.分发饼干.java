/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] childrenArray, int[] cookiesArray) {
        if (childrenArray == null || cookiesArray == null) {
            return 0;
        }
        Arrays.sort(childrenArray);
        Arrays.sort(cookiesArray);
        int child = 0;
        for (int cookie = 0; child < childrenArray.length && cookie < cookiesArray.length; cookie++) {
            if (cookiesArray[cookie] >= childrenArray[child]) {
                child++;
            }
        }
        return child;
    }
}
// @lc code=end

