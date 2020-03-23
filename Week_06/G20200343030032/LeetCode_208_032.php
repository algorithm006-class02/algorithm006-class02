<?php
/**
 * 208. 实现 Trie (前缀树)
 */

class TrieNode
{
    public $isEnd = false;
    public $next = [];
}

class Trie
{
    private $root;

    /**
     * Initialize your data structure here.
     */
    function __construct()
    {
        $this->root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word)
    {
        $len = strlen($word);
        $node = $this->root;
        for ($i = 0; $i < $len; $i++) {
            $index = $word[$i];
            if (!isset($node->next[$index]))
                $node->next[$index] = new TrieNode();
            $node = $node->next[$index];
        }
        !$node->isEnd && $node->isEnd = true ;
    }

    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word)
    {
        $len = strlen($word);
        $node = $this->root;
        for ($i = 0; $i < $len; $i++) {
            $index = $word[$i];
            if (!isset($node->next[$index]))
                return false;
            $node = $node->next[$index];
        }
        return $node->isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix)
    {
        $len = strlen($prefix);
        $node = $this->root;
        for ($i = 0; $i < $len; $i++) {
            $index = $prefix[$i];
            if (!isset($node->next[$index]))
                return false;
            $node = $node->next[$index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * $obj = Trie();
 * $obj->insert($word);
 * $ret_2 = $obj->search($word);
 * $ret_3 = $obj->startsWith($prefix);
 */

$obj = new Trie();
$word = 'apple';
$obj->insert($word);
$ret_2 = $obj->search($word);
$prefix = 'app';
$ret_3 = $obj->startsWith($prefix);

