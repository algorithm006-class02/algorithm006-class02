#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        if(arr1.size()==0 || arr1.size()< arr2.size())
            return {};
        if(arr2.size() == 0)
            return arr1;
        int tmp = 0;
        for(int i=0;i<arr2.size();i++){
            for(int j=0;j<arr1.size();j++){
                if(arr1[j] == arr2[i]){
                    swap(arr1[j],arr1[tmp]);
                    tmp++;
                }
            }
            
        }
        sort(arr1.begin()+tmp,arr1.end());
        return arr1;
        
    }