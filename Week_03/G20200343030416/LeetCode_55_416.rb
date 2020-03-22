=begin
  给定一个非负整数数组，你最初位于数组的第一个位置。
  数组中的每个元素代表你在该位置可以跳跃的最大长度。
  判断你是否能够到达最后一个位置。
=end

#解法一、使用贪心算法
#将数组元素从后往前遍历
def can_jump(nums)
  enable = nums.length - 1
  for i in (nums.length - 1).downto(0)
    enable = i if nums[i] + i >= enable
    p enable
  end
  return enable == 0
end

#解法二、使用回溯法
def can_jump(nums)
  jump_from_position(0, nums)
end

def jump_from_position(position, nums)
  return true if position == nums.length - 1
  #计算每个位置可移动的最大位置，最大位置设定为数组最后一个元素的下标，避免接下来的循环越界
  max_jump = [position + nums[position], nums.length - 1].min
  next_position = position + 1
  while next_position <= max_jump
    return true if jump_from_position(next_position, nums)
    next_position += 1
  end
  return false
end