package G20200343030448;

public class LeetCode_242_448_ {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] countingSort = new int[26];
        for(char c : s.toCharArray()) {
            countingSort[c - 48]++;
        }
        for (char c : t.toCharArray()) {
            countingSort[c - 48]--;
        }
        for (int i : countingSort) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
