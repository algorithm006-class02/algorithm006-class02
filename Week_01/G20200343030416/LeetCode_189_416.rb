=begin
  题目描述：
  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

  示例 1:
  输入: [1,2,3,4,5,6,7] 和 k = 3
  输出: [5,6,7,1,2,3,4]
  解释:
  向右旋转 1 步: [7,1,2,3,4,5,6]
  向右旋转 2 步: [6,7,1,2,3,4,5]
  向右旋转 3 步: [5,6,7,1,2,3,4]
=end

# 解法一、将数组末尾元素依次取出，再插入到数组头部
def rotate(nums, k)
  k = k % nums.length
  k.times do
    nums.unshift(nums.pop)
  end
  return nums
end

# 解法二、暴力求解，每次旋转一个元素，共旋转k次

def rotate1(nums, k)
  k = k % nums.length
  for i in 0...k
    #获取数组中的末尾元素
    p = nums[-1]
    for j in 0...nums.length
      p, nums[j] = nums[j], p
    end
  end
  return nums
end

# 解法三、开辟新数组
def rotate2(nums, k)
  arr = []
  for i in 0...nums.length
    arr[(i + k) % nums.length] = nums[i]
  end
  for j in 0...nums.length
    nums[j] = arr[j]
  end
  return nums
end

# 解法四、反转三次元素
def rotate3(nums, k)
  k = k % nums.length
  reverse_num(nums, 0, nums.length - 1)
  reverse_num(nums, 0, k - 1)
  reverse_num(nums, k, nums.length - 1)
  return nums
end

def reverse_num(nums, i, j)
  while i < j
    nums[i],nums[j] = nums[j],nums[i]
    i += 1
    j -= 1
  end
end