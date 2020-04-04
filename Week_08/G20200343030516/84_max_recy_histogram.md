84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

 



以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

 



图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。


### solution
```java
public class Solution{
    public int largestRectangleArea(int[] heights) {
       Stack <Integer> stack = new Stack <> ();
       stack.push(-1);
       int maxarea = 0;
       for(int i = 0; i <heights.length,++i){
           while(stack.peek()!=-1 && heights[stack.peek()]>heights[i]){
               maxarea = Math.max(maxarea,heights[stack.pop()]*(i-stack.peek() -1)) ;
           }
           stack.push(i);
         while(stack.peek()!-1)
                maxarea = Math.max(maxarea,heights[stack.pop()]*(heights.length -stack.peek() -1))
        return maxarea;

       }
    }
}
```