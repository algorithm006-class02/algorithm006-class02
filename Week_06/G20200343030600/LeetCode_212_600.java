/**
 * 212. 单词搜索2
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class LeetCode_212_600 {
    public List<String> findWords(char[][] board, String[] words) {
        //1. 构建字典树，插入word, 建立prefix；
        //2. board dfs
        Trie trie = new Trie();
        Set<String> result = new HashSet<>();
        for(String word : words) {
            trie.insert(word);
        }
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                buildTrie(board, i, j, "", result, trie);
            }
        }
        return new LinkedList<String>(result);
    }

    private void buildTrie(char[][] board, int i, int j, String str, Set<String> result, Trie trie) {
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == '@') return;

        str += board[i][j];
        if(!trie.startsWith(str)) return;
        if(trie.search(str)) {
            result.add(str);
        }

        char tmp = board[i][j];
        board[i][j] = '@';
        buildTrie(board, i + 1, j, str, result, trie);
        buildTrie(board, i - 1, j, str, result, trie);
        buildTrie(board, i, j + 1, str, result, trie);
        buildTrie(board, i, j - 1, str, result, trie);
        board[i][j] = tmp;
    }

    class Trie {
        private Trie[] links;
        private boolean isEnd;
        private final int R = 26;

        Trie() {
            links = new Trie[R];
        }

        public void insert(String word) {
            Trie tmp = this;
            for (char c : word.toCharArray()) {
                if (tmp.links[c - 'a'] == null)
                    tmp.links[c - 'a'] = new Trie();
                tmp = tmp.links[c - 'a'];
            }
            tmp.isEnd = true;
        }

        public boolean search(String word) {
            Trie tmp = this;
            for (char c : word.toCharArray()) {
                if (tmp.links[c - 'a'] == null)
                    return false;
                tmp = tmp.links[c - 'a'];
            }
            return tmp.isEnd ? true : false;
        }

        public boolean startsWith(String prefix) {
            Trie tmp = this;
            for (char c : prefix.toCharArray()) {
                if (tmp.links[c - 'a'] == null)
                    return false;
                tmp = tmp.links[c - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        LeetCode_212_600 sol = new LeetCode_212_600();
        System.out.println(sol.findWords(board, words));
    }
}