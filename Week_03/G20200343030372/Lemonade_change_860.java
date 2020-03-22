package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/2/27
 */
public class Lemonade_change_860 {

    public boolean lemonadeChange(int[] bills) {
        int v = 0;
        int x = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    v++;
                    break;
                case 10:
                    if (v == 0) {
                        return false;
                    }
                    x++;
                    v--;
                    break;
                case 20:
                    if (x > 0 && v > 0) {
                        v--;
                        x--;
                    } else if (v >= 3) {
                        v -= 3;
                    } else {
                        return false;
                    }
            }
        }


        return true;
    }
}
