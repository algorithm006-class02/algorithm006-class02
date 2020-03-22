#define MAX 100000

typedef struct queueTag {
    int *data;
    int top;
    int base;
    int max;
} queueType;

typedef struct retTag {
    char ***ret;
    int retSize;
    int col;
    int max;
} retType;

void InitRet(retType *retInfo)
{
    retInfo->ret = (char ***)malloc(sizeof(char **) * MAX);
    memset(retInfo->ret,0,sizeof(char **) * MAX);
  
    retInfo->retSize = 0 ;
    retInfo->col=0;
    retInfo->max = MAX;
    return;
}

void PushRet(retType* retInfo,char** line)
{
    retInfo->ret[retInfo->retSize]= line;
    retInfo->retSize++;
}



typedef struct tableTag
{
    int** data;
    int len;
    int max;
}tableType;




void InitTable(tableType *table)
{
    table->data = (int**)malloc(sizeof(int*)*MAX);
    table->len = 0;
    table->max =MAX;
    return;
}

void PushTable(tableType *table ,int* line)
{
    if (table->len>=table->max)
    {
        int** temp =table->data;
        table->data = (int**)malloc(sizeof(int*)*(table->max+MAX));
        for (int i = 0; i < table->max; i++)
        {
            table->data[i]=temp[i];
        }
        table->max+=MAX;
        free(temp);
    }
    table->data[table->len] = line;
  //  printf("PushTable %d",table->data[0][0]);
    table->len++;
    return;
}

void genNext(int level,tableType *tableA,tableType *tableB,int a,int b)
{
    for (int i = 0; i < tableA->len; i++)
    {
      //  printf("genNext %d %d",tableA->data[0][0],a);
        if (tableA->data[i][level-1]==a)
        {
            int* temp = (int*)malloc(sizeof(int)*(level+1));
            for (int j = 0; j < level; j++)
            {
                temp[j]=tableA->data[i][j];
            }
            //printf("level %d",level);
            temp[level]=b;

            PushTable(tableB,temp);
        }
    }
}

void TableAfillB(tableType *tableA,tableType *tableB)
{
    for (int i = 0; i < tableA->len; i++)
    {
        free(tableA->data[i]);
    }
    tableA->data=tableB->data;
    tableA->len= tableB->len;
    tableA->max=tableB->max;
    InitTable(tableB);
    return;
}

void InitQueue(queueType *queue)
{
    queue->data = (int *)malloc(sizeof(int) * MAX);
    queue->base = 0;
    queue->top = 0;
    queue->max = MAX;
    return;
}

void PushQueue(queueType *queue, int x)
{
    if (queue->top >= queue->max) {
        int j = 0;
        for (int i = queue->base; i < queue->top; i++, j++) {
            queue->data[j] = queue->data[i];
        }
    }
    queue->data[queue->top] = x;
    queue->top++;
    return;
}

bool PopQueue(queueType *queue, int *x)
{
    if (queue->top == queue->base) {
        return false;
    }
    *x = queue->data[queue->base];
    queue->base++;
    return true;
}

bool QueueEmpty(queueType *queue)
{
    return (queue->top == queue->base) ? true : false;
}

int QueueLen(queueType *queue)
{
    return queue->top - queue->base;
}

bool IsNext(int now, int next, char **wordList, int wordListSize)
{
    char *stra = wordList[now];
    char *strb = wordList[next];
    int len = strlen(stra);
    int count = 0;
    for (int i = 0; i < len; i++) {
        if (stra[i] != strb[i]) {
            count++;
        }
        if (count >= 2) {
            return false;
        }
    }

    if (count == 1) {
        return true;
    }
    return false;
}

void TransTableToRet(int size,tableType *table,retType *retInfo, int end,char **wordList, int wordListSize)
{
    for (int j = 0; j < table->len; j++)
    {
        if (table->data[j][size-1]!= end)
        {
            continue;
        }
        
        char** line =(char**)malloc(sizeof(char*)*size);
        for (int i = 0; i < size; i++)
        {
            char* temp=(char*)malloc(sizeof(char)*(strlen(wordList[i])+1));
            strcpy(temp,wordList[table->data[j][i]]);
            line[i]=temp;
        }
        PushRet(retInfo,line);
    }
    return;
}


void Bfs(int begin,int end, char **wordList, int wordListSize,retType *retInfo)
{
    int *visited = (int *)malloc(sizeof(int) * wordListSize);
    (void)memset(visited,  0, sizeof(int) * wordListSize);

    queueType queue = { 0 };
    InitQueue(&queue);
    PushQueue(&queue, begin);
    
    tableType tableA={0};
    InitTable(&tableA);
    tableType tableB={0};
    InitTable(&tableB);
    int *first = (int*)malloc(sizeof(int));
    first[0]=begin;
    PushTable(&tableA,first);
    //InsertFirst(retInfo,wordList[begin]);
    int level = 0;
    bool find = false;
    while (!QueueEmpty(&queue)) {
        int queueLen = QueueLen(&queue);
        level ++;
        for (int j = 0; j < queueLen; j++) {
            int now = 0;
            if (false == PopQueue(&queue, &now)) {
                return;
            }
            if (visited[now]==1)
            {
                continue;
            } 
            visited[now] = 1;
          //  printf("process %s \n",wordList[now]);
            
            for (int i = 0; i < wordListSize; i++) {
                if ((true == IsNext(now, i, wordList, wordListSize)) && (visited[i] == 0)) {

             //       printf("push %s \n",wordList[i]);
                    genNext(level,&tableA,&tableB,now,i);

                    if (i==end)
                    {
                        find = true;
                    }

                    PushQueue(&queue, i);
                }
            }
        }
        TableAfillB( &tableA, &tableB);
        if(find==true)
        {
            TransTableToRet( level+1, &tableA, retInfo,end, wordList,  wordListSize);
            retInfo->col = level+1;
            return;
        }
    }
}

int findindex(char *Word, char **wordList, int wordListSize)
{
    for (int i = 0; i < wordListSize; i++)
    {
        if(0 == strcmp(Word,wordList[i]))
        {
            return i;
        }
    }
    return -1;
}

char ***findLadders(char *beginWord, char *endWord, char **wordList, int wordListSize, int *returnSize,
    int **returnColumnSizes)
{

    retType retInfo = {0};
    InitRet(&retInfo);
    char **wordListBfs = NULL;
    int wordListSizeBfs = 0;


    wordListBfs = (char**)malloc(sizeof(char*)*(wordListSize+1));
    wordListSizeBfs=wordListSize+1;
    wordListBfs[0]=beginWord;
    for (int i = 0; i < wordListSize; i++)
    {
        wordListBfs[i+1]=wordList[i];
    }



    int b = findindex( beginWord, wordListBfs, wordListSizeBfs);
    int e = findindex( endWord, wordListBfs, wordListSizeBfs);
    if ((b==-1)||(e==-1))
    {
        *returnSize = 0;
        return 0;
    }

    Bfs( b,e,  wordListBfs,  wordListSizeBfs, &retInfo);


    *returnSize = retInfo.retSize;
    int* col =(int*)malloc(sizeof(int)*retInfo.retSize);
    for (int i = 0; i < retInfo.retSize; i++)
    {
        col[i] = retInfo.col;
    }
    *returnColumnSizes = col;
    return retInfo.ret;
}
