package week6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * 输出: ["eat","oath"]
 * <p>
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 */
public class WordSearch {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void test() {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        System.out.println("同时在二维网格和字典中出现的单词:" + new WordSearch().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        //　字典树 + 回溯
        // 重点在于构建一个字典树，构建完成之后，搜索的话就很简单了
        TrieNode trie = buildTrie(words);
        List<String> result = new ArrayList<>();
        // 搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsHelper(board, i, j, trie, result);
//                dfsHelper2(board, i, j, trie, result);
            }
        }
        return result;
    }

    private void dfsHelper(char[][] board, int i, int j, TrieNode trie, List<String> result) {
        char c = board[i][j];
        if (c == '.' || trie.children[c - 'a'] == null) return;
        trie = trie.children[c - 'a'];
        if (!trie.word.equals("")) {
            result.add(trie.word);
            trie.word = ""; // 去重
        }
        board[i][j] = '.';
        // 上下左右
        if (i > 0)
            dfsHelper(board, i - 1, j, trie, result);
        if (i < board.length - 1)
            dfsHelper(board, i + 1, j, trie, result);
        if (j > 0)
            dfsHelper(board, i, j - 1, trie, result);
        if (j < board[0].length - 1)
            dfsHelper(board, i, j + 1, trie, result);
        board[i][j] = c;
    }


    private void dfsHelper2(char[][] board, int i, int j, TrieNode trie, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '.' || trie.children[c - 'a'] == null) return;
        trie = trie.children[c - 'a'];
        if (!trie.word.equals("")) {
            result.add(trie.word);
            trie.word = null; // 去重
        }
        board[i][j] = '.';
        for (int k = 0; k < 4; k++) {
            // 上下左右
            dfsHelper2(board, i + dx[k], j + dy[k], trie, result);
        }
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            TrieNode root = trie;
            for (char letter : word.toCharArray()) {
                int index = letter - '0';
                if (root.children[index] == null) root.children[index] = new TrieNode();

                root = root.children[index];
            }
            root.word = word;
        }
        return trie;
    }


    public List<String> findWords2(char[][] board, String[] words) {
        //　字典树 + 回溯
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> result = new HashSet<String>();
        int depth = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[depth][width];
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < width; j++) {
                dfsHelper(board, visited, "", i, j, trie, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfsHelper(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie, Set<String>
            result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        str += board[i][j];
        if (visited[i][j] || !trie.startsWith(str)) return;

        if (trie.search(str)) result.add(str);

        visited[i][j] = true;
        dfsHelper(board, visited, str, i - 1, j, trie, result);
        dfsHelper(board, visited, str, i + 1, j, trie, result);
        dfsHelper(board, visited, str, i, j - 1, trie, result);
        dfsHelper(board, visited, str, i, j + 1, trie, result);
        visited[i][j] = false;
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
            node.isEnd = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.word.equals(word);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = "";
        boolean isEnd;
    }
}
