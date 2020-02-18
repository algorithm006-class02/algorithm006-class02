import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Hyuk
 * @description : LeetCode_1_536
 * @date : 2020/2/15 6:24 下午
 */
public class LeetCode_1_536 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Node[] nodes = new Node[nums.length];
        for (int i = 0, len = nums.length; i < len; ++i) {
            nodes[i] = new Node(nums[i], i);
        }
        Arrays.sort(nodes, Comparator.comparing(node -> node.val));

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nodes[left].val + nodes[right].val;
            if (sum == target) {
                return new int[]{nodes[left].idx, nodes[right].idx};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; ++i) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}

class Node {
    int val;
    int idx;

    Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
