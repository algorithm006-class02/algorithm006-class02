class Solution:
    def merge(self, seq: List[List[int]]) -> List[List[int]]:
        seq = sorted(seq) # 区间从小到大排序，若左边界相等，则对右边界排序；
        i = 1 # 初始位置从第二个区间开始
        while i < len(seq):
            if seq[i][0] >= seq[i-1][0] and seq[i][0] <= seq[i-1][1]:
                if seq[i][1] <= seq[i-1][1]:
                    seq.remove(seq[i])
                else:
                    seq[i-1] = [seq[i-1][0], seq[i][1]]
                    seq.remove(seq[i])
            else:
                i += 1
        return seq

