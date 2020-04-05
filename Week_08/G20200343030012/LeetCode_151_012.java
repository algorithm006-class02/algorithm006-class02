/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */

class Solution {
    public String reverseWords(String s) {

        String[] ss = s.split(" ");
        int n = ss.length;

        StringBuilder ans = new StringBuilder();
        for (int i = n - 1; i >= 0; i--){
            if (ss[i].length() == 0) continue;
            ans.append(ss[i]).append(" ");
        }

        if (ans.length() > 0) {
            ans.deleteCharAt(ans.length() - 1);
        }
    
        return ans.toString();
    }
}