package Week_06.G20200343030414;

import java.util.*;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/word-ladder/
 * @since 2020-03-22 17:31
 */
public class LeetCode_127_414 {


    /**
     * 双端BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) == -1) {
            return 0;
        }
        wordList.add(beginWord);
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        visited1.add(beginWord);
        queue2.offer(endWord);
        visited2.add(endWord);
        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue tempQueue = queue1;
                queue1 = queue2;
                queue2 = tempQueue;
                Set<String> tempVisited = visited1;
                visited1 = visited2;
                visited2 = tempVisited;
            }
            int queue1Size = queue1.size();
            while (queue1Size-- > 0) {
                String str = queue1.poll();
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char startWord = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String newStr = String.valueOf(chars);
                        if (visited1.contains(newStr)) {
                            continue;
                        }
                        if (visited2.contains(newStr)) {
                            return count + 1;
                        }
                        if (allWordSet.contains(newStr)) {
                            queue1.offer(newStr);
                            visited1.add(newStr);
                        }
                    }
                    chars[i] = startWord;
                }
            }
        }
        return 0;
    }

}
