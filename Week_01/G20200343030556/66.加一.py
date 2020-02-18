class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        # 法一： 列表 ——> 字符串 --> int -> 字符串
        # num_str = ""
        # for i in range(len(digits)):
        #     num_str += str(digits[i])
        # num_str = int(num_str) + 1
        # num_str = str(num_str)
        # return num_str # 字符串与列表都是序列


        # 法二：模拟手工计算（剪枝）
        tmp = 1
        size = len(digits)
        for i in range(size):
            if tmp == 0:
                break
            if i == 0 and digits[i] + 1 == 0:
                tmp = digits[i] = 0
                digits = [1] + digits
                continue
            cnt = digits[i] + 1
            tmp = cnt // 10
            digits[i] = cnt % 10
        return digits