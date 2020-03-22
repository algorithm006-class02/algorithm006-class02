#define FIVE 0
#define TEN 1
#define TEWEN 2
#define MIN(a,b) a<b?a:b

void CalInput(int x,int *countIn)
{
    switch (x) {
        case 5:
            countIn[FIVE]++;
            break;
        case 10:
            countIn[TEN]++;
            break;
        case 20:
            countIn[TEWEN]++;
            break;
        default:
            break;
    }
    return;
}

bool Calout(int x,int *countIn)
{
    int tw = x/20;
    tw = MIN(tw,countIn[TEWEN]);
    int ten = (x - tw*20)/10;
    ten=MIN(ten, countIn[TEN]);
    int f = (x-(tw*20+ten*10))/5;
    countIn[FIVE]-=f;
    countIn[TEN]-=ten;
    countIn[TEWEN]-=tw;
    for (int i=0; i<3; i++) {
       // printf("%d ",countIn[i]);
        if(countIn[i]<0)
        {
            return false;
        }
    }
    //printf("\n");
    return true;
}

bool lemonadeChange(int* bills, int billsSize){
    int countIn[3]={0};
    
    for(int i=0;i<billsSize;i++)
    {
        CalInput(bills[i],&countIn);
        int out = bills[i]-5;
        if(false==Calout(out,&countIn))
        {
            return false;
        }
    }
    return true;
}
