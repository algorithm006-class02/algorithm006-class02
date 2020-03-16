学习笔记
一、回顾 分治+回溯+递归+动态规划

1.递归代码模板

public void recur(int level, int param){
    //terminator 结束条件
    if(level > MAX_LEVEL){
        //process result
        return;
    }
    //process current logic 处理当前层逻辑
    process(level, param);
    //drill down 下探到下一层
    recur(level+1, newParam);
    //restore current status 恢复当前层状态，如果是简单变量就不需要恢复
}
2.分治

分治也是递归，是递归的一种特殊形式，把一个大问题分解成几个子问题，然后分别计算，计算出来把结果返回，把结果聚合在一起

public String divide_conquer(T[] problem,int param1){
    //递归终止条件
    if(problem == null) 
        return;

    //处理当前层并拆分
    String data = prepare_data(problem);
    T[] sub_problems = split_problem(problem, data);

    //拆分调子问题的递归函数
    String subresult1 = divide_conquer(sub_problems[0],param1);
    String subresult2 = divide_conquer(sub_problems[1],param1);

    //合并
    return process_result(subresult1,subresult2);
    //恢复当前层的状态
}
算法本质：寻找重复性——>计算机指令集

二、动态规划（Dynamic Programming 也叫动态递推）：本质要解决的就是递归和分治问题，但跟普通递归分治稍微不同就是它拥有最优子结构以及中途可以淘汰次优解。将一个复杂的问题分解成简单的子问题 用一种递归的方式（分治），每次只需要存最优的子结果

1.Fibonacci数列问题

//傻递归 时间复杂度是指数级别O(2^n)
int fib (int n) {
    if (n <= 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        return fib (n -1) + fibo (n-2);
    }
}

//简洁
int fib (int n){
    return n <= 1 ? n : fib (n-1) + fib (n-2);
}

//加数组 记忆化搜索 时间复杂度O(n)
int fib (int n, int[] memo){
    if (n <= 1){
        return n;
    }
    
    if (memo[n] == 0){
        memo[n] = fib (n-1) + fib (n-2);
    }
    return memo[n];
}
2.路径计算 Count the paths

两个小人，起始一个在左上角，结束一个人在右下角，每次只能走下和右两个方向，中间会有一些障碍，问有多少条路径可以走到结束位置

int countPaths(boolean[][] grid, int row, int col) {
    if (!validSquare(grid, row, col) return 0;
    if (isAtEnd(grid, row, col) return 1;
    return countPaths (grid, row+1, col) + countPaths (grid, row, col+1);
}

状态转移方程（DP方程）
opttimal：最优
opt[i,j]=opt[i+1,j]+opt[i,j+1]
逻辑：
if a[i,j] = '空地':
    opt[i,j] = opt[i+1,j]+opt[i,j+1]
else:
    opt[i,j] = 0
3.动态规划关键点

最优子结构 opt[n] = best_of(opt[n-1], opt[n-2],...)
存储中间状态:opt[i]
递推公式（状态转移方程或者DP方程）
    Fio:opt[i] = opt[n-1] + opt[n-2]
    二维路径:opt[i,j] = opt[i+1][j] + opt[i][j+1]（且判断a[i,j]是否空地)
70.爬楼梯
1，2，3 F(n) = F(n-1) + F(n-2) + F(n-3)
相邻的两步 不行

暴力求解：递归，n层：left or right ： 2^n
DP
a.重复性（分治） problem(i,j) = min(sub(i+1,j) ,sub(i+1,j+1)) + a[i,j]
b.定义状态数组 f[i,j] 表示i，j这个点走到下面的最小路径是多少
c.DP方程 f[i,j] = min(f[i+1, j], f[i+1,j+1])+a[i,j]

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i = triangle.size() -1;i >= 0;i--){
            for(int j = 0;j < triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    int row;
    public int minimumTotal3(List<List<Integer>> triangle) {
        row = triangle.size();
        return helper(0,0,triangle);

    }

    private int helper(int i, int j, List<List<Integer>> triangle) {
        if (i == row - 1) {
            return triangle.get(i).get(j);
        }
        int left = helper(i + 1, j, triangle);
        int right = helper(i + 1, j +1, triangle);

        return Math.min(left,right) + triangle.get(i).get(j);
    }

最大子序和

1.暴力：n^2

2.DP:
a.分支（子问题）max_sum(i) = Max(max_sum(i-1), 0) + a[i]
b.状态数组定义：f[i]
c.DP方程：f[i] = Max(f[i-1], 0) + a[i]

公式：dp[i] = max(nums[i], nums[i] + dp[i-1])
精髓就是这句话 最大子序和 = 当前元素自身最大，或者 包含之前后最大 也就是上面的公式

最大子序积

def max(self,nums:List[int]) ->int:
    mi = ma = res = nums[0];
    for i in range(1, len(nums)):
        if nums[i] < 0 : mi,ma = ma,mi
        ma = max(ma * nums[i] , nums[i])
        mi = min(mi * nums[i], nums[i])
        res = max(res,ma)
    return res
DP三部曲
a.子问题
b.状态定义
c.DP方程
