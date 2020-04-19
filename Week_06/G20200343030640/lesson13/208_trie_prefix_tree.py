"""
208. 实现 Trie (前缀树)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
"""

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.alphatableSize = 26
        self.children = [None] * self.alphatableSize

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()


    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for ch in word:
            if node.children[ord(ch)-ord('a')] is None:
                node.children[ord(ch)-ord('a')] = TrieNode()
            node = node.children[ord(ch)-ord('a')]

        node.isEnd = True


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for ch in word:
            if node.children[ord(ch)-ord('a')] is None:
                return False
            node = node.children[ord(ch)-ord('a')]

        return node.isEnd


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for ch in prefix:
            if node.children[ord(ch)-ord('a')] is None:
                return False
            node = node.children[ord(ch)-ord('a')]

        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)