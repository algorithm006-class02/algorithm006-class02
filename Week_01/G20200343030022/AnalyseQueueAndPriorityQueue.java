import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 19:36 2020/2/15
 * @Description：
 */
public class AnalyseQueueAndPriorityQueue {




    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(3);
        pq.add(1);
        pq.add(2);

        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        //打印出来我们可以看到pq其实是按照自然排序的方式出队列的如果我们想自定义排序的方式我们需要改写比较器Comparator

        PriorityQueue<Customer> pqCustomer = new PriorityQueue<>(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o2.getId() - o1.getId();
            }
        });
        pqCustomer.add(new Customer(5, "haha1"));
        pqCustomer.add(new Customer(3, "haha2"));
        pqCustomer.add(new Customer(2, "haha3"));
        pqCustomer.add(new Customer(9, "haha4"));

        while(!pqCustomer.isEmpty()){
            Customer poll = pqCustomer.poll();
            System.out.println(poll.getId()+" "+poll.getName());
        }
        //当我们打印出来可以发现因为我们重写了比较器 所以是按照id由大到小的顺序打印出来的

    }
}
