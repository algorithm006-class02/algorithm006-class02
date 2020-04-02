class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] store = new char[256];
        char[] storeReverse = new char[256];
        for (int i = 0; i < s.length(); i++) {
            if (store[s.charAt(i)] == 0) {
                store[s.charAt(i)] = t.charAt(i);
                if (storeReverse[t.charAt(i)] != 0) {
                    return false;
                } else {
                    storeReverse[t.charAt(i)] = s.charAt(i);
                }
            } else {
                if (store[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}