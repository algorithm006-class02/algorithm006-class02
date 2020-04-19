import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_387_022 {

    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        char[] arr = s.toCharArray();
        Map<Character,Integer> c = new HashMap();
        for(char a : arr){
            c.put(a,c.getOrDefault(a,0)+1);
        }

        for(int i = 0; i < arr.length; i++){
            if(c.get(arr[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
