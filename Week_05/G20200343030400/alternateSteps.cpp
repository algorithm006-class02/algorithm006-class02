#include <iostream>
#include <vector>
using namespace std;

int alternateSteps(const int& n, const int& maxStep) {
    vector<vector<int>> dp(maxStep + 1, vector<int>(max(n, maxStep) + 1, 0));
    
    for (int step = 1; step <= maxStep; step++) {
        for (int i = 1; i < step; i++) {
            dp[i][step] = dp[0][step - i] - dp[i][step - i];
            dp[0][step] += dp[i][step];
        }
        dp[step][step] = 1;
        dp[0][step]++;
    }

    for (int step = maxStep + 1; step <= n; step++) {
        for (int i = 1; i <= maxStep; i++) {
            dp[i][step] = dp[0][step - i] - dp[i][step - i];
            dp[0][step] += dp[i][step];
        }
    }

    return dp[0][n];
}

int main()
{
    int maxStep = 3;
    int n = 6;
	for (int stairs = 0; stairs <= n; stairs++) {
        cout << "n = " << stairs << "  f_n = " << alternateSteps(stairs, maxStep) << endl;
    }
	
	return 0;
}
