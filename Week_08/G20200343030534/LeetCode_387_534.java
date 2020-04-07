package com.test.datastructure;

import java.util.HashSet;
import java.util.Set;

public class UniqueChar387 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UniqueChar387 check = new UniqueChar387();
        System.out.println(check.firstUniqChar("dddccdbba"));
    }

    public int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        int result = -1;
        if (s == null || s.length() == 0) {
            return result;
        }
        if (s.length() == 1) {
            result = 0;
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                if (i == s.length() - 1 || s.indexOf(s.charAt(i), i + 1) == -1) {
                    result = i;
                    break;
                }
                set.add(s.charAt(i));
            }
        }

        return result;
    }
}
