public class LeetCode_242_600 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sum = new int[26];
        for(int i = 0; i < s.length(); i++) {
            sum[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            sum[t.charAt(i) - 'a']--;
            if(sum[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
