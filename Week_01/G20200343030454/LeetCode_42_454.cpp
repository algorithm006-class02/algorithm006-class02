class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size()==0) return 0;
        //每列的水就是左边最高列和右边最高列的小值与该列的差
        int ans=0,n = height.size();
        vector<int> l_max(n),r_max(n);
        l_max[0]=height[0];
        r_max[n-1]=height[n-1];
        //保存左右最高列
        for (int i=1;i<height.size();i++){
            l_max[i]=max(height[i],l_max[i-1]);
        }
        for (int i=n-2;i>=0;i--){
            r_max[i]=max(height[i],r_max[i+1]);
        }
        //求面积和
        for (int i=0;i<n;i++){
            ans += min(l_max[i],r_max[i])-height[i];
        }
        return ans;
    }
};