//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
//
// 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
//
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
//
// 注意，一开始你手头没有任何零钱。
//
// 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
//
// 示例 1：
//
// 输入：[5,5,5,10,20]
//输出：true
//解释：
//前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//由于所有客户都得到了正确的找零，所以我们输出 true。
//
//
// 示例 2：
//
// 输入：[5,5,10]
//输出：true
//
//
// 示例 3：
//
// 输入：[10,10]
//输出：false
//
//
// 示例 4：
//
// 输入：[5,5,10,10,20]
//输出：false
//解释：
//前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
//对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
//对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
//由于不是每位顾客都得到了正确的找零，所以答案是 false。
//
//
//
//
// 提示：
//
//
// 0 <= bills.length <= 10000
// bills[i] 不是 5 就是 10 或是 20
//
// Related Topics 贪心算法


import java.util.HashMap;
import java.util.Map;

class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        // 贪心法求解
        // 构建一个 Map，存储店家的零钱
        // 找零优先找大的，再找小的（贪心）
        // 如果遍历中，无法找零，返回 false
        // 所有遍历完成，无问题，那么返回 true

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < bills.length; i++) {

            if (bills[i] == 5) { // 5 美元，无需找零，更新 map 即可

                if (!map.containsKey(5)) {
                    map.put(5, 1);
                } else {
                    map.put(5, map.get(5) + 1);
                }

            } else if (bills[i] == 10) { // 10 美元，要找零，只能找 5 美元，同时更新 map

                if (!map.containsKey(5)) {
                    return false;
                } else {
                    if (!map.containsKey(10)) {
                        map.put(10, 1);
                    } else {
                        map.put(10, map.get(10) + 1);
                    }

                    map.put(5, map.get(5) - 1);

                    if (map.get(5) == 0) {
                        map.remove(5);
                    }
                }

            } else { // 20 美元，要找零（有两种）：1 个 10、1 个 5；3 个 5；更新 map

                if (map.containsKey(10)) {

                    if(!map.containsKey(5)){
                        return false;
                    } else {
                        if (!map.containsKey(20)) {
                            map.put(20, 1);
                        } else {
                            map.put(20, map.get(20) + 1);
                        }

                        map.put(5, map.get(5) - 1);
                        map.put(10, map.get(10) - 1);

                        if (map.get(5) == 0) {
                            map.remove(5);
                        }

                        if (map.get(10) == 0) {
                            map.remove(10);
                        }

                    }

                } else {

                    if (!map.containsKey(5)) {
                        return false;
                    } else {

                        if (map.get(5) < 3) {
                            return false;
                        } else {

                            if (!map.containsKey(20)) {
                                map.put(20, 1);
                            } else {
                                map.put(20, map.get(20) + 1);
                            }

                            map.put(5, map.get(5) - 3);

                            if (map.get(5) == 0) {
                                map.remove(5);
                            }

                        }

                    }

                }

            }

        }

        return true;
    }
}

