public class LeetCode_1122_600 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //桶排序，按桶的下标对arr1中元素进行计数；最终数组复用arr1(因长度不变)
        int[] bucket = new int[1001];
        for(int num : arr1) {
            bucket[num]++;
        }
        int i = 0;
        for(int num : arr2) {
            while(bucket[num]-- > 0) {
                arr1[i++] = num;
            }
        }
        for(int j = 0; j < 1001; j++) {
            while(bucket[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }
}
