class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList.contains(endWord) == false) {
            return result;
        }
        int wordlength = beginWord.length();
        HashMap<String, List<String>> dict = buildDict(wordList, wordlength);

        Map<String, Integer> visited = new HashMap<>();
        Queue<Pair<String, List<String>>> q = new LinkedList();
        List<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        q.add(new Pair<>(beginWord, beginList));
        int minLength = Integer.MAX_VALUE;
        while (q.isEmpty() == false) {
            Pair<String, List<String>> node = q.remove();
            String currentWord = node.getKey();
            List<String> currentList = node.getValue();
            if (currentList.size() + 1 > minLength) {
                break;
            }
            for (String word : getRelatedWords(currentWord, dict)) {
                if (visited.getOrDefault(word, Integer.MAX_VALUE) >= currentList.size() + 1) {
                    List<String> list = new ArrayList<>(currentList);
                    list.add(word);
                    if (word.equals(endWord)) {
                        result.add(list);
                        minLength = list.size();
                    } else {
                        q.add(new Pair<>(word, list));
                        visited.put(word, list.size());
                    }
                }
            }
        }
        return result;
    }

    private HashMap<String, List<String>> buildDict(List<String> wordList, int wordlength) {
        HashMap<String, List<String>> dict = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < wordlength; i++) {
                String keyWord = buildConnectWord(word, i);
                List<String> list = dict.getOrDefault(keyWord, new ArrayList<>());
                list.add(word);
                dict.put(keyWord, list);
            }
        });
        return dict;
    }

    private Set<String> getRelatedWords(String s, HashMap<String, List<String>> dict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String keyWord = buildConnectWord(s, i);
            set.addAll(dict.getOrDefault(keyWord, new ArrayList<>()));
        }
        return set;
    }

    private String buildConnectWord(String word, int index) {
        return word.substring(0, index) + "*" + word.substring(index + 1, word.length());
    }
}
