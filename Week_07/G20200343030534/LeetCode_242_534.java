package com.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateAnagram242 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abcdefghijklmn", t = "abcdefghijklmn";
        isAnagram2(s, t);
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> result = new HashMap<>();
        s.chars().forEach(c -> {
            result.computeIfAbsent((char) c, k -> {
                return 0;
            });
            result.computeIfPresent((char) c, (k, v) -> {
                return ++v;
            });
        });

        Map<Character, Integer> result1 = new HashMap<>();
        t.chars().forEach(c -> {
            result1.computeIfAbsent((char) c, k -> {
                return 0;
            });
            result1.computeIfPresent((char) c, (k, v) -> {
                return ++v;
            });
        });

        return result.equals(result1);
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
    //hashtable
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) + ":" +(int)s.charAt(i));
            result[s.charAt(i) - 'a']++;
            result[t.charAt(i) - 'a']--;
        }

        for (int j = 0; j < result.length; j++) {

            if (result[j] != 0) {
                return false;
            }
        }
        return true;
    }
    //hashtable
   public static boolean isAnagram3(String s, String t) {        
        
        if (s.length() != t.length()) {
            return false;
        }

        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
            
        }

        for (int j = 0; j < s.length(); j++) {
            result[t.charAt(j) - 'a']--;
            if (result[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }

        
        return true;
    
    }

}
