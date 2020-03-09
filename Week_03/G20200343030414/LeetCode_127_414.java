package Week_03.G20200343030414;

import java.util.*;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/word-ladder/
 * @since 2020-03-01 15:28
 */
public class LeetCode_127_414 {

    /**
     * 双向BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        // 从两端BFS遍历用的队列
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        // 从两端BFS遍历过的节点
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<String> stackTemp = queue1;
                queue1 = queue2;
                queue2 = stackTemp;
                Set<String> visitedTemp = visited1;
                visited1 = visited2;
                visited2 = visitedTemp;
            }
            int queue1Size = queue1.size();
            while (queue1Size-- > 0) {
                String str = queue1.poll();
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char initialChar = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String newStr = String.valueOf(chars);
                        // 如果已经访问过，则跳过
                        if (visited1.contains(newStr)) {
                            continue;
                        }
                        // 两端遍历相遇，则结束遍历，返回count
                        if (visited2.contains(newStr)) {
                            return count + 1;
                        }
                        if (allWordSet.contains(newStr)) {
                            queue1.offer(newStr);
                            visited1.add(newStr);
                        }
                    }
                    chars[i] = initialChar;
                }
            }
        }
        return 0;
    }

}
