给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

```
示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:
```
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array


### 解法

#### 1 种  采用辅助数组
该类问题可以参考约瑟夫环问题，其中原来数组下表里面为i的数据，我们可以放到（i+k）% **数组长度**的位置。为了原地操作，考虑增加一个辅助数组，保存中间操作、

+ 时间复杂度： O(n)O(n) 。将数字放到新的数组中需要一遍遍历，另一边来把新数组的元素拷贝回原数组。
+ 空间复杂度： O(n)O(n)。另一个数组需要原数组长度的空间。



java 代码：
```java
public class Solution{
    public void rotate(int[] nums, int k){
        int[] a = new int[nums.length];
        for (int i =0; i<nums.length;i++){
            a[(i+k)% nums.length ] = nums[i];
        }
        for(int i =0; i<nums.length;i++ ){
            nums[i] = a[i];
        }
    }
}
```

#### 解法2 使用环状替代

假设对于数组中每个元素（`pos_origin`），我们可以一次性的移动到它最后正确(`pos_final`)的位置，那么需要 中间变量`temp`来保存原来位于（`pos_final`）的位置。再将被替换数字 `temp` 移动到正确的位置，并一直操作**数组长度** 次即可。

假设，数组里我们有 nn 个元素并且 kk 是要求移动的次数。更进一步，假设 n%k=0 。第一轮中，所有移动数字的下标 i 满足 i%k==0 。这是因为我们每跳 k步，我们只会到达相距为 k个位置下标的数。每一轮，我们都会移动n/k个元素。下一轮中，我们会移动满足 i%k==1 的位置的数。这样的轮次会一直持续到我们再次遇到 i%k==0 的地方为止，此时 i=k 。此时在正确位置上的数字共有n 个。因此所有数字都在正确位置上。

+ 时间复杂度O（ n ）
+ 空间复杂度O（ 1 ）

```java
public class Solution{
    public void rotate(int[] nums,int k){
        k = k % nums.length;
        int count = 0;
        for（int start = 0; count < nums.length; start++）{
            int current = start;
            int prev = nums[start];
            do{
                int next = (current +k ) % nums.length;// start 移动到当前，保存当前位置
                int temp = nums[next];
                prev = temp;
                current = next;
                count++;
            } while(start != current); // 如果 nums.length % k  = 0; 会执行 nums.length / k 次
        }
    }
}

```

### 解法 3 
这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。

在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k个元素，就能得到想要的结果。

假设 n=7 且 k=3。

```
原始数组                  : 1 2 3 4 5 6 7
反转所有数字后             : 7 6 5 4 3 2 1
反转前 k 个数字后          : 5 6 7 4 3 2 1
反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
```

时间复杂度：O(n) 3次反转
空间复杂度：O（1）

答案：java

```java
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

```



