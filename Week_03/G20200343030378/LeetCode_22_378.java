import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_378 {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        helper(0,0,n,"",ret);
        return ret;
    }

    private void helper(int left, int right, int n, String s,List<String> ret) {
        //terminator
        if(left == n && right == n){
            ret.add(s);
            return;
        }
        //process
        //dirll down
        if(left < n)
            helper(left+1,right,n,s+"(",ret);
        if(right < left)
            helper(left,right + 1,n,s+")",ret);

        //resize
    }
}
