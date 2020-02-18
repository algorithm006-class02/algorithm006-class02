给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

```
示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49
```

## 题解
1. 采用双指针的办法，从首尾两头像中间逼近。
循环条件：'l < r'
```python
def maxArea(self, height: List[int]) -> int:
        maxArea = 0
        l,r = 0,len(height) -1
        while l < r :
            maxArea = max(maxArea, (r-l)* min(height[l],height[r]))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return maxArea
```
参考老师代码： 更骚气的写法

js代码片段 

```javascript
function(height){
    let l,r,maxAera = 0
    l=0
    r = height.length
    while(l<r){
            minHeight = a[l] < a[r] ?  a[l++] : a[r--] 
            maxAera = max(minHeight*(r-l),maxAera )
    }
    return maxArea
}

```