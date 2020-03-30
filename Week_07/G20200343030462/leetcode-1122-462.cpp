class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int tmp = 0;    //记录arr2的元素可以在arr1中插入的位置
        for(int i = 0; i < arr2.size(); ++i)	//注意arr2要在外层循环，以免arr2为空的时候出现错误解
            for(int j = 0; j < arr1.size(); ++j)
                if(arr2[i] == arr1[j])
                {
                    swap(arr1[j],arr1[tmp]);
                    ++tmp;
                }
        sort(arr1.begin() + tmp,arr1.end());
        return arr1;
    }
};
