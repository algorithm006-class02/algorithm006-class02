class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        if (wordSet.contains(endWord) == false) {
            return 0;
        }
        Set<String> frontSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
        frontSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (frontSet.isEmpty() == false && endSet.isEmpty() == false) {
            if (frontSet.size() > endSet.size()) {
                Set<String> tmp = frontSet;
                frontSet = endSet;
                endSet = tmp;
            }
            Set<String> tmp = new HashSet<>();
            for (String s : frontSet) {
                char[] scs = s.toCharArray();
                for (int i = 0; i < scs.length; i++) {
                    for (char newchar = 'a'; newchar <= 'z'; newchar++) {
                        char oldc = scs[i];
                        if (newchar == oldc) {
                            continue;
                        }
                        scs[i] = newchar;
                        String newString = new String(scs);
                        if (endSet.contains(newString)) {
                            return len + 1;
                        }
                        if (wordSet.contains(newString) && visited.contains(newString) == false) {
                            visited.add(newString);
                            tmp.add(newString);
                        }
                        scs[i] = oldc;
                    }
                }
            }
            frontSet = tmp;
            len++;
        }
        return 0;
    }
}
