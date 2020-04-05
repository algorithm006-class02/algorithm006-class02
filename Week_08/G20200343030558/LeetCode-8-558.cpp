#include <iostream>
#include <string>

using namespace std;
int myAtoi(string str) {
        if(str.length() == 0)
            return 0;
        int start = 0;
        while(str[start]==' ')start++;
        if(str[start] !='-'&& str[start] !='+' && (str[start] >'9' ||str[start] <'0'))
            return 0;
        long long res = 0;
        int flag = 1;
        if(str[start] == '-'){
            flag = -1;
            start++;
        }
        else if(str[start] == '+'){
            start++;
        }
        while(start<str.length()){
            if(str[start]>='0' && str[start]<='9'){
                res = res*10 + str[start] - '0';
                start++;
            }
            else{
                    break;
            }
            //注意溢出，开始没注意到
            if(flag * res >INT_MAX){
                return INT_MAX;
            }
            else if(flag * res < INT_MIN){
                return INT_MIN;
            }
        }
        return flag * res;
        
    }