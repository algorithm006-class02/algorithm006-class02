# 学习总结

## 来自超哥的总结

### 时刻需要注意的

- 拒绝人肉递归
- 找最近重复子问题
- 数学归纳法

### 基本套路

```js
function recursion(data, level) {
  // terminator
  if (data.length === level) return

  // process current logic
  process(data)

  // drill down
  recursion(data, level + 1)

  // reverse status
}
```

## 个人刷题感悟
> 目前还处在混沌中...

- 还是容易陷入人肉递归，总感觉不人肉下，逻辑理不清。一旦人肉了，更理不清

- 感觉要想理清楚，需要画出递归树，这是很关键的。递归树一旦画出来了，整个代理的执行基本上有了个清晰的脉络。。。

- 写了一些递归的题目，总结起来感觉需要把`process current logic`的代码和`drill down`的代码写对位置，因为有时候有好几个`drill down`的代码。`process current logic`的代码写在不同的位置，会得到不同的结果，比如`二叉树的前，中，后序遍历`

- 目前题目写的太少，遇到很多递归题目还是比较懵逼。比如`回溯`，往往回不去。。。