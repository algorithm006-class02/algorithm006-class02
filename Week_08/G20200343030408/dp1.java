public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return digui(s, 0);
    }


    private int digui(String s, int start) {
        
        if (s.length() == start) {
            return 1;
        }
        //non exist
        if (s.charAt(start) == '0') {
            return 0;
        }
        
        int ans1 = digui(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ans2 = digui(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

