package G20200343030372;

import java.util.Arrays;

/**
 * @author Chen.C
 * @date 2020/2/28
 */
public class Assign_cookies_455 {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
