import java.util.*;

public class LeetCode_126_422 {
    List<List<String>> results;
    List<String> list;
    Map<String, List<String>> map;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<List<String>>();
        if (wordList.size() == 0) {
            return results;
        }

        int curr = 1, next = 0;
        boolean found = false;
        list = new LinkedList<String>();
        map = new HashMap<String, List<String>>();

        Queue<String> queue = new ArrayDeque<String>();
        Set<String> unvisited = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();

        queue.add(beginWord);
        unvisited.add(endWord);
        unvisited.remove(beginWord);
        while (!queue.isEmpty()) {

            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (unvisited.contains(newWord)) {
                        if (visited.add(newWord)) {
                            next++;
                            queue.add(newWord);
                        }

                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> l = new LinkedList<String>();
                            l.add(word);
                            map.put(newWord, l);
                        }

                        if (newWord.equals(endWord) && !found) {
                            found = true;
                        }

                    }

                }
            }
            if (curr == 0) {
                if (found) {
                    break;
                }
                curr = next;
                next = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }

        backTrace(endWord, beginWord);

        return results;
    }

    private void backTrace(String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                backTrace(s, start);
            }
        }
        list.remove(0);
    }
}
