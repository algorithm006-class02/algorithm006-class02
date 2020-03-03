package com.lewis.algorithm.trainingcamp.week03;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        Map<String, List<String>> genericMap = new HashMap<>(16);
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String genericKey = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = genericMap.getOrDefault(genericKey, new ArrayList<>());
                list.add(word);
                genericMap.put(genericKey, list);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        Map<String, Boolean> visitedMap = new HashMap<>(16);
        visitedMap.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.key;
            Integer level = pair.value;

            for (int i = 0; i < length; i++) {
                String genericKey = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = genericMap.getOrDefault(genericKey, new ArrayList<>());
                if (list.size() == 0) {
                    continue;
                }
                for (String cWord : list) {
                    if (cWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visitedMap.containsKey(cWord)) {
                        visitedMap.put(cWord, true);
                        queue.offer(new Pair(cWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    static class Pair {
        public String key;
        public Integer value;

        public Pair(String key, Integer level) {
            this.key = key;
            this.value = level;
        }
    }
}
