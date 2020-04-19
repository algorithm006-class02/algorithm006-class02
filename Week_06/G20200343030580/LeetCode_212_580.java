class Solution {
    class Trie {

        private Trie[] nodes = new Trie[26];
        private boolean isEnd = false;

        public Trie() {

        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                node = node.getNode(c) != null ? node.getNode(c) : node.addNode(c);
            }
            node.setEnd(true);
        }


        public boolean search(String word) {
            Trie node = this.searchPrefix(word);
            return node != null && node.isEnd();
        }


        public boolean startsWith(String prefix) {
            Trie node = this.searchPrefix(prefix);
            return node != null;
        }

        private boolean isEnd() {
            return isEnd;
        }

        private void setEnd(boolean end) {
            isEnd = end;
        }

        private Trie addNode(char c) {
            Trie node = new Trie();
            this.nodes[c - 'a'] = node;
            return node;
        }

        private Trie getNode(char c) {
            int index = c - 'a';
            if (index < 0) {
                return null;
            }
            return this.nodes[index];
        }


        private Trie searchPrefix(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                node = node.getNode(c);
                if (node == null) {
                    return null;
                }
            }
            return node;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        Trie node = new Trie();
        for (String word : words) {
            node.insert(word);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                findWords(board, i, j, m, n, node, "", result);
            }
        }
        return result;
    }

    private void findWords(char[][] board, int i, int j, int m, int n, Trie node, String prex, List<String> result) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        char c = board[i][j];
        node = node.getNode(c);
        if (node == null) {
            return;
        } else {
            prex = prex + c;
            if (node.isEnd) {
                if (result.contains(prex) == false) {
                    result.add(prex);
                }
            }
        }
        board[i][j] = '0';
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            findWords(board, i + dx[k], j + dy[k], m, n, node, prex, result);
        }
        board[i][j] = c;
    }
}