
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by HuGuodong on 2/15/20.
 */
public class DequeAPI {

  public static void main(String[] args) {
    Deque<Integer> deque = new LinkedList<>();
    deque.addFirst(1);
    deque.addFirst(2); // 2 1
    assert deque.getFirst() == 2;
    assert deque.removeLast() == 1;
    assert deque.getFirst() == 2;
    assert deque.getLast() == 2;
    deque.addLast(3); // 2 3
    int last = deque.pollLast(); // 3
    System.out.println(last);
    for (int i : deque) {
      System.out.println("ele in deque is: " + i); // 2
    }

  }
}
