class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long num;
        int pivot, left = 2, rigth = x / 2;
        while (left <= rigth) {
            pivot = left + (rigth - left) / 2;
            num = (long) pivot * pivot;
            if (num > x) rigth = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return rigth;
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        return (long) right + left > x ? left : right;
    }
}