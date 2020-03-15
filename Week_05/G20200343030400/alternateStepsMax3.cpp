#include <iostream>
#include <vector>
using namespace std;

int alternateStepsMax3(const int& n) {
    vector<vector<int>> dp(4, vector<int>(max(n, 3) + 1, 0));
    
    for (int i = 1; i <= 3; i++) {
        dp[i][i] = 1;
        dp[i][3] = 1;
        for (int j  = 1; j <= 3; j++) {
            dp[0][i] += dp[j][i];
        }
    }

    for (int step = 4; step <= max(n, 3); step++) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][step] += dp[j][step - i];
            }
            dp[i][step] -= dp[i][step - i];
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
