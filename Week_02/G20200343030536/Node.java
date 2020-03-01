import java.util.List;

/**
 * @author : Hyuk
 * @description : Node
 * @date : 2020/2/22 12:02 上午
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int val) { this.val = val; }
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
