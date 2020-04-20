class Trie:
    """ Implement a trie with insert, search, and startsWith methods.
    """
    def __init__(self):
        """
        Initialize your data structure here.
        """
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
 		t = self.trie
		for c in word:
			if c not in t: t[c] = {}
			t = t[c]
		t["-"] = True
       

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
		t = self.trie
		for c in word:
			if c not in t: return False
			t = t[c]
		return "-" in t        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
		t = self.trie
		for c in prefix:
			if c not in t: return False
			t = t[c]
		return True