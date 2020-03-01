import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode_127_024 {
    

    public static void main(String[] args) {
        ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"));
    }

    // 执行时间 1123ms
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> allCombineDict = new HashMap<String, List<String>>();
        wordList.forEach(word->{
            for (int i = 0; i < word.length(); i++){
                String newWord = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> words = allCombineDict.getOrDefault(newWord, new ArrayList<String>());
                words.add(word);
                allCombineDict.put(newWord, words);
            }
        });

        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        int count = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            ++count;
            for (int i = 0; i < queueSize; i++){
                String word = queue.remove();
                for (int j = 0; j < word.length(); j++){
                    String newWord = word.substring(0, j) + "*" + word.substring(j+1);
                    for (String c : allCombineDict.getOrDefault(newWord, new ArrayList<String>())){
                        if (visited.getOrDefault(c, false)){
                            continue;
                        }

                        if (c.equals(endWord)){
                            return count;
                        }

                        queue.add(c);
                    }
                }
                visited.put(word, true);
            }
        }
        
        return 0;
    }

}