/**
 * 49.字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 *
 * 思路（精简）：
 * 1.排序数组分类
 *  ans={
 *  "aet":["ate","eat","tea"],
 *  "ant":["nat","tan"],
 *  "abt":["abt"]
 *  }
 *
 * 不管字母传怎么组合 排好序的只有一个
 *
 * 时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。
 * 空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
 *
 *
 * 2.按计数分类
 *  26个小写字母
 * 不管字符串怎么组合，总的字符计数相同
 *
 * 时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。
 * 空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
 *
 *
 */
public class Leetcode_49_390 {

    /**
     * 1.排序数组分类
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charS = s.toCharArray();
            Arrays.sort(charS);
            String sortStr = String.valueOf(charS);
            // 重点
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<>());
            }
            map.get(sortStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 2.按计数分类（借鉴思想）
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsTwo(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            // 每次统计之前将计数count数组清空
            Arrays.fill(count, 0);
            char[] charS = s.toCharArray();
            for (char ch : charS) {
                count[ch - 'a']++;
            }
            // 将一个字符串对应的count数组 转换成特定符号比如# 隔开的计数字符串
            StringBuilder builder = new StringBuilder();
            for (int c : count) {
                builder.append("#").append(c);
            }
            String countStr = builder.toString();
            if (!map.containsKey(countStr)) {
                map.put(countStr, new ArrayList<>());
            }
            map.get(countStr).add(s);

        }
        return new ArrayList<>(map.values());
    }

}
