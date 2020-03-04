package week2;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    public static void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams2(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // 字符排序法
        // 目标是把包含相同字母的字符串分组，竟然包含的字母相同，则这些字符串打散后的排序必定相同。相同排序的则为同一组
        // 利用一个HashMap来缓存已经遍历过的数，并且实现自动分组
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!cache.containsKey(key)) {
                cache.put(key, new ArrayList<>());
            }
            cache.get(key).add(str);

        }
        return new ArrayList<>(cache.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        // 字符计数法
        // 当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串就包含相同的字母。
        // 字符怎么计数？
        // (单个字符 - 'a')就可以得到一个int类型的number，如果得到的number相等，则表明它们在26个字母表中有相同的位置，即它们就是同一个字母
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            int[] words = new int[26];
            // 当前单词 各字母计数
            for (char letter : str.toCharArray()) {
                words[letter - 'a']++;
            }

            // 计数是int型的，需要转为String，这样利用系统API好比较一点
            StringBuilder builder = new StringBuilder(2 * 26);
            for (int word : words) {
                builder.append("#").append(word);
            }
            String key = builder.toString();
            if (!cache.containsKey(key)) {
                cache.put(key, new ArrayList());
            }
            cache.get(key).add(str);
        }
        return new ArrayList<>(cache.values());
    }
}
