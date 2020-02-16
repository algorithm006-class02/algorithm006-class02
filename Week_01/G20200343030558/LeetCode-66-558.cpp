#include <iostream>

#include <vector>

using namespace std;

vector<int> plusOne(vector<int>& digits) {
    vector<int> res;
    for(int i=digits.size()-1;i>=0;i--){
        if(digits[i]==9){
            digits[i]=0;
        }
        else{
            digits[i]+=1;
            break;
        }
    }
    if(digits[0]==0){
        res.push_back(1);
        for(int j=0;j<digits.size();j++)
        res.push_back(digits[j]);
    }
    else{
        res = digits;
    }
    return res; 
    }