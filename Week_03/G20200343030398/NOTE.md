# 学习笔记

## 小结

很多题最简洁牛逼的算法，都是数学或逻辑上辨析本质后的算法
贪心算法是否最优解也是数学和逻辑上的辨析

## 解题

### leetcode 169

中文网站官方里面有误导，题目是多数元素，却一直说众数（数学上有众数，不要求count>n//2）
Boyer-Moore 投票算法，想清楚了确实牛逼，假设结果是result，其他为other1，other2：
1. index为result时，index+1为other时，两个抵消，反正result的count>n//2
2. index为other1，index+1为other2时，两个抵消，因为两个都不可能当选，两个没有相对优势
3. 最后的count不一定等于result出现的次数

### leetcode 126

1. 广度遍历的思想 nextlevel的生成方式是把下一步所有结果找出来
2. wordList -= set(nextlevel.keys())没想明白