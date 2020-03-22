/**
 * Created by HuGuodong on 3/22/20.
 */
public class LeetCode_208_364 {

  class Trie {

    class TireNode {

      private final int R = 26;
      TireNode[] links;
      private boolean isEnd;

      public TireNode() {
        links = new TireNode[R];
      }

      public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
      }

      public void put(char ch, TireNode node) {
        links[ch - 'a'] = node;
      }

      public TireNode get(char ch) {
        return links[ch - 'a'];
      }

      public boolean isEnd() {
        return isEnd;
      }

      public void setEnd() {
        isEnd = true;
      }
    }

    TireNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
      root = new TireNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
      TireNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char curChar = word.charAt(i);
        if (!node.containsKey(curChar)) {
          node.put(curChar, new TireNode());
        }
        node = node.get(curChar);
      }
      node.setEnd();
    }

    private TireNode searchPrefix(String word) {
      TireNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char curChar = word.charAt(i);
        if (node.containsKey(curChar)) {
          node = node.get(curChar);
        }
        else {
          return null;
        }
      }
      return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
      TireNode node = searchPrefix(word);
      return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
      return searchPrefix(prefix) != null;
    }
  }
}
