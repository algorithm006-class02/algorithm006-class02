=begin
题目描述：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
=end

#解法一、使用位与运算
def hamming_weight(n)
    count = 0
    while n != 0
        n = n & n - 1
        count += 1
    end
    return count
end