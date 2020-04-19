class Solution {
public:
    //爬楼梯问题的变形，给每一级台阶加上了权重
    int minCostClimbingStairs(vector<int>& cost) {
        long long f1 = 0;   //上一级台阶时的花费
        long long f2 = 0;   //上两级台阶的花费
        
        for(int i = cost.size() - 1; i >= 0; --i)
        {
            long long tmp = cost[i] + min(f1,f2);
            f1 = f2;
            f2 = tmp;
        }
        
        return min(f1,f2);
    }
};
