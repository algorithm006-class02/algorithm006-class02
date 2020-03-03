public class LeetCode_69_378 {
    public static int mySqrt(int x) {
        if(0 == x|| 1==x)
            return x;
        long left = 1,right =x,mid=1;
        while (left<=right){
            mid = left+(right-left)/2;
            if(mid*mid>x){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        int i = mySqrt(8);
        System.out.println(i);
    }
}
