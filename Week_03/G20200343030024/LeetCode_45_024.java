
// 贪心算法，每次算最大的部署
class Solution {
    int jump(int[] nums){
        int ans = 0;
        int begin = 0;
        int end = 1;
    
        while (end < nums.length){
            int temp = 0;
            for (int i = begin; i < end; i++){
                temp = Math.max(temp, i + nums[i]);
            }
            begin = end;
            end = temp + 1;
            ans++;
        }
            return ans;
        }
    }