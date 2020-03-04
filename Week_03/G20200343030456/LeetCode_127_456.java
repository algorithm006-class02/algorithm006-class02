import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_127 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            LinkedList<String> queue = new LinkedList<String>();
            HashSet<String> visited = new HashSet<String>();
            queue.add(beginWord);
            visited.add(beginWord);
            int count = 0;
            while (!queue.isEmpty()) {
                ++count;
                int size = queue.size();
                //每次遍历一层
                for (int i = 0; i < size; ++i) {
                    String start = queue.pollFirst();
                    //process node
                    //generate related nodes
                    for (String s : wordList) {
                        // 已经遍历的不再重复遍历
                        if (visited.contains(s)) {
                            continue;
                        }
                        //检查是否可以转换
                        if (!canConvert(start, s)) {
                            continue;
                        }
                        // 可以转换，并且能转换成endWord，则返回count
                        if (s.equals(endWord)) {
                            return count + 1;
                        }
                        visited.add(s);
                        queue.add(s);
                    }
                }
            }
            return 0;
        }

        public boolean canConvert(String s1, String s2) {
            int count = 0;
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    ++count;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return count == 1;
        }
    }
}
