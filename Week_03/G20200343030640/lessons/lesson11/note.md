## Week03-lession11 二分查找

### 二分查找通用模板

```json
int binarySearch(int[] nums, int target) {
    int left = 0, right = ...;
    while(...) {
        # 防止 left 和 right 太大直接相加导致溢出
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            ...
        } else if (nums[mid] < target) {
            left = ...
        } else if (nums[mid] > target) {
            right = ...
        }
    }
    return ...;
}
```
