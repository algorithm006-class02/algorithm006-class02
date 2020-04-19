class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        char[] scs = s.toCharArray(), tcs = t.toCharArray();
        Arrays.sort(scs);
        Arrays.sort(tcs);
        return Arrays.equals(scs, tcs);
    }
}