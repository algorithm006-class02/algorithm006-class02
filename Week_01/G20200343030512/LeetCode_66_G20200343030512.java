package Week01.G20200343030512;

public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        //判断数组最后一个元素是否为9，是否需要进位；
        for(int i = length - 1;i>= 0; i--){
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }

        //处理整型溢出的情况，案例[9,9,9,9]
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;



    }
}

/*执行后发现处理整型溢出的情况有误，对于[1,9,9,9]案例输出为[1,0,0,0,0],而不是[2,0,0,0]，进行改进*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        //判断数组最后一个元素是否为9，是否需要进位；
        for(int i = length - 1;i>= 0; i--){
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        //
        int newdigits[] ;
        int sum = 0;
        for(int j=0;j<length;j++){
            sum += digits[j];
        }
        if(sum == 0){
            newdigits = new int[length+1];
            newdigits[0] = 1;
            return newdigits;
        }else return digits;


    }
}