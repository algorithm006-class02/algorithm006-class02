class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill: bills){
            if(bill == 5){
                five++;
            }else if(bill ==  10){
                if(five == 0){
                    return false;
                }else{
                    five--;
                    ten++;
                }
            }else if(bill == 20){
                if(five >0 && ten>0){ //best condition
                    five--;
                    ten--;
                }else if(ten == 0 && five>3){ //second condition
                    five=five-3;
                }else{
                    return false;
                } 
            }
        }
        return true;
    }
}
