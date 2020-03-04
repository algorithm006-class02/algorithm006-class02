import java.util.*;

/**
 * @author:
 * @Date: 2020-02-23 22:08
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LeetCode_49_490 {

    /**
     * 利用数组相当于先排序 然后利用字符的码值构成的数组 当作hash值。进行分类。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
