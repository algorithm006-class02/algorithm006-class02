class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        change_left = {5:0,10:0}
        for bill in bills:
            if bill == 5:
                change_left[5]+=1
            elif bill == 10:
                if change_left[5] >= 1:
                    change_left[5]-=1
                    change_left[10]+=1
                else:
                    return False
            elif bill == 20:
                if change_left[10] >= 1 and change_left[5] >= 1:
                    change_left[10]-=1
                    change_left[5]-=1
                elif change_left[5] >= 3:
                    change_left[5] -= 3
                else:
                    return False
        return True

作者：koukou-28
链接：https://leetcode-cn.com/problems/lemonade-change/solution/zhao-ling-de-shi-hou-xian-ba-10yong-diao-by-koukou/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。