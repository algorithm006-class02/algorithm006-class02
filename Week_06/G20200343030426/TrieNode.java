package com.ping.leetcode.medium.Trie208;

/**
 * @Author: 高一平
 * @Date: 2020/3/22
 * @Description:
 **/
public class TrieNode {

    /**
     * 子节点，节点数最多为R个
     */
    private TrieNode[] links;

    /**
     * 因为字母有26个，所以R=26
     */
    private final int R = 26;

    /**
     * 是否是一个完整词汇的结尾
     */
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    /**
     * 根据字符编码值的差值为下标进行存取
     *
     * @param ch
     * @return
     */
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    /**
     * 根据字符编码值的差值为下标进行存取
     *
     * @param ch
     * @return
     */
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    /**
     * 根据字符编码值的差值为下标进行存取
     *
     * @param ch
     * @param node
     */
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}
