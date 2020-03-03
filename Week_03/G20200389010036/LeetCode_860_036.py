# class Solution:
#     def lemonadeChange(self, bills: List[int]) -> bool:
#         five = ten = 0
#         for bill in bills:
#             if bill == 5:
#                 five += 1
#             if bill == 10:
#                 if not five:
#                     return False
#                 five -= 1
#                 ten += 1
#             if bill == 20:
#                 if five and ten:
#                     five -= 1
#                     ten -= 1
#                 elif five >= 3:
#                     five -= 3
#                 else:
#                     return False
#         return True 
class Solution:
    def lemonadeChange(self, bills):
        five = ten = 0
        for num in bills:
            if num == 5:
                five += 1
            elif num == 10 and five:
                ten += 1
                five -= 1
            elif num == 20 and five and ten:
                five -= 1
                ten -= 1
            elif num == 20 and five >= 3:
                five -= 3
            else:
                return False
        return True