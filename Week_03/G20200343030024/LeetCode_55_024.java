import java.util.LinkedList;

public class LeetCode_55_024 {

    public static void main(String[] args) {
        new LeetCode_55_024().canJump(new int[]{2,3,1,1,4});
    }

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    // 广度遍历，执行时间太长
    public boolean canJumpWithBFS(int[] nums) {
        LinkedList<Pair> Q = new LinkedList<Pair>();
        Q.add(new Pair(0, nums[0]));

        while(!Q.isEmpty()){
            int queueLength = Q.size();
            for (int i = 0; i < queueLength; i++){
                Pair p = Q.removeFirst();
                for (int j = 1 ; j <= p.value; j++){
                    if (p.index + j >= nums.length) {
                        continue;
                    }

                    if (p.index + j == nums.length -1){
                        return true;
                    }

                    Q.addLast(new Pair(p.index + j, nums[p.index + j]));
                }
            }
        }

        return false;
    }

    class Pair {
         int index;
         int value;

         public Pair(int index, int value){
             this.index = index;
             this.value = value;
         }
    }
}