class Solution:
    def __init__(self):
        self.lens=0
        from collections import defaultdict
        self.word_list_kv=defaultdict(list)
        
    def make_dict_mapping(self,wordList):
        for word in wordList:
            for i in range(self.lens):
                self.word_list_kv[word[:i]+"_"+word[i+1:]].append(word)

    def search_handler(self,que,visited,other_visited):
        word,level=que.pop(0)
        for i in range(self.lens):
            key=word[:i]+"_"+word[i+1:]
            for target in self.word_list_kv.get(key,[]):
                if target in other_visited:
                    return level+other_visited[target]
                if target not in visited:
                    visited[target]=level+1
                    que.append((target,level+1))
        return None 
        
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        """
        思路1: 单向广度优先搜索
        if endWord not in wordList:
            return 0
        from collections import defaultdict
        word_list_kv=defaultdict(list)
        # 数据预处理操作，便于后面查找
        lens=len(endWord)
        for word in wordList:
            for i in range(lens):
                word_list_kv[word[:i]+"_"+word[i+1:]].append(word)
        
        visited={}
        que=[(beginWord,1)]
        while que:
            word,level=que.pop(0)
            if word==endWord:
                return level
            for i in range(lens):
                key=word[:i]+"_"+ word[i+1:]
                for target in word_list_kv.get(key,[]):
                    if target not in visited:
                        visited[target]=True
                        que.append((target,level+1))
        return 0
        """
        if endWord not in wordList:
            return 0

        #思路2： 双向广度优先搜索
        self.lens=len(beginWord)
        # 双向广度优先搜索遍历
        que_begin=[(beginWord,1)]
        que_end=[(endWord,1)]
        visited_beigin={beginWord:1}
        visited_end={endWord:1}
        # initial word_dict_kv
        self.make_dict_mapping(wordList)
      
        while que_begin and que_end:
            begin_search=self.search_handler(que_begin,visited_beigin,visited_end)
            if begin_search:
                return begin_search
            end_search=self.search_handler(que_end,visited_end,visited_beigin)
            if end_search:
                return end_search
        return 0