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