class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        """
        # 思路1: 使用一个dict 存储钱，从前往后遍历，时间复杂度为O(n)-----代码写得太丑了
        from collections import defaultdict
        money={5:0,10:0,20:0}
        is_back=True 
        for i,val in enumerate(bills):
            # 大于5需要进行找零钱来补
            if val>5:
                if val==10 and money[5]>0:
                    money[5]-=1
                elif val==20 :
                    if money[10]>0 and money[5]>0:
                        money[10]-=1
                        money[5]-=1
                    elif money[10]==0 and money[5]>=3:
                        money[5]-=3
                    else:
                        is_back=False 
                else:
                    is_back=False
            money[val]+=1
            if not is_back:
                break
        return is_back
        """
        # 贪心算法中状态记录
        five=ten=0
        for val in bills:
            if val==5:five+=1
            elif val==10:five-=1;ten+=1
            else:
                if ten>0: ten-=1;five-=1
                else: five-=3
            if five<0:
                return False
        return True