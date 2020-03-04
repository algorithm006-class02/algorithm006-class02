import java.util.ArrayList;
import java.util.List;

class LeetCode_22 {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _generate(0, 0, n,"");
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
        //terminator
        if(left == n && right == n) {
            result.add(s);
            return;
        }
        if(left < n)
            _generate(left + 1, right, n, s + '(');
        if(right < left)
            _generate(left, right + 1, n, s + ')');
    }

    public static void main(String[] args) {
        LeetCode_22 solution = new LeetCode_22();
        System.out.println(solution.generateParenthesis(3));
    }
}
