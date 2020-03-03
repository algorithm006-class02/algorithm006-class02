package week3;

import java.util.*;

/**
 * 127. 单词接龙
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * https://leetcode-cn.com/problems/word-ladder/solution/suan-fa-shi-xian-he-you-hua-javashuang-xiang-bfs23/
 */
public class WordLadder {

    public static void test() {
        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> words = Arrays.asList(strings);
        System.out.println("长度：" + new WordLadder().ladderLength(beginWord, endWord, words));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 暴力法
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);

        int count = 0;
        while (queue.size() > 0) {
            ++count;
            for (int i = 0, size = queue.size(); i < size; i++) {
                String target = queue.poll();
                for (String word : wordList) {
                    if (visited.contains(word)) {
                        // 遍历过的 跳过
                        continue;
                    } else if (!canRevert(target, word)) {
                        // 不符合接龙规则的 跳过
                        continue;
                    }
                    if (word.equals(endWord)) {
                        return count + 1;
                    }
                    // 还没找到，继续找
                    visited.add(word);
                    queue.offer(word);
                }
            }
        }
        return 0;
    }

    /**
     * 是否符合转换要求
     */
    private boolean canRevert(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // 不相同字符数
        int count = 0;
        for (int i = 0, length = s2.length(); i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    // 有超过1个字母不同就不符合转换要求
                    return false;
                }
            }
        }

        return count == 1;
    }
}
