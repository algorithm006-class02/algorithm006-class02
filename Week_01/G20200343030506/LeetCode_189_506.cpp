
//解法1：
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(k>=nums.size())
        k%=nums.size();
        if(k!=0)
        {
            vector<int> a(nums.size());
            for(int i=0;i<nums.size();i++)
            {
                a[(i+k)%nums.size()]=nums[i];
            }
            for(int i=0;i<nums.size();i++)
            {
                nums[i]=a[i];
            }
        }
    }
};

//解法2：

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(k>=nums.size())
        k%=nums.size();
        if(k!=0)
        {
            resever(nums,0,nums.size()-k-1);
            resever(nums,nums.size()-k,nums.size()-1);
            resever(nums,0,nums.size()-1);
        }
    }
    void resever(vector<int>& a,int e,int s)
    {
        while(s>e)
        {
            int temp=a[s];
            a[s]=a[e];
            a[e]=temp;
            e++;
            s--;
        }
    }
};

//解法3：

class Solution {
public:
    void swap(vector<int>& a,int i,int j)
    {
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
    }
    void rotate(vector<int>& nums, int k) {
        if(k>=nums.size())
                k%=nums.size();
        if(k!=0)
        {
            int n=nums.size();
            for(int start=0;start<nums.size()&&k!=0;n-=k,start+=k,k%=n)
            {    
                for(int i=0;i<k;i++)
                {
                    swap(nums,start+i,nums.size()-k+i);
                }
            }
        }
    }

};

