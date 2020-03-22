import java.util.*;


///字母异位词分组
public class LeetCode_43 {

    public static  void main(String[] args){
        String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> aa=groupAnagrams(strs);
        List<List<String>> aa=groupAnagrams1(strs);
        System.out.println("b:"+aa);
    }

    ///方法一：按计数分类
    ///当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    ///方法二：排序数组分类
    ///当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
