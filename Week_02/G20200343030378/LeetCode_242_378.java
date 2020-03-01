import com.sun.tools.javac.util.StringUtils;

import java.util.Arrays;


public class LeetCode_242_378 {
    //哈希法1
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        int[] c = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < tc.length; i++) {
            c[sc[i] - 'a']++;
            c[tc[i] - 'a']--;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0)
                return false;
        }
        return true;
    }
    public boolean isAnagramII(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        int [] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if(table[t.charAt(i) - 'a']<0)
                return false;
        }
        return true;
    }

    //暴力排序
    public boolean isAnagramI(String s, String t) {
        if (null == s || null == t) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        if(Arrays.equals(sc,tc)){
            return true;
        }else {
            return false;
        }
    }
}
