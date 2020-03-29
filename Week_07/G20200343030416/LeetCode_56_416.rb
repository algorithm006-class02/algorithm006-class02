=begin
题目描述：给出一个区间的集合，请合并所有重叠的区间。
=end

#解法一、使用排序法
def merge(intervals)
    #将原有区间数组中的区间按照左端点从小到大排序
    intervals.sort!
    #创建一个数组用于保存合并后的区间
    merged = []
    for interval in intervals
    #如果merged区间数组为空，或者merged区间数组不为空时，前一个区间的右端点小于当前区间的左端点，说明不能合并，直接将区间存储数组
        if merged.empty? || merged[-1].last < interval.first
            merged.push(interval)
        else
   #否则，说明可以合并，此时将merged数组中前一个区间的右端点和当前遍历的区间interval中的右端点进行比较，取较大者作为合并区间后的右端点
            merged[-1][-1] = [merged[-1].last, interval.last].max
        end
    end
    return merged
end