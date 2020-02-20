public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = -1;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int sum = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, sum);
            if (height[left] <= height[right]) {
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}