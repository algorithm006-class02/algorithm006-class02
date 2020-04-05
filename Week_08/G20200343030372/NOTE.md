## 学习笔记

#### 高级动态规划
    复杂度来源：
        1. 状态拥有更多维度（二维、三维、或者更多、甚至需要压缩）
        2. 状态方程更加复杂
        
#### 字符串
在Java和Python中，String 是不可变（immutable）的，任何修改都是新生成一个字符串

Java中：
```
    String x = "";
    String y = "";
    x == y  ==> false
    x.equals(y) ==> true  
```

常见问题：

1. 字符串遍历
2. 比较字符串
3. 字符串操作
4. 异位词问题
5. 回文串问题

高级字符串算法

1. 最长子序列(Longest common sequence)
    ```
    dp[i][j] = dp[i-1][j-1] + 1 (if s1[i-1] == s2[j-1]) 
    else dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    ```

2. 最长子串(Longest common substring)
    ```
    dp[i][j] = dp[i-1][j-1] + 1 (if s1[i-1] == s2[j-1]) 
    else dp[i][j] = 0
    ```

3. 编辑距离(Edit distance)
