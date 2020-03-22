package com.sebar.test.leetcode.six.practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * 433. 最小基因变化
 */
public class Leetcode_433_566 {
    /**
     * 最小基因变化
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> banks = Arrays.stream(bank).collect(Collectors.toSet());
        if (!banks.contains(end)) {
            return -1;
        }
        HashMap<String, String> dict = new HashMap<>();
        dict.put("A", "CGT");
        dict.put("C", "AGT");
        dict.put("G", "ACT");
        dict.put("T", "ACG");

        Queue<String> startQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();

        startQueue.add(start);
        endQueue.add(end);

        int step = 0;

        while (!startQueue.isEmpty()) {
            step += 1;
            List<String> nextFront = new LinkedList<>();
            for (String word : startQueue) {
                for (int i = 0; i < word.length(); i++) {
                    String c1 = String.valueOf(word.charAt(i));
                    for (char c : dict.get(c1).toCharArray()) {
                        String newWord = word.substring(0, i) + String.valueOf(c) + word.substring(i + 1, word.length());
                        if (endQueue.contains(newWord)) {
                            return step;
                        }
                        if (banks.contains(newWord)) {
                            nextFront.add(newWord);
                            banks.remove(newWord);
                        }
                    }
                }
            }
            startQueue.clear();
            startQueue.addAll(nextFront);

            if (endQueue.size() < startQueue.size()) {
                //交换
                Queue<String> temp = startQueue;
                startQueue.clear();
                startQueue.addAll(endQueue);
                endQueue.clear();
                endQueue.addAll(temp);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode_433_566 coco = new Leetcode_433_566();
        String start = "AAAAAAAA";
        String end = "CCCCCCCC";
        int i = coco.minMutation(start, end, new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA", "CCCCCCCC"});
        System.out.println(i);
    }
}
