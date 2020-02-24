typedef struct retTag
{
    int** ret;
    int len;
    int max;
}retType;
void initList(retType *retInfo)
{
    retInfo->ret = (int**)malloc(sizeof(int*)*100);
    retInfo->len = 0;
    retInfo->max=100;
}
void pushLust(retType *retInfo,int* x)
{

    if(retInfo->len>=retInfo->max)
    {
        int** temp = retInfo->ret;
        retInfo->ret = (int**)malloc(sizeof(int*)*(retInfo->max+100));
        for (int i =0; i<retInfo->max; i++) {
            retInfo->ret[i]= temp[i];
        }
        retInfo->max+=100;
        free(temp);
    }
    retInfo->ret[retInfo->len]=x;
    retInfo->len++;
    printf("size %d \n",retInfo->len);
    return;
}
void swip(int i,int j,int* nums, int numsSize)
{
    if((i>=numsSize)||(j>=numsSize))
    {

        return;
    }
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
    return;
}

void Dfs(int level,int first,int* nums, int numsSize,retType *retInfo)
{
    if (level>=(numsSize-1)) {
        int *temp=(int*)malloc(sizeof(int)*numsSize);
        for (int i=0; i<numsSize; i++) {
            temp[i]=nums[i];
         //   printf("%d ",temp[i]);
            
        }
        pushLust(retInfo, temp);
       // printf("\n");
        return;
    }
    for(int i = first;i<numsSize;i++)
    {
        swip(level,i,nums,numsSize);
        Dfs(level+1,level+1,nums,numsSize,retInfo);
        swip(i,level,nums,numsSize);
    }
    return;
}

int** permute(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
    retType retInfo = {0};
    initList(&retInfo);
    Dfs(0,0,nums,numsSize,&retInfo);
    *returnSize = retInfo.len;
    
    int* col=(int*)malloc(sizeof(int)*retInfo.len);
    for (int i=0; i<retInfo.len; i++) {
        col[i]=numsSize;
    }
    *returnColumnSizes = col;
    return retInfo.ret;
}