import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description：用 add first 或 add last 这套新的 API 改写 Deque 的代码
 */
public class RewriteDeque {


    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        System.out.println(deque);

        String peek = deque.peek();
        System.out.println(peek);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);

    }
}
