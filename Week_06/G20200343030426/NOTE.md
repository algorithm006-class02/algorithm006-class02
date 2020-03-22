# 学习笔记

这一周内容很多，工作之余完成，实在有些吃力...

不过这一周还是很有收获的

一个以前的困惑，再括号生成的那一部分，那时我很疑惑，递归列出所有情况的代码，直接递归调用加“(”，直接递归调用加“)”，为何会列出所有情况，调用完第一行一种情况的递归之后，后面那行另一种情况递归的调用，不是不能执行了么？一直没有解决这个疑惑，导致我写代码全部避开这部分内容

因为动态规划实在比较吃力，所以这周主要花时间在递归、贪心、分治、回溯、动态规划上，这周花时间仔细debug了一下，再结合了一道题目，出自《数据结构与算法之美》，对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？

```
// 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
private int[] weight = {2，2，4，6，3};  // 物品重量
private int n = 5; // 物品个数
private int w = 9; // 背包承受的最大重量
public void f(int i, int cw) { // 调用f(0, 0)
  if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
    if (cw > maxW) maxW = cw;
    return;
  }
  f(i+1, cw); // 选择不装第i个物品
  if (cw + weight[i] <= w) {
    f(i+1,cw + weight[i]); // 选择装第i个物品
  }
}
```

发现执行完上一条语句后，当前方法内所有变量都没有改变，也就是说，上一句的递归实现，对下一句的递归完全没有影响，是互不干扰的两种可能，我的榆木脑袋终于开了点窍...

动态规划我目前还是无法脱离题解，我先用笨一点的方法，把空间复杂度高的那个先掌握了再说吧，为此写了一个方法，专为打印中间状态

```
public static void print(String[][] param) {
	System.out.println("===================================");
	for (String[] row : param) {
		print(row);
	}
	System.out.println("===================================");
}
	
public static void print(String[] param) {
	StringBuilder result = new StringBuilder();
	result.append(TAG);
	for (String col : param) {
		result.append(col).append(TAG);
	}
	System.out.println(result.toString());
}
```

打印出所有中间状态，笨有笨招...

```
@SpringBootTest
class CommonTest {
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    @Test
    public void dynamic() {
        knapsack(weight, n, w);
    }

    // weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        MultiArrayUtils.print(states);
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        MultiArrayUtils.print(states);
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
            MultiArrayUtils.print(states);
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i - 1][j] == true) {
                    states[i][j] = states[i - 1][j];
                }
                MultiArrayUtils.print(states);
            }
            for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j] == true) {
                    states[i][j + weight[i]] = true;
                }
                MultiArrayUtils.print(states);
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i] == true) return i;
        }
        return 0;
    }
}
```

动态规划些微有了些感觉，算是这周一个大跨步吧

然后是这周课程，听完没有记住多少，根据作业选择，显示主抓了字典树

```
public class TrieNode {

    /**
     * 子节点，节点数最多为R个
     */
    private TrieNode[] links;

    /**
     * 因为字母有26个，所以R=26
     */
    private final int R = 26;

    /**
     * 是否是一个完整词汇的结尾
     */
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    /**
     * 根据字符编码值的差值为下标进行存取
     *
     * @param ch
     * @return
     */
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    /**
     * 根据字符编码值的差值为下标进行存取
     *
     * @param ch
     * @return
     */
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    /**
     * 根据字符编码值的差值为下标进行存取
     *
     * @param ch
     * @param node
     */
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}

```

其中比较困惑那个isEnd参数，本以为是用来标识该节点是否是叶子节点，但发现它没有赋值为false的操作，这就比较迷了，我纠结了好久，然后对应实际场景，突然意识到，它是为了标识，到那个节点，之前的路径上的字符可共同组成一个完整单词，感觉非常巧妙

这周比较匆忙，其他的知识点目前比较缥缈，需要做题细品了
