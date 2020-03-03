package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/2/28
 */
public class Jump_game_55 {

    public boolean canJump(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > result) {
                return false;
            }
//            if(result == nums.length - 1){
//                return true;
//            }
//            if (nums[i] == 0 && i != nums.length - 1) {
//                return false;
//            }

//            result = i + nums[i];
            result = Math.max(result, i + nums[i]);
        }
        return true;
    }

}
