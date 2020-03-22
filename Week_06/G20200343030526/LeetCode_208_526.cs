/*
 * @lc app=leetcode.cn id=208 lang=csharp
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (63.86%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    28K
 * Total Submissions: 42.7K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start

public class TireNode
{
    private TireNode[] links = new TireNode[26];
    public bool IsEnd { get; set; }
    public void Put(char c, TireNode node) => links[c - 'a'] = node;
    public TireNode Get(char c) => links[c - 'a'];
    public bool ContainsKey(char c) => links[c - 'a'] != null;
}

public class Trie
{
    /** Initialize your data structure here. */
    public Trie()
    {
        root = new TireNode();
    }

    private TireNode root;

    /** Inserts a word into the trie. */
    public void Insert(string word)
    {
        var node = root;
        foreach (var c in word)
        {
            if (node.ContainsKey(c) == false)
                node.Put(c, new TireNode());
            node = node.Get(c);
        }
        node.IsEnd = true;
    }

    /** Returns if the word is in the trie. */
    public bool Search(string word)
    {
       var node = SearchPrefix(word);
       return node != null && node.IsEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string prefix) => SearchPrefix(prefix) != null;

    private TireNode SearchPrefix(string str)
    {
        var node = root;
        foreach (var c in str)
        {
            if (node.ContainsKey(c) == false)
                return null;
            node = node.Get(c);
        }
        return node;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
// @lc code=end

