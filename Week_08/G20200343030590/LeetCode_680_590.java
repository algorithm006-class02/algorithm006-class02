public class LeetCode_680_590 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        int count = 0;
        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);

            if (leftC != rightC) {
                if (s.charAt(left+1) == rightC && s.charAt(right-1) == leftC && left != right - 1 && count == 0) {
                    if (s.charAt(left+1) == s.charAt(right-2)) {
                        right--;
                    }
                    if (s.charAt(right-1) == s.charAt(left+2)) {
                        left++;
                    }
                    count++;
                    continue;
                } else if (s.charAt(left+1) == rightC && count == 0) {
                    left++;
                    count++;
                    continue;
                } else if (s.charAt(right-1) == leftC && count == 0) {
                    right--;
                    count++;
                    continue;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }


    public boolean validPalindromeWithGreedy(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }

    public boolean validPalindromeWithinDiscuss(String s) {
        int l = -1, r = s.length();
        while(++l <= --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r)
                        || isPalindrome(s, l,     r - 1);
            }
        }

        return true;
    }

    boolean isPalindrome(String s, int from, int to) {
        while(from <= to) {
            if (s.charAt(from) != s.charAt(to)) return false;
            from++; to--;
        }
        return true;
    }
}
