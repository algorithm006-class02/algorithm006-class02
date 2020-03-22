# 126. 单词接龙 II


# class Solution:
#     def findLadders(
#         self, beginWord: str, endWord: str, wordList: List[str]
#     ) -> List[List[str]]:
#         wordList = set(wordList)
#         res = []
#         layer = {}
#         layer[beginWord] = [[beginWord]]

#         while layer:
#             newlayer = collections.defaultdict(list)
#             for w in layer:
#                 if w == endWord:
#                     res.extend(k for k in layer[w])
#                 else:
#                     for i in range(len(w)):
#                         for c in "abcdefghijklmnopqrstuvwxyz":
#                             neww = w[:i] + c + w[i + 1 :]
#                             if neww in wordList:
#                                 newlayer[neww] += [j + [neww] for j in layer[w]]

#             wordList -= set(newlayer.keys())
#             layer = newlayer

#         return res

import collections
import string


class Solution:
    def arrive(self, wordSet):
        result = collections.defaultdict(set)
        for w in wordSet:
            for i in range(len(w)):
                for c in string.ascii_lowercase:
                    neww = w[:i] + c + w[i + 1 :]
                    if (neww in wordSet) and (neww != w):
                        result[w].add(neww)
        return result

    def findLadders(self, beginWord, endWord, wordList):
        wordList = set(wordList)
        result = []
        level = {}
        level[beginWord] = [[beginWord]]
        while level:
            nextlevel = collections.defaultdict(list)
            for node in level:
                if node == endWord:
                    result.extend(k for k in level[node])
                else:
                    for i in range(len(node)):
                        for c in string.ascii_lowercase:
                            newnode = node[:i] + c + node[i + 1 :]
                            if newnode in wordList:
                                nextlevel[newnode] += [j + [newnode] for j in level[node]]
            # 没想明白
            wordList -= set(nextlevel.keys())
            level = nextlevel
        return result


solution = Solution()
beginWord = "hit"
endWord = "cog"
case = ["hot", "dot", "dog", "lot", "log", "cog"]
print(solution.findLadders(beginWord, endWord, case))
