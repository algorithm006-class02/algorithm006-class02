=begin
  题目描述：给定一个可包含重复数字的序列，返回所有不重复的全排列
  输入：[1,1,2]
  输出：
  [
    [1,1,2],
    [1,2,1],
    [2,1,1]
   ]
=end

#解法一、使用回溯法 + 状态重置 + 剪枝
def permute_unique(nums)
  size = nums.length
  return [] if size == 0
  used = Array.new(size, false)
  arr = []
  nums.sort!
  #这里传递了arr数组作为参数，由于数组是引用类型，因此最终arr经过处理后会发生改变
  dfs(nums, size, 0, [], used, arr)
  #获得arr的最终值
  return arr
end

def dfs(nums, size, depth, path, used, arr)
  if depth == size
  #遍历前先拷贝一次path数组中的遍历路径的数据，因为回溯后path中的数据会被重置，path被重置后，原本的arr的值也会跟着变化。因此我们需要拷贝一个path的副本
    arr.push(path.dup)
    return
  end
  for i in 0...size
    if !used[i]
      #遇到重复元素，进行剪枝
      if i > 0 && nums[i] == nums[i - 1] && !used[i - 1]
        next 
      end
      used[i] = true
      path.push(nums[i])
      #往下一层遍历
      dfs(nums, size, depth + 1, path, used, arr)
      #遍历后回溯
      used[i] = false
      path.pop
    end
  end
end
