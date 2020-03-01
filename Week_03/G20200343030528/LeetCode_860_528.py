class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five,ten,twenty = 0,0,0
        for bill in bills:
            if bill == 5:
                five += 1
            elif bill == 10:
                if five == 0:
                    return False
                else:
                    five -= 1
                    ten += 1
            else:
                if five and ten:
                    five -= 1
                    ten -= 1
                    twenty += 1
                elif five >= 3:
                    five -= 3
                    twenty += 1
                else:
                    return False
        return True