import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_22_536
 * @date : 2020/2/22 7:00 下午
 */
public class LeetCode_22_536 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) { return res; }
        generate(0, 0, n, "", res);
        return res;
    }

    public void generate(int left, int right, int n, String str, List<String> res) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, str + "(", res);
        }
        if (right < left) {
            generate(left, right + 1, n, str + ")", res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_22_536().generateParenthesis(3));
    }
}
