import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ：zhenghaoran.
 * @Description：120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
[2],
[3,4],
[6,5,7],
[4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 */
public class LeetCode_120_022 {
    public static void main(String[] args) {
        LeetCode_120_022 l = new LeetCode_120_022();
        List<List<Integer>> list = new ArrayList();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        l.minimumTotal(list);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i = triangle.size() -1;i >= 0;i--){
            for(int j = 0;j < triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    int row;
    public int minimumTotal3(List<List<Integer>> triangle) {
        row = triangle.size();
        return helper(0,0,triangle);

    }

    private int helper(int i, int j, List<List<Integer>> triangle) {
        if (i == row - 1) {
            return triangle.get(i).get(j);
        }
        int left = helper(i + 1, j, triangle);
        int right = helper(i + 1, j +1, triangle);

        return Math.min(left,right) + triangle.get(i).get(j);
    }


}
