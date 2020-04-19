# =====================================
# No.208  实现 Trie (前缀树)
# 解题思路：建立字典树，然后查找
# =====================================

class Trie(object):
    def __init__(self):
        self.root = {}
        # 用#标志一个单词的结束
        self.end_of_word = '#'

    # 将单词中的字母插入树中
    def insert(self, word: str):
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.end_of_word] = self.end_of_word


    def search(self, word):
        node = self.root
        for char in word:
            # 如果字母没有在树中，就是false
            if char not in node:
                return False
            node = node[char]
        # 如果#在树中，返回true    
        return self.end_of_word in node


    def startsWith(self, prefix):
        node = self.root
        for char in prefix:
            # 如果字母没有在树中，就是false
            if char not in node:
                return False
            node = node[char]
        return True



if __name__ == '__main__':
    Trie = Trie()
    Trie.insert("apple")
    print(Trie.search("apple"))
    print(Trie.search("app"))
    print(Trie.startsWith("app"))
    Trie.insert("app")
    print(Trie.search("app"))