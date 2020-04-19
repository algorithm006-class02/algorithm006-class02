package com.sebar.test.leetcode.six.practice;


import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 * 127. 单词接龙
 */
public class Leetcode_127_566 {
    /**
     * 单向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();
        HashMap<String, List<String>> allComboDict = new HashMap<>();

        for (String s : wordList) {
            for (int i = 0; i < wordLength; i++) {
                // 通配单词
                String newWord = s.substring(0, i) + "*" + s.substring(i + 1, wordLength);
                List<String> dictOrDefault = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                dictOrDefault.add(s);
                allComboDict.put(newWord, dictOrDefault);
            }
        }
        // 构建一个单向队列queue
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // 访问记录
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            Integer level = node.getValue();

            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);

                for (String s : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // end terminator
                    if (s.equals(endWord)) {
                        return level + 1;
                    }
                    //继续深入
                    if (!visited.containsKey(s)) {
                        visited.put(s, true);
                        queue.add(new Pair<>(s, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 双向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();
        HashMap<String, List<String>> allComboDict = new HashMap<>();

        for (String s : wordList) {
            for (int i = 0; i < wordLength; i++) {
                // 通配单词
                String newWord = s.substring(0, i) + "*" + s.substring(i + 1, wordLength);
                List<String> dictOrDefault = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                dictOrDefault.add(s);
                allComboDict.put(newWord, dictOrDefault);
            }
        }
        // 构建一个开始字符单向队列queue
        Queue<Pair<String, Integer>> queueBegin = new LinkedList<>();
        // 构建一个结束字符的单向队列
        Queue<Pair<String, Integer>> queueEnd = new LinkedList<>();

        queueBegin.add(new Pair<>(beginWord, 1));
        queueEnd.add(new Pair<>(endWord, 1));

        // 访问数组记录
        HashMap<String, Integer> visitedBegin = new HashMap<>();
        HashMap<String, Integer> visitedEnd = new HashMap<>();

        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
            int ans = visitWordNode(queueBegin, visitedBegin, visitedEnd, wordLength, allComboDict);
            if (ans > -1) {
                return ans;
            }
            ans = visitWordNode(queueEnd, visitedEnd, visitedBegin, wordLength, allComboDict);
            if (ans > -1) {
                return ans;
            }
        }
        return 0;
    }

    private int visitWordNode(Queue<Pair<String, Integer>> queue, HashMap<String, Integer> visited, HashMap<String, Integer> visitedTwo, int wordLength, HashMap<String, List<String>> allComboDict) {
        Pair<String, Integer> node = queue.remove();
        String word = node.getKey();
        Integer level = node.getValue();

        for (int i = 0; i < wordLength; i++) {
            String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
            for (String s : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                if (visitedTwo.containsKey(s)) {
                    return level + visitedTwo.get(s);
                }
                if (!visited.containsKey(s)) {
                    visited.put(s, level + 1);
                    queue.add(new Pair<>(s, level + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode_127_566 coco = new Leetcode_127_566();
        int i = coco.ladderLength2("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(i);
    }
}
