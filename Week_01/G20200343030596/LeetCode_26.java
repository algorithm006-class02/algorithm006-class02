public class LeetCode_26 {


    public static  void main(String[] args){
        //int data[] = new int[3]; /*开辟了一个长度为3的数组*/
//        data[0] = 1; // 第一个元素
//        data[1] = 1; // 第二个元素
//        data[2] = 2; // 第三个元素

        //int data[]={1,1,2};
        int data[]={1,1,2,2,3,3,4};

        int b=removeDuplicates(data);
        System.out.println("b:"+b);

    }

    //方法：双指针法
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
