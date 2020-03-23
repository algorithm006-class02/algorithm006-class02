package com.sebar.test.leetcode.six.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-search-ii/
 * 212. 单词搜索 II
 */
public class Leetcode_212_566 {
    public List<String> findWords(char[][] board, String[] words) {
        // 初始化字典树
        Trie trie = new Trie();
        TrieNode root = trie.root;
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> resSet = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // 遍历整个二维数组进行查找
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, visited, i, j, m, n, resSet, root);
            }
        }
        return new ArrayList<>(resSet);
    }

    /**
     * 开始进行寻找
     *
     * @param board
     * @param visited
     * @param i
     * @param j
     * @param m
     * @param n
     * @param resSet
     * @param root
     */
    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> resSet, TrieNode root) {
        // stop terminator
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }

        root = root.child[board[i][j] - 'a'];
        visited[i][j] = true;

        if (root == null) {
            // 如果找到的单词不匹配，则返回
            visited[i][j] = false;
            return;
        }
        if (root.isEnd) {
            resSet.add(root.val);
            visited[i][j] = false;
            return;
        }
        find(board, visited, i + 1, j, m, n, resSet, root);
        find(board, visited, i, j + 1, m, n, resSet, root);
        find(board, visited, i, j - 1, m, n, resSet, root);
        find(board, visited, i - 1, j, m, n, resSet, root);
        // 最后回退一个字符，因为下一个起点可能会用到上一个起点的字符
        visited[i][j] = false;
    }

    class Trie {
        private TrieNode root = new TrieNode();

        public void insert(String s) {
            TrieNode temp = this.root;
            for (char c : s.toCharArray()) {
                if (temp.child[c - 'a'] == null) {
                    temp.child[c - 'a'] = new TrieNode();
                }
                temp = temp.child[c - 'a'];
            }
            temp.isEnd = true;
            temp.val = s;
        }
    }

    class TrieNode {
        private String val;
        public TrieNode[] child = new TrieNode[26];
        public boolean isEnd = false;

        TrieNode() {
        }
    }

    public static void main(String[] args) {
        Leetcode_212_566 coco = new Leetcode_212_566();
//        char[][] board=new char[4][4];
//        board[0][0]='o';
//        board[0][1]='a';
//        board[0][2]='a';
//        board[0][3]='n';
//        board[1][0]='e';
//        board[1][1]='t';
//        board[1][2]='a';
//        board[1][3]='e';
//        board[2][0]='i';
//        board[2][1]='h';
//        board[2][2]='k';
//        board[2][3]='r';
//        board[1][0]='i';
//        board[1][1]='f';
//        board[1][2]='l';
//        board[1][3]='v';
        char[][] board = new char[2][2];
        board[0][0] = 'a';
        board[0][1] = 'b';
        board[1][0] = 'c';
        board[1][1] = 'd';

//        List<String> words = coco.findWords(board, new String[]{"oath", "pea", "eat", "rain"});
        List<String> words = coco.findWords(board, new String[]{"ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb"});
        System.out.println(words);
    }
}
