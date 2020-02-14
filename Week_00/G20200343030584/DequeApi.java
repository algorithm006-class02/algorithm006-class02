import java.util.Deque;
import java.util.LinkedList;

public class DequeApi {
    public static void test() {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");
        deque.push("e");
        System.out.println(deque); // [e, d, c, b, a]

        String str = deque.peekFirst();
        System.out.println(str); // e
        System.out.println(deque); // [e, d, c, b, a]

        str = deque.peekLast();
        System.out.println(str); // a
        System.out.println(deque); // [e, d, c, b, a]

        str = deque.pollFirst();
        System.out.println(str); // e
        System.out.println(deque); // [d, c, b, a]

        str = deque.pollLast();
        System.out.println(str); // a
        System.out.println(deque); // [d, c, b]

        while (deque.size() > 0) {
            System.out.print(deque.pollFirst() + " "); // d c b
        }
        System.out.println(deque); // []
    }
}
