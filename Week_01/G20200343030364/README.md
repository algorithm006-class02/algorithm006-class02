# 学习笔记

## Array

[LeetCode-0011](https://leetcode-cn.com/problems/container-with-most-water/)

Solution 1: brute force, time complexity: O(N^2)

```java
class Solution {
    public int maxArea(int[] height) {
      int max = 0;
      for (int i=0; i<height.length-1; i++) {
        for (int j=1; j<height.length; j++) {
          int area = Math.min(height[i], height[j]) * (j-i);
          max = Math.max(area, max);
        }
      } 
      return max;
    }
}
```

Solution 2: tow pointers, time complexity O(N)

```java
class Solution {
    public int maxArea(int[] height) {
      int max = 0;
      for (int i=0, j=height.length-1; i<j;){
        int area = Math.min(height[i], height[j]) * (j-i);
        max = Math.max(area, max);
        if (height[i] > height[j])
          j--;
        else
          i++;
      }
      return max;    
    }
}
```

Solution 2: improve

![2020-02-13_001.jpg](https://gitee.com/gdhu/testtingop/raw/master/2020-02-13_001.jpg)

```java
class Solution {
    public int maxArea(int[] height) {
      int max = 0;
      for (int i=0, j=height.length-1; i<j;){
        int minHeight = height[i] < height[j] ? height[i++]:height[j--];
        int area = minHeight * (j-i+1);
        max = Math.max(area, max);
      }
      return max;    
    }
}
```

[LeetCode-11](LeetCode_11_364.java)

