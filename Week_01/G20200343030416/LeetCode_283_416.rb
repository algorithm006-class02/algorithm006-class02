=begin
  题目描述：
  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
  示例:
  输入: [0,1,0,3,12]
  输出: [1,3,12,0,0]
  说明:
  必须在原数组上操作，不能拷贝额外的数组。
  尽量减少操作次数。
=end

#解法一、使用两个指针，按顺序移动所有非零元素到数组前部，从最后一个非零元素之后到数组末尾的元素设为0
def move_zeroes(nums)
  j = 0
  for i in (0...nums.length)
    if !nums[i].zero?
      nums[j] = nums[i]
      j += 1
    end
  end
  for k in (j...nums.length)
    nums[k] = 0
  end
  return nums
end

#解法二、删除原数组的所有的0，再在数组末尾添加
def move_zeroes1(nums)
  count = 0
  nums.each do |num|
    count += 1 if num.zero?
  end
  nums.delete(0)
  count.times {nums.push(0)}
  return nums
end

#解法三、使用快慢指针，交换数组元素
def move_zeroes2(nums)
  j = 0
  for i in (0...nums.length)
    if !nums[i].zero?
      nums[i],nums[j] = nums[j],nums[i]
      j += 1
    end
  end                                  
  return nums
end