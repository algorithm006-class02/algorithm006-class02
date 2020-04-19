class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int len1 = arr1.size();
        int len2 = arr2.size();
        int idx = 0;
        for (int j = 0; j < len2; ++j) {
            for (int i = 0; i < len1; ++i) {
                if (arr1[i] == arr2[j]) {
                    swap(arr1[i], arr1[idx++]);
                }
            }
        }
        sort(arr1.begin() + idx, arr1.end());
        return arr1;
    }
};
