### description
Generate Parentheses
Category	Difficulty	Likes	Dislikes
algorithms	Medium (59.68%)	4102	230
Tags
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

### solution
python 1 
bcak track
```python
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        def backtrack(s= '',left= 0,right =0):
            if len(s) == 2*n:
                ans.append(s)
                return
            if left < n:
                backtrack(s+'(',left +1,right)
            if right < left:
                backtrack(s+')',left,right+1)
        backtrack()
        return ans
```
java
```java
class Solution{
    public List<String> generateParenthesis(int n){
    ans = new ArrayList();
    backtrack(ans,"",0,0,n);
    return ans;
    }
    public  void backtrack(List<String> ans,String s, int l,int r,int n){
        if(s.length()== 2*n){
            ans.add(cur)
            return ans
        }
        if(l<n){
            backtrack(ans,s+"("，,l+1,r,n)
        }
        if(l<n){
            backtrack(ans,s+")"，,l,r+1,n)
        }
    }
}

```