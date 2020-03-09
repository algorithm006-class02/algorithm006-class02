package com.sebar.test.leetcode.three.homework;

import javafx.util.Pair;

import java.util.*;

/**
 * @author liguang
 * @Date 2020/2/27
 * @Description 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/description/
 */

public class Leetcode_127_566 {
    /**
     * 所有可能的路径结果
     */
    List<List<String>> resList = new ArrayList<>();
    /**
     * 最短路径
     */
    int minDepth = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Leetcode_127_566 code = new Leetcode_127_566();
        int i = code.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        int i = code.ladderLength("hot", "dog", Arrays.asList("hot", "dog"));
//        int i = code.ladderLengthBFS("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }

    /**
     * 127. 单词接龙
     * 此方法能完成，但是存在重复路径问题，会超出时间限制
     *
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  词典列表
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 先判断目标单词是否存在于列表中
        LinkedList<String> tempList = new LinkedList<>();
        if (wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }
        // 将转换单词加入列表
        tempList.add(beginWord);
        // 生成全部能到达节点的路径
        backTrack(endWord, wordList, tempList);
        // 选出最小路径
        if (!resList.isEmpty()) {
            return minDepth;
        } else {
            return 0;
        }
    }

    /**
     * @param endWord  结束单词
     * @param wordList 词典
     * @param tempList 暂存结果集
     */
    private void backTrack(String endWord, List<String> wordList, LinkedList<String> tempList) {
        // 满足条件终止
        if (tempList.getLast().equalsIgnoreCase(endWord) && tempList.size() <= minDepth) {
            // 记录所有可能的路径
            ArrayList<String> pathList = new ArrayList<>(tempList);
            if(pathList.size()<minDepth){
                resList.clear();
            }
            if (pathList.size() == minDepth || resList.isEmpty()) {
                resList.add(pathList);
            }
            minDepth = pathList.size();
            return;
        }
        // 大于最短路径了，直接不走了
        if (tempList.size() > minDepth) {
            return;
        }
        // 获取整个转换列表最后一个单词
        String lastWord = tempList.getLast();

        // 挑选下一个能进行转换的单词选择列表，
        for (String word : wordList) {
            // 如果已经存在检测路径中，则跳过
            if (tempList.contains(word)) {
                continue;
            }
            // 做出选择，选择出能进行下一步转换的单词
            if (judgeCanBeChange(lastWord, word)) {
                tempList.add(word);
                //将下一个单词记入临时列表，继续排查
                backTrack(endWord, wordList, tempList);
                // 撤销选择
                tempList.removeLast();
            }
        }
    }

    /**
     * 检验能不能转换
     *
     * @param lastWord
     * @param targetWord
     */
    private Boolean judgeCanBeChange(String lastWord, String targetWord) {
        int diff = 0;
        for (int i = 0; i < targetWord.length(); i++) {
            if (lastWord.charAt(i) != targetWord.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 最短转换路径 ，采用无向图标记，解决上一种方法超时的问题
     *
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  词典
     * @return
     */
    public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
        // 单词的长度
        int len = beginWord.length();
        // 构建一个词典中所有字符的通用状态字典
        HashMap<String, List<String>> allComboDict = new HashMap<>();

        // 填充通用字符字典
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newCommonWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> transWordList = allComboDict.getOrDefault(newCommonWord, new ArrayList<>());
                transWordList.add(word);
                allComboDict.put(newCommonWord, transWordList);
            }
        });
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 1));

        // 使用记录
        HashMap<String, Boolean> visitedMap = new HashMap<>();
        visitedMap.put(beginWord, true);

        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.remove();
            String word = node.getKey();
            Integer level = node.getValue();

            for (int i = 0; i < len; i++) {
                String newBeginWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                // 获取跟当前通配字符相似的所有字典中的单词
                for (String adjWord : allComboDict.getOrDefault(newBeginWord, new ArrayList<>())) {
                    if (adjWord.equalsIgnoreCase(endWord)) {
                        return level + 1;
                    }

                    // 增加访问记录，并转向下一个字符单词
                    if (!visitedMap.containsKey(adjWord)) {
                        visitedMap.put(adjWord, true);
                        q.add(new Pair<>(adjWord, level + 1));
                    }
                }

            }
        }
        return 0;
    }

    /**
     * 双向广度优先遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthBFSDoubleDirection(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 单词的长度
        int len = beginWord.length();
        // 构建一个词典中所有字符的通用状态字典
        HashMap<String, List<String>> allComboDict = new HashMap<>();

        // 填充通用字符字典
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newCommonWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> transWordList = allComboDict.getOrDefault(newCommonWord, new ArrayList<>());
                transWordList.add(word);
                allComboDict.put(newCommonWord, transWordList);
            }
        });

        // 构建两个开始队列，一个从开始单词开始，一个从结束单词开始
        Queue<Pair<String, Integer>> qBegin = new LinkedList<>();
        Queue<Pair<String, Integer>> qEnd = new LinkedList<>();

        qBegin.add(new Pair<>(beginWord, 1));
        qEnd.add(new Pair<>(endWord, 1));

        // 构建两个访问标记map
        HashMap<String, Integer> visitedBeginMap = new HashMap<>();
        HashMap<String, Integer> visitedEndMap = new HashMap<>();
        visitedBeginMap.put(beginWord, 1);
        visitedEndMap.put(endWord, 1);

        while (!qBegin.isEmpty() && !qEnd.isEmpty()) {
            //
            int ans = visitedNode(qBegin, visitedBeginMap, visitedEndMap, len, allComboDict);
            if (ans > -1) {
                return ans;
            }
            //
            ans = visitedNode(qEnd, visitedBeginMap, visitedEndMap, len, allComboDict);
            if (ans > -1) {
                return ans;
            }
        }
        return 0;
    }

    /**
     * 访问节点标记
     *
     * @param pairQueue       队列
     * @param visitedBeginMap 头部访问记录
     * @param visitedEndMap   尾部访问记录
     * @return
     */
    private int visitedNode(Queue<Pair<String, Integer>> pairQueue, HashMap<String, Integer> visitedBeginMap,
                            HashMap<String, Integer> visitedEndMap, int len, HashMap<String, List<String>> allComboDict) {
        Pair<String, Integer> pairNode = pairQueue.remove();
        String word = pairNode.getKey();
        Integer level = pairNode.getValue();

        for (int i = 0; i < len; i++) {
            String newWord = word.substring(0, i) + "*" + word.substring(i, len);
            for (String adjWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                if (visitedEndMap.containsKey(adjWord)) {
                    return level + visitedEndMap.get(adjWord);
                }

                if (!visitedBeginMap.containsKey(adjWord)) {
                    visitedBeginMap.put(adjWord, level + 1);
                    pairQueue.add(new Pair<>(adjWord, level + 1));
                }
            }
        }
        return -1;
    }
}
