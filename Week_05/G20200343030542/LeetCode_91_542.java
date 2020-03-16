
import java.util.Arrays;

public class DecodeWays {

    public int numDecodings(String s) {
        //return getAnsByRecursionAndMemory(s);
        return getAnsByDp(s);
    }

    private int getAnsByDp(String str){
        if (str == null || str.length() == 0) {
            return 0;
        }
        if(str.charAt(0)=='0'){
            return 0;
        }
        int[] dp = new int[str.length() + 1];
        //初始化第一种解码方式
        dp[0] = 1;
        //如果第一位是0，则无法解码
        dp[1] = str.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= str.length(); i++) {
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            int tmp = Integer.parseInt(str.substring(i-2, i));
            if( tmp<= 26 && tmp >= 10){
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if(Integer.parseInt(str.substring(i-1, i)) != 0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[str.length()];
    }

    private int getAnsByRecursionAndMemory(String s) {
        int[] memory = new int[s.length() + 1];
        Arrays.fill(memory, -1);
        return getAns(s, 0, memory);
    }

    public int getAns(String str, int index, int[] memory) {
        if (memory[index] != -1) {
            return memory[index];
        }
        if (index == str.length()) {
            return 1;
        }
        if (str.charAt(index) == '0') {
            return 0;
        }
        int case1 = getAns(str, index + 1, memory);
        int case2 = 0;
        if (index < str.length() - 1) {
            int ten = (str.charAt(index) - '0') * 10;
            int one = str.charAt(index + 1) - '0';
            if (ten + one <= 26) {
                case2 = getAns(str, index + 2, memory);
            }
        }
        memory[index] = case1 + case2;
        return case1 + case2;
    }

}
