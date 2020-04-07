import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        //开辟两个数组进行计数，定义滑动窗口的左右指针
        int[] needs = new int[26], window = new int[26];
        int left = 0, right = 0, total = p.length();
        for(char c : p.toCharArray()) {
            needs[c - 'a']++;
        }
        while(right < s.length()) {
            char c = s.charAt(right);
            if(needs[c - 'a'] > 0) {
                window[c - 'a']++;
                if(window[c - 'a'] <= needs[c - 'a'])
                    total--;
            }
            while(total == 0) {
                if(right - left + 1 == p.length()) {
                    res.add(left);
                }
                char c1 = s.charAt(left);
                if(needs[c1 - 'a'] > 0) {
                    window[c1 - 'a']--;
                    if(window[c1 - 'a'] < needs[c - 'a'])
                        total++;
                }
                left++;
            }
            right++;
        }
        return res;
    }
}