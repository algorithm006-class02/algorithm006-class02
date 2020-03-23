class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lookup = {}


    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.lookup
        for c in word:
            node = node.setdefault(c, {})
        node["#"] = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.lookup
        for c in word:
            if c in node:
                node = node[c]
            else:
                return False
        return "#" in node


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.lookup
        for c in prefix:
            if c in node:
                node = node[c]
            else:
                return False
        return True

