import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1122_590 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //create map for counting numbers in arr1. Initialize everything with zeroes
        Map<Integer, Integer> m = new HashMap();
        for (int num : arr2) {
            m.put(num, 0);
        }
        int last = arr1.length - 1;
        int[] res = new int[arr1.length];
        //iterate over arr1  and count numbers of time this element is in arr1
        for (int num : arr1) {
            //if number is from arr2 - increment count
            if (m.containsKey(num))
                m.put(num, m.get(num) + 1);
                //otherwise add element to the end of res and decrement the pointer
            else {
                res[last--] = num;
            }
        }
        //iterate over arr2, fill elements in res based on it's count
        int p = 0;
        for (int num : arr2) {
            int c = m.get(num);
            for (int i = 0; i < c; i++) {
                res[p++] = num;
            }
        }
        //now sort the leftovers - p points to the first element in series of those from arr2 that are not in arr1
        Arrays.sort(res, p, res.length);
        return res;
    }
}
