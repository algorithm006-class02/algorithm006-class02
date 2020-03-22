package week06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 单词接龙
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 */
public class LeetCode_127_564 {

    public static void main(String[] args) {
        LeetCode_127_564 leetCode = new LeetCode_127_564();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(leetCode.ladderLength("hit", "cog", wordList));
    }

    /**
     * 双向BFS
     * 时间复杂度：
     * 空间复杂度：
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1.设置成set，查询为O(1)
        // 2.开辟一个visited，记录访问过的单词
        // 3.把beginWord和endWord加入到set中开始遍历
        // 4.比较两个set，挑选小的set进行遍历，循环里面的单词，每个字母进行替换，如果这个字符串在另外一个集合中存在，则返回长度+1，
        // 如果这个单词没有访问过而且在单词库中，则加入到临时存储数组中，最后替换到beginSet中，长度加1
        // 注意还原单词

        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        HashSet<String> endSet = new HashSet<>();
        endSet.add(endWord);

        HashSet<String> visited = new HashSet<>();

        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                HashSet<String> tem = beginSet;
                beginSet = endSet;
                endSet = tem;
            }

            HashSet<String> temp = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();

                    for (int j = 0; j < chars.length; j++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            char old = chars[i];
                            chars[i] = c;
                            String target = String.valueOf(chars);

                            if (endSet.contains(target)) return len + 1;

                            if (!visited.contains(target) && wordSet.contains(target)) {
                                visited.add(target);
                                temp.add(target);
                            }
                            chars[i] = old;
                        }
                    }
                }
                len++;
                beginSet = temp;
            }
        }
        return len;
    }
}
