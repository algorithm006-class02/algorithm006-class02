/*
 * @lc app=leetcode.cn id=621 lang=cpp
 *
 * [621] 任务调度器
 *
 * https://leetcode-cn.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (47.50%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    15.5K
 * Total Submissions: 32.3K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26
 * 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU
 * 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 
 * 你需要计算完成所有任务所需要的最短时间。
 * 
 * 示例 1：
 * 
 * 
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 
 * 
 * 注：
 * 
 * 
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * 
 * 
 */

// @lc code=start
class Solution {
public: 
    /*
    解法一：贪心法，找到数量最多的重复的任务，例如A有X个，那么每个A之间最少空出n个位置。加入其他的任务都可以填充到这些空位中，则需要的最少的时间就是 count(A)+空位数量。
    以[A,A,A,B,B]为例：A是数量最多的重复任务，有3个，则摆放A是： A _ _ A _ _ A，中间的空位可以摆放其他任务。空位的位置数= n*(count(A)-1);所以最小的时间个数是
    count(A)+n*(count(A)-1);如果数量最多的任务数出现多个，例如[A,A,A,B,B,B]，有3个A，3个B，则将A，B当作一体处理，变成 AB_AB_AB，需要的空位数计算就是 n*(count(A)-1)-(count(B)-1) ;
    最小时间个数是count(A)+count(B) + n*(count(A)-1) - (count(B)-1) = count(A)+n*(count(A)-1) + 1;
    基本上可以划分3种case：
    a) if num(B) < num(A) && num(B) < gap, 其他任务直接填空.
    AB___AB___AB____A____A____A
    b) if num(B) == num(A) && num(B) < gap, 减少 num(B) - 1个空位, 总的空位数增加1个.
    AB___AB___AB___AB___AB___AB
    c) 空位数不够意味着完全不需要空位，类似于
    ABCDABCDABCDABCDABCD
    总结：空位数 = (count(最多重复任务个数)-1) * (n - (最多重复任务个数 - 1))
    40ms 97.49%
    */
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> counter(26,0);
        int maxc = 0;
        int maxCount = 0;
        for(auto task : tasks) {
            counter[task - 'A']++;
            if(maxc == counter[task - 'A']) {
                maxCount++;
            }
            else if(maxc < counter[task - 'A']) {
                maxc = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
        int partCount = maxc - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.size() - maxc * maxCount;
        int idles = max(0, emptySlots - availableTasks);
        
        return tasks.size() + idles;
    }

    /*
    社区高赞解法
    */
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char,int>mp;
        int count = 0;
        for(auto e : tasks)
        {
            mp[e]++;
            count = max(count, mp[e]);
        }
        
        //count=重复任务个数最多的个数
        //ans得到空位数，
        int ans = (count-1)*(n+1);
        
        for(auto e : mp) if(e.second == count) ans++;
        return max((int)tasks.size(), ans);
    }

   

};
// @lc code=end

