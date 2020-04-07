class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;

        int[] mapping = new int[26];

        for (char c : s.toCharArray()){
            mapping[c-'a']++;
        }

        for (int i = 0; i < s.length(); i++){
            if (mapping[s.charAt(i) - 'a'] == 1){
                return i ;
            }
        }

        return -1;
    }
}