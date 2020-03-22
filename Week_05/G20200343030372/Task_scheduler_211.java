package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/3/11
 */
public class Task_scheduler_211 {

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for (char c : tasks) {
            counter[(c - 'A')]++;
        }
        int max = 0;
        int count = 1;
        for (int num : counter) {
            if (num == 0) {
                continue;
            }
            if (max < num) {
                max = num;
                count = 1;
            } else if (max == num) {
                count++;
            }
        }
        int space = (n + 1) * (max - 1) + count;
        return Math.max(space, tasks.length);
    }
}
