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


import javax.swing.*;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode {
    private final TrieNode[] links;
    private final static int R = 26;
    private String word;

    public TrieNode() {
        this.links = new TrieNode[R];
    }

    public boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

class Solution {

    private static final char USED = '#';
    private TrieNode dictionary;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return result;
        }
        initDictionary(words);
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                search(i, j, dictionary, board, result);
            }
        }
        return result;
    }

    private void search(int row, int col, TrieNode node, char[][] board, List<String> result) {
        //terminator
        char cur = board[row][col];
        if (cur == USED || !node.contains(cur)) {
            return;
        }
        //process sub problems
        node = node.get(cur);
        if (node.getWord()!=null) {
            result.add(node.getWord());
            //放在重复
            node.setWord(null);
        }
        board[row][col] = USED;
        //drill sub problems down
        if (row > 0) {
            search(row - 1, col, node, board, result);
        }
        if (row < board.length - 1) {
            search(row + 1, col, node, board, result);
        }
        if (col > 0) {
            search(row, col - 1, node, board, result);
        }
        if (col < board[row].length - 1) {
            search(row, col + 1, node, board, result);
        }
        //revert
        board[row][col] = cur;
    }

    private void initDictionary(String[] words) {
        dictionary = new TrieNode();
        for (String word : words) {
            TrieNode node = dictionary;
            for (char ch : word.toCharArray()) {
                if (!node.contains(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setWord(word);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
