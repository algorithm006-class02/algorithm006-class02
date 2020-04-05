学习笔记

不同路径 II
obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]

Longest common sequence(最长子序列)
if(s1[i-1]==s2[j-1])
dp[i][j]=dp[i-1][j-1]+1
else
dp[i][j]=max(dp[i-1][j],dp[i][j-1])

Longest common substring(最长子串)
if(s1[i-1]==s2[j-1])
dp[i][j]=dp[i-1][j-1]+1
else
dp[i][j]=0

字符串匹配算法
1.暴力算法 brute force
2.Rabin-Karp算法
为了避免挨个字符对目标字符串和子串进行比较，我们可以尝试一次性判断两者是否相等。
因此，我们需要一个好的哈希函数。通过哈希函数，我们可以算出子串的哈希值，然后将它
和目标字符串中的子串的哈希值进行比较

Rabin-Karp算法的思想：
1.假设子串的长度为M(pat)，目标字符串的长度为N(txt)
2.计算子串的hash值hash_pat
3.计算目标字符串txt中每个长度为M的子串的hash值（共需要计算N-M+1次）
4.比较hash值：如果hash值不同，字符串必然不匹配；如果hash值相同，还需要使用朴素算法(循环)再次判断

3.KMP算法
设法利用已知信息，不要把“搜索位置”移回已经比较过的位置，继续把它向后移
4.Boyer-Moore算法
5.Sunday算法


