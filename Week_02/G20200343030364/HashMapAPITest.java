import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuGuodong on 2/23/20.
 */
public class HashMapAPITest {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      map.put(i, i);
    }
    map.forEach((k, v) -> System.out.println(k + ":" + v));
  }
}
