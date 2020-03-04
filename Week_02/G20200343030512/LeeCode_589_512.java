
package Week_02.G20200343030512;
import java.util.*;
import javax.xml.soap.*;

public class Solution {

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {

        if(root == null){
            return res;
        }

        res.add(root.val);
        for(Node child:root.children){
            preorder(child);
        }

        return res;
    }
}
