public class LeetCode_493_600 {
    public int reversePairs(int[] nums) {
        //归并排序，数组起点，终点;
        if(nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int l, int r) {
        if(l >= r) return 0;
        int mid = l + (r - l) / 2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        int[] temp = new int[r - l + 1];
        int i = l, k = l, t = 0;
        for(int j = mid + 1; j <= r; j++, t++) {
            while(i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while(k <= mid && nums[k] < nums[j]) temp[t++] = nums[k++];
            temp[t] = nums[j];
            count += mid - i + 1;
        }
        while(k <= mid) temp[t++] = nums[k++];
        System.arraycopy(temp, 0, nums, l, r - l + 1);
        return count;
    }
}
