class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0

        wordList = set(wordList)
        word_len = len(beginWord)
        beginSet = {beginWord}
        endSet = {endWord}
        dist = 1
        
        while beginSet:
            dist += 1
            nextSet = set()

            for word in beginSet:
                for i in range(word_len):
                    for c in string.ascii_lowercase:
                        if c != word[i]:
                            new_word = word[:i] + c + word[i + 1:]
                            if new_word in endSet:
                                return dist
                            if new_word in wordList:
                                nextSet.add(new_word)
                                wordList.remove(new_word)
            
            beginSet = nextSet
            if len(beginSet) > len(endSet):
                beginSet, endSet = endSet, beginSet

        return 0
