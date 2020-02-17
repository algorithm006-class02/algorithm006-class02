class Solution:
    def trap(self, height: List[int]) -> int:
        """
        # 思路1 使用栈进行求解
        stack=[]
        n=len(height)
        sums=0
        for  i in range(n):
            while stack and height[i]>height[stack[-1]]:
                top=stack.pop()
                if stack :
                    distance=i-stack[-1]-1
                    bandance=min(height[i],height[stack[-1]])-height[top]
                    sums+=distance*bandance
            stack.append(i)
        return sums
        """
        # 思路2：使用双指针夹逼法进行求解
        l=0
        r=len(height)-1
        left_amx=right_max=0
        sums=0
        while l<r:
            if height[l]<=height[r]:
                if left_amx<height[l]:
                    left_amx=height[l]
                else:
                    sums+=left_amx-height[l]
                l+=1
            else:
                if right_max<height[r]:
                    right_max=height[r]
                else:
                    sums+=right_max-height[r]
                    r-=1
        return sums