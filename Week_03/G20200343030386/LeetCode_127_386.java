package com.example.leetCode.week3;


import javafx.util.Pair;

import java.util.*;

public class LeetCode_127_386 {
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索

    private HashMap<String, List<String>> map;
    private int length;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // map存储所有字母缺少一位后可能的key，并将key与所有能通过变换一位字母得到的word放到key后面
        // 维护一个队列，两个参数：当前判断的word，遍历到该word需要经过的层数
        // 维护一个已访问过的节点map，防止后续重复访问
        // 遍历queue，将每个元素出队，并循环判断缺少各个位置上的字母之后，对应的word有哪些，逐一判断
        // 若匹配则输出，否则放入队列继续循环判断
        // 双向查找即是通过endWord同时再往前做bfs，直到双方同时查找到同一个节点
        if (!wordList.contains(endWord)) {
            return 0;
        }
        map = new HashMap<>();
        int length = beginWord.length();
        this.length = length;
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(word);
                map.put(key, list);
            }
        }
        Queue<Pair<String, Integer>> beginQueue = new LinkedList<>();
        Queue<Pair<String, Integer>> endQueue = new LinkedList<>();
        beginQueue.offer(new Pair<>(beginWord,1));
        endQueue.offer(new Pair<>(endWord, 1));
        HashMap<String, Integer> beginVisit = new HashMap<>();
        HashMap<String, Integer> endVisit = new HashMap<>();
        beginVisit.put(beginWord, 1);
        endVisit.put(endWord, 1);
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int bfs = bfs(beginQueue, beginVisit, endVisit);
            if (bfs > 0) {
                return bfs;
            }
            bfs = bfs(endQueue, endVisit, beginVisit);
            if (bfs > 0) {
                return bfs;
            }
        }
        return 0;
    }

    private int bfs(Queue<Pair<String, Integer>> queue, HashMap<String, Integer> visit, HashMap<String, Integer> otherVisit) {
        Pair<String, Integer> poll = queue.poll();
        String word = poll.getKey();
        int level = poll.getValue();
        for (int i = 0; i < length; i++) {
            String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
            for (String str : map.getOrDefault(newWord, new ArrayList<>())) {
                if (otherVisit.containsKey(str)) {
                    return level + otherVisit.get(str);
                }
                if (!visit.containsKey(str)) {
                    queue.offer(new Pair<>(str, level + 1));
                    visit.put(str, level + 1);
                }
            }
        }
        return 0;
    }
}
