package week3;

/**
 * 860. 柠檬水找零
 * <p>
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class LemonadeChange {
    boolean found = true;

    public static void test() {
//        int[] bills = {5, 5, 5, 10, 20};
        int[] bills = {5, 5, 10, 10, 20};
        System.out.println("能否找零：" + new LemonadeChange().lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        // 暴力法
        int fiveBill = 0;
        int tenBill = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // 刚好5块钱不用找
                fiveBill++;
            } else if (bill == 10) {
                // 只能找5块
                if (fiveBill > 0) {
                    fiveBill--;
                    tenBill++;
                    continue;
                }
                return false;
            } else {
                // 20块，找零的方法有两种情况：1：全部是5；2：5、10和一张
                if (fiveBill > 0 && tenBill > 0) {
                    fiveBill--;
                    tenBill--;
                } else if (fiveBill >= 3) {
                    fiveBill -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
