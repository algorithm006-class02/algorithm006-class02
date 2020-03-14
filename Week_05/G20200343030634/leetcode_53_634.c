
#define MAX(a,b) (a>b?a:b)

int maxSubArray(int* nums, int numsSize){
    if(numsSize==0)
    {
        return 0;
    }else if(numsSize==1)
    {
        return nums[0];
    }
    int temp=nums[numsSize-1];
    for (int i = numsSize-2; i>=0; i--) {
        nums[i]=MAX(nums[i],nums[i]+nums[i+1]);
        temp=MAX(nums[i],temp);

    }
    return  temp;
}