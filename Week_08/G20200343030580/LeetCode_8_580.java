class Solution {
    public int myAtoi(String str) {
        long result = 0;
        boolean positive = true;
        boolean num = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case ' ':
                    if (num) {
                        return (int) result;
                    }
                    break;
                case '-':
                    if (num) {
                        return (int) result;
                    } else {
                        positive = false;
                    }
                    num = true;
                    break;
                case '+':
                    if (num) {
                        return (int) result;
                    } else {
                        positive = true;
                    }
                    num = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    num = true;
                    if (positive) {
                        result = result * 10 + (int) (c - '0');
                        if (result > Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        result = result * 10 - (int) (c - '0');
                        if (result < Integer.MIN_VALUE) {
                            return Integer.MIN_VALUE;
                        }
                    }
                    break;
                default:
                    return (int) result;
            }
        }
        return (int) result;
    }
}