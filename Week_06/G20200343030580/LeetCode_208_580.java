class Trie {

    private Trie[] nodes = new Trie[26];
    private boolean isEnd = false;

    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String    word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.getNode(c) != null ? node.getNode(c) : node.addNode(c);
        }
        node.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = this.searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
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
        return this.nodes[c - 'a'];
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