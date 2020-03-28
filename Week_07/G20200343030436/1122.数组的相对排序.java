/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] mapArray = new int[1001];
        int[] res = new int[arr1.length];
        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            mapArray[arr1[i]]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            while (mapArray[arr2[i]] > 0) {
                res[cnt++] = arr2[i];
                mapArray[arr2[i]]--;
            }
        }
        for (int j = 0; j < 1001; j++) {
            while (mapArray[i] > 0) {
                res[cnt++] = i;
                mapArray[i]--;
            }
        }
        return res;
    }


       /**
 1  先计算arr1 中，每一个数字出现的次数的 dict
 2  遍历数组 arr2
 3 结合字典dict 获得每一值得次数，像结果res中append
 4 temp保存在arr1中，但不在arr2中的值，并使用sort排序
 5将result和 temp一起返回
 */
// func relativeSortArray(_ arr1: [Int], _ arr2: [Int]) -> [Int] {
//     var dict = [Int: Int]()
//     var result = [Int]()
//     for i in arr1 {
//         dict[i] = (dict[i] ?? 0) + 1//统计数字中 每个位置的值 出现的次数
//     }
//     for j in arr2 {
//         if let val = dict[j] {
//             for _ in 0 ..< val {
//                 result.append(j)//把子序列的值 枚举插入到 result数组里
//             }
//             dict.removeValue(forKey: j)//并从字典里删除这个数组2包含的 键值对
//         }
//     }
//     var simplaArray = [Int]()
//     if !dict.isEmpty {
//         for (key, value) in dict {
//             for _ in 0 ..< value {
//                 simplaArray.append(key)
//             }
//             dict.removeValue(forKey: key)
//         }
//     }
//     result.append(contentsOf: simplaArray.sorted())
//     return result
// }
}
// @lc code=end

