/* 作业：用 add first 或 add last 这套新的 API 改写 Deque 的代码 */
import java.util.*; 
public class DequeDemo
{ 
    public static void main(String[] args) 
    { 
        Deque<String> deque = new LinkedList<String>(); 
  
        deque.addFirst("a"); 
        deque.offerFirst("b"); 
        deque.addLast("c");
        System.out.println(deque); 

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }

        System.out.println(deque);
    } 
} 
