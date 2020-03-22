#include <vector>
#include <string>

using namespace std;




int numDecodings(string s) {
        if(s.size()==0 || s[0] == '0')
            return 0;
        if(s.size() == 1)
            return 1;
        vector<int> dp(s.size()+1,0);
        dp[0] = dp[1] = 1;
        for(int i=1;i<s.size();i++){
            if(s[i] == '0' ){
                if((s[i-1] == '1'||s[i-1] == '2')){
                        dp[i+1] = dp[i-1];
                }
            }
            else{
                if(s[i-1] == '1' ||(s[i-1] == '2' && s[i] <='6'))
                    dp[i+1] = dp[i-1]+dp[i];
                else
                    dp[i+1]=dp[i];
            }
              
        }
        return dp[s.size()];
        
    }