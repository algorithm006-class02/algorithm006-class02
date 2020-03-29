class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # 1.区间中第一个元素是否已经排好顺序
        # 思路1: a.先根据区间的第一个元素进行排序 b.进行区间遍历 如果第一个区间的第二个元素小于 第二个区间的第一个元素则直接将该区间存入结果，如果第一个区间的第二个元素大于第二个区间的第一元素，且小于第二个区间的第二个元素则进行合并
        sort_intervals=sorted(intervals,key=lambda x:x[0])
        res=[]
        i=0
        while i<len(sort_intervals):
            start=sort_intervals[i][0]
            end=sort_intervals[i][1]
            i+=1
            while i<len(sort_intervals) and end >= sort_intervals[i][0]:
                if end< sort_intervals[i][1]:
                    end=sort_intervals[i][1]
                i+=1
            res.append([start,end])
        return res 