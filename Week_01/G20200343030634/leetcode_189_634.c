void rotate(int* nums, int numsSize, int k){
    int * temp=(int*)malloc(sizeof(int)*numsSize);
    for(int i = 0;i<numsSize;i++)
    {
        temp[(i+k)%numsSize]= nums[i];
    }
    memcpy(nums,temp,sizeof(int)*(numsSize));
    free(temp);
    return;
}