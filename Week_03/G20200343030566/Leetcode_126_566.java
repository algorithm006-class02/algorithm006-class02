package com.sebar.test.leetcode.three.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/27
 * @Description
 */

public class Leetcode_126_566 {
    /**
     * 所有可能的路径结果
     */
    List<List<String>> resList = new ArrayList<>();
    /**
     * 最短路径
     */
    int minDepth = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 先判断目标单词是否存在于列表中
        LinkedList<String> tempList = new LinkedList<>();
        if (wordList.isEmpty() || !wordList.contains(endWord)) {
            return resList;
        }
        // 将转换单词加入列表
        tempList.add(beginWord);
        // 生成全部能到达节点的路径
        backTrack(endWord, wordList, tempList);
        // 选出最小路径
        return resList;

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

}
