class LeetCode_208_378 {

    class Trie {
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.lenght(); i++) {
                char cur = word.charAt(i);
                if (!node.containsKey(cur)) {
                    node.put(cur, new TrieNode());
                }
                node = node.get(cur);
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = serchPreFix(word);
            return null != node && node.isEnd;
        }
        private TrieNode serchPreFix(String word){
            TrieNode node = this.root;
            for (int i = 0; i < word.lenght; i++) {
                char cur = word.charAt(i);
                if(node.containsKey(cur)){
                    node = get(cur);
                }else {
                    return null;
                }
            }
            return node;
        }
        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = serchPreFix(prefix);
            return node!=null;
        }
    }

    class TrieNode {
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean getEnd() {
            return isEnd;
        }
    }


}