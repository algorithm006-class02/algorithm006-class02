
package Week_02.G20200343030512;
import java.util.*;
import javax.xml.soap.*;

public class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {

        if(root == null){
            return res;
        }


        for(Node child:root.children){
            postorder(child);
        }
        res.add(root.val);
        return res;
    }
}