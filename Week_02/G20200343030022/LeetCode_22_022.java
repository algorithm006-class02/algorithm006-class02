import java.util.ArrayList;
import java.util.List;

/**
 * @Description：
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]
 */
public class LeetCode_22_022 {

    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {

        helper(0,0,n,"");
        return res;
    }

    public void helper(int left, int right,int level,String s){
        if(left == level && right == level){
            res.add(s);
            return;
        }
        if(left < level){
            helper(left+1,right,level,s + "(");
        }
        if(left > right)
            helper(left,right+1,level,s + ")");

    }
}
