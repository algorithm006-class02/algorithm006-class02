/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 10:34 2020/4/5
 * @Description：
 */
public class LeetCode_541_022 {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);

    }
}
