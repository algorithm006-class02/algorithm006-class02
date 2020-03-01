/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    //方法1 先排序后再字符串看是否相等 
    // 相等的就是字母异位词就放入结果的list里
    //N 是strs长度  遍历每个字符串N
    //k是strs中字符串长度 O（klogK）排序的最好复杂度
    // 时间复杂度 O（NlogN）
    // 空间复杂度 O(NK) HashMap
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
// @lc code=end

