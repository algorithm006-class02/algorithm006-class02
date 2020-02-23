//    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//    示例:
//
//    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]
//    说明:
//
//    必须在原数组上操作，不能拷贝额外的数组。
//    尽量减少操作次数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/move-zeroes
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution283 {
    public void moveZeroes(int[] nums) {

        // 第一遍遍历，得到 0 的个数
        int count_0 = countZeros(nums);
        // 第二遍遍历，删掉所有 0 元素
        removeZeros(nums);
        // 在末尾补全 0
        completeZeros(nums, count_0);
        
    }

    private void completeZeros(int[] nums, int count) {
        for (int i = nums.length - 1; i >= nums.length - count ; i--) {
            nums[i] = 0;
        }
    }

    private void removeZeros(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[j++] = nums[i];
            }
        }
    }

    private int countZeros(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] num = new int[]{0,0,1};//{0, 1, 0, 3, 12, 0, 18, 0};

        Solution283 sln = new Solution283();

        sln.moveZeroes(num);

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }

    }

}