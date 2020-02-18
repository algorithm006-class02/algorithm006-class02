# Given a sorted array nums, remove the duplicates in-place such that each eleme
# nt appear only once and return the new length. 
# 
#  Do not allocate extra space for another array, you must do this by modifying 
# the input array in-place with O(1) extra memory. 
# 
#  Example 1: 
# 
#  
# Given nums = [1,1,2],
# 
# Your function should return length = 2, with the first two elements of nums be
# ing 1 and 2 respectively.
# 
# It doesn't matter what you leave beyond the returned length. 
# 
#  Example 2: 
# 
#  
# Given nums = [0,0,1,1,1,2,2,3,3,4],
# 
# Your function should return length = 5, with the first five elements of nums b
# eing modified to 0, 1, 2, 3, and 4 respectively.
# 
# It doesn't matter what values are set beyond the returned length.
#  
# 
#  Clarification: 
# 
#  Confused why the returned value is an integer but your answer is an array? 
# 
#  Note that the input array is passed in by reference, which means modification
#  to the input array will be known to the caller as well. 
# 
#  Internally you can think of this: 
# 
#  
# // nums is passed in by reference. (i.e., without making a copy)
# int len = removeDuplicates(nums);
# 
# // any modification to nums in your function would be known by the caller.
# // using the length returned by your function, it prints the first len element
# s.
# for (int i = 0; i < len; i++) {
#     print(nums[i]);
# } Related Topics Array Two Pointers


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] == nums[i - 1]:
                nums.pop(i)
                i += 1
        return len(nums)

    # 一开始就想第一个和第二个去比，如果相同就删掉第一个，再接着遍历，但接下来发现由于删了元素
    # index也变了，最后就超出长度了，看了一位大佬的说反向遍历就没问题，因此修改了下按照此方法得出。确实最后不用担心index的问题，因为虽然长度发生了变化，但是遍历以及操作index不会受到长度的影响。

    # 一开始就想第一个和第二个去比，如果相同就删掉第一个，再接着遍历，但接下来发现由于删了元素
    # index也变了，最后就超出长度了，看了一位大佬的说反向遍历就没问题，因此修改了下按照此方法得出。确实最后不用担心index的问题，因为虽然长度发生了变化，但是遍历以及操作index不会受到长度的影响。

# leetcode submit region end(Prohibit modification and deletion)
