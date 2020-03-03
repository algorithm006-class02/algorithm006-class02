package Week_03.G20200343030512;

class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int fivebills = 0;
        int tenbills = 0;
        int twentybills = 0;

        int billslength = bills.length;

        for(int i = 0;i < billslength;i++){

            if (bills[i] == 5){
                fivebills++;
            }
            else if(bills[i] == 10){
                if(fivebills == 0)
                    return false;
                tenbills++;
                fivebills--;
            } else{
                if(fivebills >0 && tenbills >0){
                    fivebills--;
                    tenbills--;
                }else if(fivebills >= 3){
                    fivebills -= 3;
                }else return false;
            }
        }

        return true;


    }
}