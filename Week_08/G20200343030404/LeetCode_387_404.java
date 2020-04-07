class Solution {
    public int firstUniqChar(String s) {
        int[] idx = new int[26];
        int[] count = new int[s.length()];
        for(int i = 0 ; i < idx.length ; i ++) {
            idx[i] = -1;
        }
        for(int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            int idxOfC = c - 'a';
            if(idx[idxOfC] == -1) {
                idx[idxOfC] = i;
            }
            count[idx[idxOfC]] ++;
        }
        for(int i = 0 ; i < count.length ; i ++) {
            if(count[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}