public class LeetCode_680_378 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1, deleteIndex = -1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                if (deleteIndex == -1) {
                    deleteIndex = left;
                    left++;
                } else if (deleteIndex == chars.length) return false;
                else {
                    left = deleteIndex;
                    right = chars.length - left - 2;
                    deleteIndex = chars.length;
                }
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}