300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

### solution

O(n*n):
dp[i] = max(dp[i],dp[j]+1) if nums[i] > nums[j] && j < i
```python
     def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:return 0
        dp = []
        for i in range(len(nums)):
            dp.append(1)
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1 )
        return max(dp)
```

better:
o(N*lGN)python
```python
     def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:return 0
        dp = []
        for i in range( len(nums) ):
            if not dp or dp[-1] < nums[i]:
                dp.append( nums[i] )
            else:
                l,r = 0, i
                loc = i
                while l <= r:# bi-search first num > nums[i], subsitute it
                    mid = (l + r) >> 1
                    if dp[mid] >= nums[i]:
                        loc = mid 
                        r = mid -1
                    else:
                        l = mid +1
                dp[loc] = nums[i]
        return len(dp)
 

```


C++
```C++
class Solution{
    public:
    int lengthOfLIS(vector<int> &nums){
        int len=1, n=(int nums.size());
        if(n==0) return 0;
        vector<int > d(n+1,0);
        d[len] = nums[0];
        for(int i = 1; i < n; ++i){
            if(nums[i]>d[len]) d[++len] = nums[i];
            else{
                int l = 1, r = len, pos = 0;
                while(l <= r){
                    int mid = (l+r)>>1;
                    if(d[mid] <nums[i]){
                        pos = mid;
                        l = mid +1;
                    }
                    else r = mid -1;
                }
                d[pos+1] = nums[i]
            }
        }
    }
}
```