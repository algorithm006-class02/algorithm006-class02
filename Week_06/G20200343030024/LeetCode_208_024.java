class Trie {

    final TrieNode root = new TrieNode();

   /**
    * Initialize your data structure here.
    */
   public Trie() {
   }

   /**
    * Inserts a word into the trie.
    */
   public void insert(String word) {
       char[] wc = word.toCharArray();
       TrieNode node = root;
       for (char c : wc) {
           node = node.insert(c);
       }
       node.setEnd();
   }

   /**
    * Returns if the word is in the trie.
    */
   public boolean search(String word) {
       char[] wc = word.toCharArray();
       TrieNode node = root;
       for (char c : wc) {
           if (!node.containsKey(c)) {
               return false;
           }
           node = node.get(c);
       }

       return node.isEnd();
   }

   /**
    * Returns if there is any word in the trie that starts with the given prefix.
    */
   public boolean startsWith(String prefix) {
       char[] wc = prefix.toCharArray();
       TrieNode node = root;
       for (char c : wc) {
           if (!node.containsKey(c)) {
               return false;
           }
           node = node.get(c);
       }

       return true;
   }

   class TrieNode {
       final TrieNode[] data = new TrieNode[26];
       boolean end;

       boolean containsKey(char v) {
           return data[v - 'a'] != null;
       }

       TrieNode insert(char v) {
           TrieNode node = get(v);
           if (node == null){
               node = new TrieNode();
               data[v - 'a'] = node;
           }
           return node;
       }

       TrieNode get(char v) {
           return data[v - 'a'];
       }

       boolean isEnd() {
           return end;
       }

       void setEnd() {
           this.end = true;
       }

   }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/