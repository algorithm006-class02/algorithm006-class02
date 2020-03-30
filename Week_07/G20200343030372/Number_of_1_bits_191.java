package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/3/23
 */
public class Number_of_1_bits_191 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
