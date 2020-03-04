//
//  main.c
//  cfortest
//
//  Created by 龙胜 on 2019/11/15.
//  Copyright © 2019 龙胜. All rights reserved.
//

#define MAX 100

typedef struct retTag
{
    int** ret;
    int len;
    int max;
}retType;

void initList(retType *retInfo)
{
    retInfo->ret = (int**)malloc(sizeof(int*)*MAX);
    retInfo->len = 0;
    retInfo->max = MAX;
    return;
}

void pushList(retType *retInfo,int* x,int numsSize)
{
    if(retInfo->len>=retInfo->max)
    {
        int** temp = retInfo->ret;
        retInfo->ret = (int**)malloc(sizeof(int*)*(retInfo->max+MAX));
        for (int i=0; i<retInfo->max; i++) {
            retInfo->ret[i]= temp[i];
        }
        free(temp);
        retInfo->max+=MAX;
    }
    int* temp=(int*)malloc(sizeof(int)*numsSize);
    for (int i=0; i<numsSize; i++) {
        temp[i]=x[i];
    }
    retInfo->ret[retInfo->len]=temp;
    retInfo->len++;
}
void swip(int i,int j ,int*line)
{
    int temp = line[i];
    line[i]=line[j];
    line[j]=temp;
    return;
}

void Dfs(int level,int* nums, int numsSize,retType *retInfo)
{
    if(level>=numsSize)
    {
        pushList(retInfo, nums,numsSize);
    }
    for (int i = level; i<numsSize; i++) {

        if((i!=level)&&(nums[i]==nums[level]))
        {
            continue;
        }
        bool flag=false;
        for(int j=level;j<i;j++)
        {
            if(nums[j]==nums[i])
            {
                flag=true;
            }
        }
        if(flag==true)
        {
            continue;
        }
        swip(level,i,nums);
        Dfs(level+1,  nums,  numsSize,  retInfo);
        swip(i,level,nums);
    }
    return;
}

int** permuteUnique(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
    
    retType retInfo={0};
    initList(&retInfo);
    Dfs(0, nums, numsSize, &retInfo);
    *returnSize = retInfo.len;
    int* col=(int*)malloc(sizeof(int)*retInfo.len);
    for (int i = 0; i<retInfo.len; i++) {
        col[i]=numsSize;
    }
    *returnColumnSizes = col;
    return retInfo.ret;
}



