//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
//
//
// 示例:
//
// 输入:
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"]
//
// 说明:
//你可以假设所有输入都由小写字母 a-z 组成。
//
// 提示:
//
//
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
//
// Related Topics 字典树 回溯算法


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution212 {
    // 字典树节点
    class TrieNode {
        private int R = 26;
        private TrieNode[] link;
        private boolean isEnd = false;

        public TrieNode() {
            link = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return link[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return link[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            link[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private Set<String> result = new HashSet<>();
    //private List<String> result = new ArrayList<>();
    private int m; // board 行数
    private int n; // board 列数

    public List<String> findWords(char[][] board, String[] words) {
        // 特殊情况
        if (board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        if  (words.length == 0) {
            return new ArrayList<>();
        }

        // 构建字典树
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (int j = 0; j < words[i].length(); j++) {
                if (!node.containsKey(words[i].charAt(j))) {
                    node.put(words[i].charAt(j), new TrieNode());
                }
                node = node.get(words[i].charAt(j));
            }
            node.setEnd();
        }

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.containsKey(board[i][j])) {
                    dfs(board, i, j, "", root);
                }
            }
        }

        ;
        return new ArrayList<>(result);
    }

    /* 四联通遍历数组 */
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private void dfs(char[][] board, int i, int j, String curWord, TrieNode curNode) {
        curWord = curWord.concat(String.valueOf(board[i][j]));
        curNode = curNode.get(board[i][j]);

        if (curNode.isEnd) {
            result.add(curWord);
        }

        char tmp = board[i][j];
        board[i][j] = '*'; // 表示当前字母正在被使用

        // 递归 DFS
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m
                    && y >= 0 && y < n
                    && board[x][y] != '*' && curNode.containsKey(board[x][y])
            ) {
                dfs(board, x, y, curWord, curNode);
            }
        }
        /* 恢复 */
        board[i][j] = tmp;
    }
}
