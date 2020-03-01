package Week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * Eg:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class LeetCode_49_564 {

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> result1 = groupAnagrams1(str);
        List<List<String>> result2 = groupAnagrams2(str);
    }

    /**
     * 排序数组分类
     * 时间复杂度：O(nklogk):n是外循环次数，klogk 是排序时间复杂度
     * 空间复杂度：O(nk) :
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String inner : strs) {
            // 内字符串
            char[] chars = inner.toCharArray();
            Arrays.sort(chars);
            // 排好序的字符串
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(inner);
        }
        return new ArrayList(map.values());
    }

    /**
     * 按计数排序
     * 时间复杂度：O(nk):其中 n 是 strs 的长度，而 k 是 strs 中字符串的最大长度
     * 空间复杂度：O(nk):
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length <= 0) return new ArrayList<List<String>>();

        HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        int[] count = new int[26];

        for (String inner : strs) {
            // 清空count
            Arrays.fill(count, 0);

            for (char temp : inner.toCharArray()) count[temp - 'a'] ++;

            StringBuffer buffer = new StringBuffer();
            for (int num : count) {
                buffer.append("#");
                buffer.append(num);
            }

            String key = buffer.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(inner);
        }

        return new ArrayList(map.values());
    }
}
