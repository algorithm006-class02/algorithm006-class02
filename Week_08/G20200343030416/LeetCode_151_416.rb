=begin
题目描述：给定一个字符串，逐个翻转字符串中的每个单词。
=end

#解法一、先将字符串反转，对反转后的字符串分割为数组，对数组中的每个元素再次反转后，最后将整个数组合并为字符串
def reverse_words(s)
    str = s.reverse
    arr = str.split
    for substr in arr
        substr.reverse!
    end
    return arr.join(" ")
end

#解法二、将字符串分割成数组，反转数组元素，最终再合并为字符串
def reverse_words(s)
    arr = s.split
    i, j = 0, arr.length - 1
    while i < j
        arr[i], arr[j] = arr[j], arr[i] #交换数组元素
        i += 1
        j -= 1
    end
    return arr.join(" ")
end