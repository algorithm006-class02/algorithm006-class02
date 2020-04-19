=begin
题目描述：给定一个无序的整数数组，找到其中最长上升子序列的长度。
=end

#解法一、动态规划
def length_of_lis(nums)
    return 0 if nums.empty? || nums.nil?
    len = nums.length
    dp = Array.new(len) {1}
    res = 0
    for i in 0...len
        for j in 0...i
            dp[i] = [dp[i], dp[j] + 1].max if nums[j] < nums[i]
        end
        res = [res, dp[i]].max
    end
    return res
end