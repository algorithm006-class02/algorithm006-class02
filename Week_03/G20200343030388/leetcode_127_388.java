import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Leetcode_127_388 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        if (beginWord.equals(endWord))
            return 2;

        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));
        Set<String> meets = new HashSet<>(wordList);

        return cal(1, beginSet, endSet, meets);
    }

    public int cal(int level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        if (beginSet.size() == 0 || endSet.size() == 0)
            return 0;
        meets.removeAll(beginSet);
        level++;

        Set<String> newLevelSet = new HashSet<>();
        for (String beginStr : beginSet) {
            char[] chars = beginStr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a'; ch < 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = String.valueOf(chars);
                    if (!meets.contains(newWord))
                        continue;
                    if (endSet.contains(newWord))
                        return level;
                    newLevelSet.add(newWord);
                }

                chars[i] = temp;
            }
        }

        if (newLevelSet.size() <= endSet.size()) {
            beginSet = newLevelSet;
        } else {
            beginSet = endSet;
            endSet = newLevelSet;
        }

        return cal(level, beginSet, endSet, meets);
    }
}
