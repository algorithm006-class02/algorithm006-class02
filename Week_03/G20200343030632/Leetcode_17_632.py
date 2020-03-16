class Solution:
    def letterCombinations(self, digits: str):
        if not digits:
            return []
        str_maps = {
            '2' : 'abc',
            '3' : 'def',
            '4' : 'ghi',
            '5' : 'jkl',
            '6' : 'mno',
            '7' : 'pqrs',
            '8' : 'tuv',
            '9' : 'wxyz'
        }

        als = [list(str_maps.get(ch)) for ch in digits if ch in str_maps]
        # als = [item for ch in digits for item in str_maps.get(ch, []) if ch in str_maps]
        res = []
        self.helper(0, len(als), als, [], res)
        return res
    def helper(self, level, num, als, curpath, res):

        if len(curpath) == num or level >= num:
            # print(level, als[level])
            res.append(''.join(curpath))
            return
        #  select list
        for ch in als[level]:
            self.helper(level + 1, num, als, curpath + [ch], res)
                
    
if __name__ == "__main__":
    obj = Solution()
    obj.letterCombinations("")