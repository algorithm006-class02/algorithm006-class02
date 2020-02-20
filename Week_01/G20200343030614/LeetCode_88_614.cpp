//用nums1创建一个临时数组，和nums2一个个元素比较，有序插入到nums1
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i=0,j=0,k=0;
        vector<int> tmp(nums1.begin(),nums1.begin()+m);
        while (i<m&&j<n) {
            nums1[k++] = tmp[i]<nums2[j] ? tmp[i++] : nums2[j++];
        }
        while (i<m) {
            nums1[k++] = tmp[i];
            i++;
        }
        while (j<n) {
            nums1[k++] = nums2[j];
            j++;
        }
    }
};

//把num2的元素补到num1后面，再全数组sort一下
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        nums1.resize(m);
        for (int i=0; i<nums2.size(); i++) {
            nums1.push_back(nums2[i]);
        }
        sort(nums1.begin(),nums1.end());
    }
};