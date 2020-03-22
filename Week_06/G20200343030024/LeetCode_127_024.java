class Solution {
  
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
       if (!wordList.contains(endWord)) return 0;
       if (beginWord.equals(endWord)) return 2;

        Set<String> start = new HashSet<String>(Collections.singleton(beginWord));
        Set<String> end = new HashSet<String>(Collections.singleton(endWord));
        Set<String> meets = new HashSet<String>(wordList);

        return this._search(1, start, end, meets);

    }

    public int _search(int level, Set<String> startSet, Set<String> endSet, Set<String> meets){
       if (startSet.size() == 0 || endSet.size() == 0) return 0;

        meets.removeAll(startSet);
        Set<String> nextLevel = new HashSet<String>();
        level++;

        for(String word : startSet){
            char[] wc = word.toCharArray();
            for (int i = 0; i < wc.length; i++){
                char wc1 = wc[i];
                for (char c = 'a' ; c < 'z'; c++){
                    wc[i] = c;
                    String newWord = String.valueOf(wc);

                    if (!meets.contains(newWord)) continue;
                    if (endSet.contains(newWord)) return level;

                    nextLevel.add(newWord);

                }
                wc[i] = wc1;
            }
        }

        if (nextLevel.size() < endSet.size()){
            startSet = nextLevel;
        } else {
            startSet = endSet;
            endSet = nextLevel;
        }

        return this._search(level, startSet, endSet, meets);
    }
}