package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/4/3
 */
public class String_to_integer_atoi_8 {

    public int myAtoi(String str) {
        int index = 0, symbol = 1, result = 0;
        if (str.length() == 0) {
            return 0;
        }
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            symbol = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit) {
                return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = 10 * result + digit;
            index++;
        }

        return symbol * result;
    }
}
