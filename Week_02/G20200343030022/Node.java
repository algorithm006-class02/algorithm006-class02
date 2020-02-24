import java.util.List;

/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 20:38 2020/2/20
 * @Description：
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
