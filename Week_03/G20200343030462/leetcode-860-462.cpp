class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        //使用贪婪算法求解
        int iFive = 0, iTen = 0;    //5美元面额和10美元面额的数量，一开始我们没有钱，所以初始值是0
        for(auto bill : bills)
        {
            if(5 == bill)
                ++iFive;        //刚好顾客支付的就是5美元，那么现金池中5美元的数目加1
            else if(10 == bill)
            {
                //顾客给的是10美元，这时候要找零5美元
                if(0 >= iFive)
                    return false;
                else
                {
                    --iFive;
                    ++iTen;
                }
            }
            else
            {
                //否则顾客支付的就是20美元，需要找零15美元
                if(iFive > 0 && iTen > 0)
                {
                    --iFive;
                    --iTen;
                }
                else if(iFive >=3 )
                    iFive -= 3;
                else
                    return false;
            }
        }
        return true;
    }
};
