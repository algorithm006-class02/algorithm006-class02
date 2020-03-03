#### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
````
public class Solution {

    public int unSortIndex(int[] data) {
        int left = 0, right = data.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (data[mid] >= data[left] && data[mid] > data[right]) {
                left = mid;
            } else  {
                right = mid;
            }
        }
        return right;
    }

}
````

##### 思路

左指针寻找数组数组中最大的值，右指针指向数组中最小的值。   
如果mid大于等于左指针且大于右指针，则将左指针移到mid，否则将右指针移到mid。   
逐步收敛，直到左右指针相邻，且左指针在右指针的左边。
