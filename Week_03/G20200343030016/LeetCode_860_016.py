# =====================================
# No.860 柠檬水找零
# 解题思路：贪心算法
# 现金的面额为5、10、20，共有以下几种场景：
# 如果顾客付5元，将5元存为零钱；
# 如果顾客付10元，要有5元找零，并将5元存为零钱；
# 如果顾客付20元，优先选择10+5找零，如果没有选择5+5+5找零；
# =====================================

class Solution(object):
    def lemonadeChange(self, bills):
        five = 0
        ten = 0
        for bill in bills:
            if (bill == 5):
                five = five + 1
            if (bill == 10):
                if five == 0:
                    return False
                else:
                    five = five - 1
                    ten = ten + 1
            if (bill == 20):
                if(five > 0 and ten > 0):
                    five = five - 1
                    ten = ten - 1
                elif (five >= 3):
                    five = five - 3
                else:
                    return False
        return True


if __name__ == '__main__':
    solution = Solution()
    test_1 = [5, 5, 5, 10, 20]
    test_2 = [5, 5, 10, 10, 20]
    test_3 = [10, 10, 20]
    print(solution.lemonadeChange(test_1))
    print(solution.lemonadeChange(test_2))
    print(solution.lemonadeChange(test_3))
