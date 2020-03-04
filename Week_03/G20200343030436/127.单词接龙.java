/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);//put(key,value);
            }
        });
        Queue<Pair<String, Integer>> q = new LinkedList<Pair<String, Integer>>();
        Pair<String, Integer> startPair = new Pair(beginWord, 1);
        q.add(startPair); // 1 深度记录的初始化
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);
        while (!q.isEmpty()) {
            Pair<String, Integer> node = (Pair<String, Integer>) q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                for (String adjaceWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (adjaceWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjaceWord)) {
                        visited.put(adjaceWord, true);
                        q.add(new Pair<>(adjaceWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    private int L;
    private HashMap<String, ArrayList<String>> allComDict;

    Solution() {
        this.L = 0;
        this.allComDict = new HashMap<String, ArrayList<String>>();
    }


    private int visitWordNode(Queue<Pair<String, Integer>> Q,
                              HashMap<String, Integer> visited,
                              HashMap<String, Integer> otherVisited) {
        Pair<String, Integer> node = Q.remove();

        String word = node.getKey();
        int level = node.getValue();
        for (int i = 0; i < this.L; i++) {
            String newword = word.substring(0, i) + '*' + word.substring(i + 1, L);
            for (String adjacetword : this.allComDict.getOrDefault(newword, new ArrayList<String>())) {
                if (otherVisited.containsKey(adjacetword)) {
                    return level + otherVisited.get(adjacetword);
                }

                if (!visited.containsKey(adjacetword)) {
                    visited.put(adjacetword, level + 1);
                    Q.add(new Pair<>(adjacetword, level + 1));
                }
            }
        }
        return -1;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        this.L = beginWord.length();
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String newword = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformations = this.allComDict.getOrDefault(newword, new ArrayList<String>());
                transformations.add(word);
                this.allComDict.put(newword, transformations);
            }
        });
        Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();
        Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
        Q_begin.add(new Pair<>(beginWord, 1));
        Q_end.add(new Pair<>(endWord, 1));
        HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
        HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);
        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {
            int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
            if (ans > -1) {
                return ans;
            }
            ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
            if (ans > -1) {
                return ans;
            }
        }
        return 0;
    }
}
// @lc code=end

