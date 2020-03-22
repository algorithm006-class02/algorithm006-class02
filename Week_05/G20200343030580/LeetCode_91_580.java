class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] n = new int[s.length()];
        n[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char pre = s.charAt(i - 1), c = s.charAt(i);
            if (c == '0') {
                if (pre == '0' || pre >= '3') {
                    return 0;
                } else {
                    if (n[i - 1] == 1) {
                        n[i] = 1;
                    } else {
                        if (i > 2) {
                            n[i] = n[i - 2];
                        } else {
                            n[i] = n[i - 1] - 1;
                        }
                    }
                }
            } else {
                if (pre == '1' || pre == '2' && c <= '6') {
                    if (i > 2) {
                        n[i] = n[i - 1] + n[i - 2];
                    } else {
                        n[i] = n[i - 1] + 1;
                    }
                } else {
                    n[i] = n[i - 1];
                }
            }
        }
        return n[s.length() - 1];
    }
}
