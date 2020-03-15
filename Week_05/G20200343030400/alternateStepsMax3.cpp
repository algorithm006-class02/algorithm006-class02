#include <iostream>
#include <vector>
using namespace std;

int alternateStepsMax3(const int& n) {
    vector<vector<int>> dp(4, vector<int>(max(n, 3) + 1, 0));

	/* 初始条件设定
	       总步数        n  1 2 3 
	       总走法数     dp[0] 1 1 3 
	 先上1个台阶的走法数 dp[1] 1 0 1 
	 先上2个台阶的走法数 dp[2] 0 1 1 
	 先上3个台阶的走法数 dp[3] 0 0 1
	*/
	
    for (int i = 1; i <= 3; i++) {
        dp[i][i] = 1;
        dp[i][3] = 1;
        for (int j  = 1; j <= 3; j++) {
            dp[0][i] += dp[j][i];
        }
    }
	
	/*
	用二维数组dp[boundary_step][distance]来表示第一步（或者是最后一步）上boundary_step个台阶，且总共走了distance个台阶的距离的走法数。
	这样递推关系由一个等式就升级为一组等式： 
	dp[1][n] = dp[2][n-1] + dp[3][n-1] // 先上1个台阶，剩下的n-1个台阶可以先上2个或3个台阶。 
	dp[2][n] = dp[1][n-2] + dp[3][n-2] // 先上2个台阶，剩下的n-2个台阶可以先上1个或3个台阶。 
	dp[3][n] = dp[1][n-3] + dp[2][n-3] // 先上3个台阶，剩下的n-3个台阶可以先上1个或2个台阶。 
	总走法数就是dp[1][n] + dp[2][n] + dp[3][n]。
	*/

    for (int step = 4; step <= n; step++) {
        for (int i = 1; i <= 3; i++) {
            dp[i][step] = dp[0][step - i] - dp[i][step - i];
            dp[0][step] += dp[i][step];
        }
    }
	
    return dp[0][n];
}

int main()
{
    int n = 10;
	for (int stairs = 0; stairs <= n; stairs++) {
        cout << "n = " << stairs << ";  f_n = " << alternateStepsMax3(stairs) << endl;
    }
	
	return 0;
}
