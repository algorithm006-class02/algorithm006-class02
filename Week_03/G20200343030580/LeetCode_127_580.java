class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordlength = beginWord.length();
        HashMap<String, List<String>> dict = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < wordlength; i++) {
                String keyWord = buildConnectWord(word, i);
                List<String> list = dict.getOrDefault(keyWord, new ArrayList<>());
                list.add(word);
                dict.put(keyWord, list);
            }
        });
        Map<String, Boolean> visited = new HashMap<>();
        Queue<Pair<String, Integer>> q = new LinkedList();
        q.add(new Pair<>(beginWord, 1));
        while (q.isEmpty() == false) {
            Pair<String, Integer> node = q.remove();
            String currentWord = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < wordlength; i++) {
                String keyWord = buildConnectWord(currentWord, i);
                for (String word : dict.getOrDefault(keyWord, new ArrayList<>())) {
                    if (word.equals(endWord)) {
                        return level + 1;
                    }
                    if (visited.getOrDefault(word, Boolean.FALSE) == false) {
                        q.add(new Pair<>(word, level + 1));
                        visited.put(word, Boolean.TRUE);
                    }
                }
            }
        }
        return 0;
    }

    private String buildConnectWord(String word, int index) {
        return word.substring(0, index) + "*" + word.substring(index + 1, word.length());
    }
}