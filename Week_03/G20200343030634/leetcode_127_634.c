
#define MAX 100000

typedef struct queueTag
{
    int* data;
    int top;
    int base;
    int max;
}queueType;

void init(queueType* queue)
{
    queue->data = (int*)malloc(sizeof(int)*MAX);
    queue->top = 0;
    queue->base = 0;
    queue->max=MAX;
    return;
}
bool empty(queueType* queue)
{
    return (queue->top-queue->base)>0?false:true;
}
int pop(queueType* queue)
{
    int x = queue->data[queue->base];
    queue->base++;
    return x;
}
void push(queueType* queue,int x)
{
    if(queue->top>=queue->max)
    {
        int j=0;
        for(int i=queue->base;i<queue->top;i++,j++)
        {
            queue->data[j]=queue->data[i];
        }
        queue->base=0;
        queue->top=j;
    }
    queue->data[queue->top]=x;
    queue->top++;
    return;
}
int len(queueType* queue)
{
    return queue->top-queue->base;
}

bool IsNext(int a,int b,char ** wordList)
{
    char* astr=wordList[a];
    char* bstr=wordList[b];
    int len = strlen(astr);
    int count = 0;
    for (int i =0; i<len; i++) {
        if (astr[i]!=bstr[i]) {
            count++;
        }
    }
    if (count==1) {
        return true;
    }
    return false;
}
int find(char *dst,char ** wordList, int wordListSize)
{
    for (int i=0; i<wordListSize; i++) {
        if(0==strcmp(dst,wordList[i]))
        {
            return i;
        }
    }
    return -1;
}
int Bfs(int* book,int end,char ** wordList, int wordListSize,queueType *queue)
{
    int ret=0;
    while(false == empty(queue))
    {
        int qlen=len(queue);
        ret++;
        for (int j=0; j<qlen; j++) {
            int temp = pop(queue);
            printf("%d ",temp);
            
            if (temp==end) {
                return ret;
            }
            for (int i=0; i<wordListSize; i++) {
                if((book[i]==0)&&(true==IsNext(temp,i,wordList)))
                {
                    printf("push %d ",i);
                    book[i]=1;
                    push(queue,i);
                }
            }
        }
        printf("\n");
    }
    return 0;
}


int ladderLength(char * beginWord, char * endWord, char ** wordList, int wordListSize){
    int tempSize=wordListSize+1;
    char** temp=(char**)malloc(sizeof(char*)*tempSize);
    temp[0]=beginWord;
    for (int i = 0; i<wordListSize; i++) {
        temp[i+1]=wordList[i];
    }
    
    int a = find(beginWord, temp,  tempSize);
    int b = find(endWord, temp,  tempSize);
    if ((a==-1)||(b==-1)) {
        return 0;
    }
    int* book =(int*)malloc(sizeof(int)*tempSize);
    memset(book,0,sizeof(int)*tempSize);
    queueType queue={0};
    init(&queue);
    push(&queue,0);
    book[0]=1;
    int ret = Bfs(book, b, temp,  tempSize,&queue);
    
    return ret;
}