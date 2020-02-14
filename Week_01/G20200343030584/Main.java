/**
 * 说明：
 * LeetCode_1 {@link TwoSum}
 * LeetCode_21 {@link MergeSortedList}
 * LeetCode_26 {@link RemoveDuplicate}
 * LeetCode_66 {@link PlusOne}
 * LeetCode_88 {@link MergeSortedArray}
 * LeetCode_189 {@link RotateArray}
 * LeetCode_283 {@link MoveZeros}
 * LeetCode_641 {@link MyCircularDeque}
 * LeetCode_42 {@link TrappingRainWater}
 */
public class Main {

    public static void main(String[] args) {
//        RemoveDuplicate.test();
//        RotateArray.test();
//        MergeSortedList.test();
//        MergeSortedArray.test();
//        TwoSum.test();
//        MoveZeros.test();
//        PlusOne.test();
//        DequeApi.test();

//        testCirularDeque();
        TrappingRainWater.test();
    }

    private static void testCirularDeque() {
        MyCircularDeque circularDeque = new MyCircularDeque(4);

        boolean success = circularDeque.insertFront(1);
        System.out.println("success:" + success); // true
        success = circularDeque.insertFront(2);
        System.out.println("success:" + success); // true
        System.out.println("isFull:" + circularDeque.isFull());  // false
        success = circularDeque.insertFront(3);
        System.out.println("success:" + success); // true
        success = circularDeque.insertLast(4);
        System.out.println("success:" + success); // true
        success = circularDeque.insertFront(5);
        System.out.println("success:" + success); // false

        System.out.println("isFull:" + circularDeque.isFull()); // true
        System.out.println("isEmpty:" + circularDeque.isEmpty()); // false

        System.out.println("getFront:" + circularDeque.getFront()); // 3
        System.out.println("getRear:" + circularDeque.getRear()); // 4

        System.out.println("deleteFront:" + circularDeque.deleteFront()); // true
        System.out.println("deleteLast:" + circularDeque.deleteLast()); // true

        System.out.println("isFull:" + circularDeque.isFull()); // false
        System.out.println("isEmpty:" + circularDeque.isEmpty()); // false

        System.out.println("getFront:" + circularDeque.getFront()); // 2
        System.out.println("getRear:" + circularDeque.getRear()); // 1
    }
}
