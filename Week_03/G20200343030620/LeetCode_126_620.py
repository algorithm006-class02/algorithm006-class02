class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList:
            return []     
        # 使用DFS 算法进行求解
        from collections import defaultdict
        word_list_kv=defaultdict(list)
        # 数据预处理操作，便于后面查找
        lens=len(endWord)
        for word in wordList:
            for i in range(lens):
                word_list_kv[word[:i]+"_"+word[i+1:]].append(word)
        #使用一个参数来记录最短路径,特别需要注意,两个变量的使用
        self.res=[]
        self.min_path=float('inf')
        """
        def dfs(start,tmp):
            if start==endWord:
                if self.min_path >len(tmp):
                    self.res=[]
                    self.min_path=len(tmp)
                    self.res.append(tmp)
                elif self.min_path==len(tmp):
                    self.res.append(tmp)
                return 
            if len(tmp)>self.min_path:
                return
            for i in range(lens):
                key=start[:i]+"_"+start[i+1:]
                for word in word_list_kv.get(key,[]):
                    if word not in tmp:
                        dfs(word,tmp+[word])
        dfs(beginWord,[beginWord])
        
        #*******优化思路1*********
        # 上述DFS的解法导致了太多不必要的搜索，如果遍历过了则进行剪枝---此处主要是通过bfs来进行层次节点记录
        self.distance={beginWord:0}
        # bfs 来找到endWord所在的层，同时将遍历节点存储起来，之后不再进行更新
        def bfs(start):
            que=[(start,0)]
            is_find=False 
            while que:
                for _ in range(len(que)):
                    node,level=que.pop(0)
                    for i in range(lens):
                        key=node[:i]+"_"+node[i+1:]
                        for word in word_list_kv.get(key,[]):
                            if word not in self.distance:
                                self.distance[word]=level+1
                                que.append((word,level+1))
                                if word==endWord:
                                   is_find=True 
                if is_find:
                    break 

        def dfs(start,tmp):
            if start==endWord:
                self.res.append(tmp)
                return
            for i in range(lens):
                key=start[:i]+"_"+start[i+1:]
                for word in word_list_kv.get(key,[]):
                    if word not in self.distance:
                        continue 
                    if self.distance[start]+1==self.distance[word]:
                        dfs(word,tmp+[word])
        bfs(beginWord)
        dfs(beginWord,[beginWord])
        """
        """
        # *********在优化思路1的基础上进一步优化----此处为解法错误***************
        # 对上述使用distance 来记录有效的路径的情况进一步优化,直接对路径中的邻接节点剪枝

        word_neiger=defaultdict(list)
        for word in wordList+[beginWord]:
            for i in range(lens):
               key=word[:i]+"_"+word[i+1:]
               for neiger in word_list_kv[key]:
                    if neiger not in word_neiger[word] and neiger!=word :
                        word_neiger[word].append(neiger)

            
        def bfs(start):
            que=[start]
            visited=[start]
            is_find=False
            while que:
                subs=[]
                for _ in range(len(que)):
                    node=que.pop(0)
                    # 注意此处copy()的使用，不使用该函数则会出现 [a,b,c],如果b在visited中，b 就不会遍历
                    for word in word_neiger[node].copy():
                        # 表示该节点在上层没有出现过
                        if word not in visited:
                            que.append(word)
                            subs.append(word)
                            if word==endWord:
                                is_find=True
                        else:
                            word_neiger[node].remove(word)    
                visited.extend(subs)
                if is_find:
                    break
               

        def dfs(start,tmp):
            if start==endWord:
                self.res.append(tmp)
                return
            for word in word_neiger[start]:
                if word not in tmp:
                    dfs(word,tmp+[word]) 
        bfs(beginWord) 
        dfs(beginWord,[beginWord]) 
        return self.res 
        """
        #思路2: 使用BFS 算法进行求解-----路径记录法
        wordList=set(wordList)
        layer={}
        layer[beginWord]=[[beginWord]]
    
        while layer:
            level=defaultdict(list)
            for word in layer:
                if word==endWord:
                    self.res.extend(layer[word])
                else:
                    for i in range(lens):
                        key=word[:i]+"_"+word[i+1:]
                        for new in word_list_kv[key]:
                            if new in wordList:
                                level[new]+=[j+[new] for j in layer[word]]
            wordList-=set(level.keys())
            layer=level
        return self.res