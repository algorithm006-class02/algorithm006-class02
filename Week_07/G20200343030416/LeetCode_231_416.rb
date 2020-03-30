=begin
题目描述：给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
=end

#解法一、使用位与运算
def is_power_of_two(n)
    return n != 0 && n & (n - 1) == 0
end