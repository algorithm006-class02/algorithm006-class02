void reverse(int * nums, int start_pos, int end_pos)
{
    while (start_pos < end_pos)
    {
        int tmp = *(nums+end_pos);
        *(nums+end_pos) = *(nums+start_pos);
        *(nums+start_pos) = tmp;
        start_pos++;
        end_pos--;
    }
}

void rotate(int* nums, int numsSize, int k){
    k = k%numsSize;
    reverse(nums, 0, numsSize-1);
    reverse(nums,k,numsSize-1);
    reverse(nums,0,k-1);
}
