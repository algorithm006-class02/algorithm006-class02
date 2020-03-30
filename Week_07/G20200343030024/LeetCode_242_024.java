class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapping = new int[26];
        for (char c : s.toCharArray()){
            mapping[c-'a']++;
        }


        for (char c: t.toCharArray()){
            if (--mapping[c-'a'] < 0){
                return false;
            }
        }

        return true;
    }
}