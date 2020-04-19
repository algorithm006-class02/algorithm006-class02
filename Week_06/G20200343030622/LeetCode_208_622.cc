

class TrieNode
{
public:
    TrieNode() = default;
    ~TrieNode() = default;

    bool is_contains_key(char ch)
    {
        return links_[ch - 'a'] != nullptr;
    }

    TrieNode *get(char ch)
    {
        return links_[ch - 'a'];
    }

    void put(char ch, TrieNode *node)
    {
        links_[ch - 'a'] = node;
    }

    void set_end()
    {
        is_end_ = true;
    }

    bool is_end()
    {
        return is_end_;
    }

private:
    static constexpr int R = 26;
    bool is_end_{false};
    struct TrieNode *links_[R]{nullptr};
};

class Trie
{
public:
    /** Initialize your data structure here. */
    Trie() {}

    /** Inserts a word into the trie. */
    void insert(string word)
    {
        TrieNode *node = root;
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word[i];
            if (!node->is_contains_key(ch))
            {
                node->put(ch, new TrieNode());
            }
            node = node->get(ch);
        }

        node->set_end();
    }

    /** Returns if the word is in the trie. */
    bool search(string word)
    {
        TrieNode *endNode = search_with_prefix(word);
        return endNode != nullptr && endNode->is_end();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix)
    {
        return search_with_prefix(prefix);
    }

private:
    TrieNode *search_with_prefix(string prefix)
    {
        TrieNode *node = root;
        for (int i = 0; i < prefix.length(); i++)
        {
            char ch = prefix[i];
            if (node->is_contains_key(ch))
            {
                node = node->get(ch);
            }
            else
            {
                return nullptr;
            }
        }

        return node;
    }

    TrieNode *root{new TrieNode()};
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */