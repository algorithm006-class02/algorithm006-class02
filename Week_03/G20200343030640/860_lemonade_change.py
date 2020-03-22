class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        # 贪心算法，每次使用最大面额找回
        change = {'5':0, '10':0, '20':0}
        for bill in bills:
            if bill == 5:
                change['5'] += 1
            elif bill == 10:
                # 找回一张5
                if change['5'] == 0:
                    return False
                change['5'] -= 1
                change['10'] += 1
            else:
                if change['10'] and change['5']:
                    change['10'] -= 1
                    change['5'] -= 1
                elif change['10'] == 0 and change['5'] >= 3:
                    change['5'] -= 3
                else:
                    return False
                
                change['20'] += 1
        return True

