### description
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

### solution
递归加回溯
```python
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        def helper(cur, path, begin):
            if cur == 0:
                res.append(path[:])
                return 
            for i in range(begin,len(candidates)):
                if candidates[i] > cur:
                    break
                if i > begin and candidates[i]==candidates[i-1]:  ## 保证不会重复解  ，同时 i > begin  保证第一次进入相同数字，会开始
                    continue
                path.append(candidates[i])
                helper(cur -candidates[i],path,i+1)
                path.pop()

        helper(target,[],0)
        return res
```