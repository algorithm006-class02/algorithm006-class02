class TrieNode{
    TrieNode[] child;
    boolean is_end;
    public TrieNode(){
        child = new TrieNode[26];
        is_end = false;
    }
}
class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode ptr = root;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if(ptr.child[c - 'a'] == null){
                ptr.child[c - 'a'] = new TrieNode();
            }
            ptr = ptr.child[c - 'a'];
        }
        ptr.is_end = true;
    }
    public boolean search(String word) {
        TrieNode ptr = root;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if(ptr.child[c - 'a'] == null){
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return ptr.is_end;
    }
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for(int i = 0;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(ptr.child[c - 'a'] == null){
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return true;
    }
}
