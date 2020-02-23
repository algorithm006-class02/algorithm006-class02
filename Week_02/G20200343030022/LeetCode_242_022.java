import java.util.Arrays;

/**
 * @Description：
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true

 */
public class LeetCode_242_022 {
    /**
     * 两个string转成数组 然后sort 最后遍历比较
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if(sc.length != tc.length)
            return false;
        Arrays.sort(sc);
        Arrays.sort(tc);
        for(int i = 0; i < sc.length; i++){
            if(sc[i] != tc[i])
                return false;
        }
        return true;

    }

    /**
     * 用哈希的思想，遍历一遍把每个字母放在数组中 次数进行+1，第二个string的字母进行-1
     * 最后循环有不等于0的就返回false
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(int i = 0; i < s.length();i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int j = 0;j < arr.length;j++){
            if(arr[j] != 0){
                return false;
            }
        }
        return true;
    }
}
