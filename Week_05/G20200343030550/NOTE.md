学习笔记  
1、Dynamic Programming 动态规划（动态递推）  
- 动态规划和递归或分治无本质区别，关键看有无最优子结构；  
- 共性：找到重复子问题；
- 差异性：最优子结构，中途可以淘汰次优解；  
  
2、递归优化（代码优化）： python 
- 列表推导式\lambda
- 记忆化搜索：添加缓存，例如python的LRU Cache  

3、关键点：
- 最优子结构：opt = best_of(opt[n-1]), opt[n-2], ...)
- 储存中间状态:opt[i]
- 递推公式：
  - fib: opt[i] = opt[n-1] + opt[n-2]
  - 二维路径：opt[i,j] = opt[i+1][j] + opt[i][j+1] (且判断a[i,j]是否空地)
  - 
