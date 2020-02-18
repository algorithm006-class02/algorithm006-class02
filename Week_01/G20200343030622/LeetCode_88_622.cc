class Solution
{
public:
    void merge(vector<int> &nums1, int m, vector<int> &nums2, int n)
    {
        int idx_result = nums1.size() - 1;
        int idx_nums1 = m - 1;
        int idx_nums2 = n - 1;

        while (idx_nums1 >= 0 && idx_nums2 >= 0)
        {
            if (nums1[idx_nums1] > nums2[idx_nums2])
            {
                nums1[idx_result--] = nums1[idx_nums1--];
            }
            else
            {
                nums1[idx_result--] = nums2[idx_nums2--];
            }
        }

        while (idx_nums1 >= 0)
        {
            nums1[idx_result--] = nums1[idx_nums1--];
        }

        while (idx_nums2 >= 0)
        {
            nums1[idx_result--] = nums2[idx_nums2--];
        }
    }
};