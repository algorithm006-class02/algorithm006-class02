class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) { // starting from the end.
        // set from end, if nums1 all larger than nums2, which means all the remain spot can filled by nums2
        //if only some of nums1 larger than nums2, which means spot of those smaller one from nums1 can be used after filling
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while(i >=0 && j>=0)
        {
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while(j>=0) // another while not if
            nums1[k--] = nums2[j--];
    }
}