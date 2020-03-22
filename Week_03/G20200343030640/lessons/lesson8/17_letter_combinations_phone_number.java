import java.util.*;


// “回溯” 指的是 “状态重置”，即通过枚举所有可能的情况来找到所有解的算法思想。
// 如果一个候选解最后被发现并不是可行解，那么舍弃它，回到前面的步骤并对其做出一些修改，
// 重新尝试找到新条件的可行解。
// 简单地讲：可理解为通过回溯前的选择与回溯后的撤销来求出相应结果集的一个过程。
// 参考"img_17.jpg"或"img_17_1.jpg", 回溯核心思路：选择与回撤

class Solution {
    private static String letterMap[] = {
        "",     //0
        "",     //1
        "abc",  //2
        "def",  //3
        "ghi",  //4
        "jkl",  //5
        "mno",  //6
        "pqrs", //7
        "tuv",  //8
        "wxyz"  //9
    };
    public List<String> letterCombinations(String digits) {
        LinkedList<String> resList = new LinkedList<>();
        if(! "".equals(digits))
            backtrace(0, digits, new StringBuilder(), resList);

        return resList;
    }

    public void backtrace(int i, String digits, StringBuilder sb, LinkedList<String> resList) {
        if(sb.length() == digits.length()) {  // 或者写 i == digits.length()
            resList.addLast(sb.toString());
            return;
        }

        char digit = digits.charAt(i);   // 获取第i位数字
        String letters = letterMap[digit - '0'];  // 获取第i位数字对应的各个字母
        for (int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));  // 选择第j个字母
            backtrace(i+1, digits, sb, resList);
            sb.deleteCharAt(sb.length()-1);// 撤销第j个字母
        }
    }
}
