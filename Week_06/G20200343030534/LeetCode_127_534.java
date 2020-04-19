package com.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_BFS_127 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        WordLadder_BFS_127 test = new WordLadder_BFS_127();
        System.out.println(test.ladderLength(beginWord, endWord, wordList));
    }

    Set<String> visited = new HashSet<String>();

    public int ladderLength(String beginWord, String endWord, List<String> input) {
        Set<String> wordList = new HashSet<String>(input);
        boolean canFind = wordList.contains(endWord);
        if (!canFind) {
            return 0;
        }
        String endOfLevel = "EndWord";
        Queue<String> stack = new LinkedList<>();
        stack.add(beginWord);
        stack.add(endOfLevel);
        int level = 1;
        boolean find = false;
        while (!stack.isEmpty()) {
            String currentWord = stack.poll();
            if (currentWord.equals(endOfLevel)) {
                level++;
                if (!stack.isEmpty()) {
                    stack.add(endOfLevel);
                }
                continue;
            }
            if (currentWord.equals(endWord)) {
                find = true;
                break;
            }
            if (visited.contains(currentWord)) {
                continue;
            }
            visited.add(currentWord);
            List<String> words = getAllChangableWord(currentWord, wordList);
            stack.addAll(words);
        }
        if (!find)
            return 0;
        return level;
    }

    private List<String> getAllChangableWord(String currentWord, Set<String> wordList) {
        List<String> allWords = new ArrayList<>();
        for (String word : wordList) {
            if (!visited.contains(word) && canChange(word, currentWord)) {
                allWords.add(word);
            }
        }
        return allWords;
    }

    private boolean canChange(String beginWord, String word) {
        int length = beginWord.length();
        int difCharCount = 0;
        for (int i = 0; i < length; ++i) {
            if (beginWord.charAt(i) != word.charAt(i)) {
                difCharCount++;
            }
        }
        return difCharCount == 1;
    }

}
