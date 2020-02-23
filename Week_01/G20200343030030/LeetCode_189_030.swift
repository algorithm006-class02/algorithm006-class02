/*
 * @lc app=leetcode.cn id=189 lang=swift
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        if nums.count <= 0 { return }
        let k = k % nums.count

        reverse(&nums, 0, nums.count-1)
        reverse(&nums, 0, k-1)
        reverse(&nums, k, nums.count-1)
    }
    func reverse(_ nums: inout [Int], _ s: Int, _ e: Int) {
        var s = s; var e = e
        while s < e {
            nums.swapAt(s, e)
            s += 1
            e -= 1
        }
    }
}
// @lc code=end

