class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if beginWord==endWord:
            return 1

        wordList=set(wordList)

        if endWord not in wordList:
            return 0
            
        t=1
        nextlist={beginWord}
        end_set={endWord}
        begin_set=nextlist
        while begin_set and end_set:
            t=t+1
            nextlist=set()
            if len(begin_set) > len(end_set):begin_set, end_set = end_set, begin_set
            for word in begin_set:
                for i in range(len(word)):
                    part1=word[:i]
                    part2=word[i+1:]
                    for j in 'qwertyuiopasdfghjklzxcvbnm':
                        if word[i]!=j:
                            nextword=part1+j+part2
                            if nextword in wordList:
                      
                                nextlist.add(nextword)
                                wordList.remove(nextword)
                            if nextword in end_set:return t

        
            begin_set=nextlist

        return 0