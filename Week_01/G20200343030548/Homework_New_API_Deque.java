
import java.util.Deque;
import java.util.LinkedList;

class Homework_New_API_Deque{
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.pop());
        }
        System.out.println(deque);

        //addFirst
        Deque<String> first = new LinkedList<String>();
        first.addFirst("a");
        first.addFirst("b");
        first.addFirst("c");
        System.out.println(first);
        
        String firstStr = first.getFirst();
        System.out.println(firstStr);
        System.out.println(first);

        while(first.size() > 0){
            System.out.println(first.removeFirst());
        }
        System.out.println(first);

        //addLast
        Deque<String> last = new LinkedList<String>();
        last.addLast("a");
        last.addLast("b");
        last.addLast("c");
        System.out.println(last);
        
        String lastStr = last.getLast();
        System.out.println(lastStr);
        System.out.println(last);

        while(last.size() > 0){
            System.out.println(last.removeLast());
        }
        System.out.println(last);
    }
 }