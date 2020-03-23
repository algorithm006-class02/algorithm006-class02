class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
            bucket[t.charAt(i) - 'a']--;
        }
        for (int i : bucket) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
