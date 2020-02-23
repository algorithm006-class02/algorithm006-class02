package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/2/12
 */
public class Rotate_array_189 {

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if (k < 0 || l == 1 || l == k) {
            return;
        }
        int[] targetArr = new int[l];
        if (l < k) {
            k = k % l;
        }
        System.arraycopy(nums, l - k, targetArr, 0, k);
        System.arraycopy(nums, 0, targetArr, k, l - k);
        for (int i = 0; i < targetArr.length; i++) {
            nums[i] = targetArr[i];
        }
    }
}
