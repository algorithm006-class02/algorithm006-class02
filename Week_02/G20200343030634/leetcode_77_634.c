typedef struct retInfoTag
{
    int** ret;
    int len;
    int max;
}retType;

void initList(retType* retInfo)
{
    retInfo->ret= (int**)malloc(sizeof(int*)*100);
    retInfo->len =0;
    retInfo->max = 100;
    return;
}

void pushList(retType* retInfo,int* line)
{
    
    if(retInfo->len>=retInfo->max)
    {
        int **temp = retInfo->ret;
        retInfo->ret= (int**)malloc(sizeof(int*)*(100+retInfo->max));
        for (int i=0; i<retInfo->max; i++) {
            retInfo->ret[i]=temp[i];
        }
        free(temp);
        retInfo->max+=100;
    }
    retInfo->ret[retInfo->len]=line;
    retInfo->len++;
    return;
}
//传递到下一层需要的信息，1是level，2是极限max，3data，这里max是k组合长度，data是已经完成拼接的数组
void Dfs(int level,int n,int k, int* line,int first,retType *retInfo)
{
    //xianzhi
    
    //jisuan
    for(int j= first;j<=n;j++)
    {
        int* temp=(int*)malloc(sizeof(int)*k);
        for(int i = 0;i<level;i++)
        {
            temp[i]=line[i];
        }
        temp[level]=j;
        
        if(level>=(k-1))
        {
            //retInfo->ret[retInfo->len]=temp;
            //retInfo->len++;
            pushList(retInfo, temp);
            continue;
        }
        Dfs(level+1,n,k,temp,j+1,retInfo);
    }
    free(line);
    //xiayiceng
    
    //shifang
}
long CalSize(int n,int k)
{
    long sum=n;
    for (int i=1; i<k; i++) {
        sum=sum*(n-1);
    }
    
    long sum2=k;
    for (int j=1; j<k; j++) {
        sum2=sum2*(k-1);
    }
    
    return sum/sum2;
}

int** combine(int n, int k, int* returnSize, int** returnColumnSizes){
  //  long size= CalSize(n, k);
    retType retInfo = {0};
    //retInfo.ret = (int**)malloc(sizeof(int*)*size);
    //retInfo.len = 0;
    initList(&retInfo);
    Dfs(0,  n,  k, NULL, 1,  &retInfo);
    
    *returnSize = retInfo.len;
    int * col=(int*)malloc(sizeof(int)*(retInfo.len));
    for(int i=0;i<retInfo.len;i++)
    {
        col[i]=k;
    }
    *returnColumnSizes = col;
    return retInfo.ret;
    
}