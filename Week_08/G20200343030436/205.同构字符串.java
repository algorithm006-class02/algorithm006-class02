import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    //用一个 map 来处理映射。对于 s 到 t 的映射，我们同时遍历 s 和 t ，假设当前遇到的字母分别是 c1 和 c2 。
// 如果 map[c1] 不存在，那么就将 c1 映射到 c2 ，即 map[c1] = c2。
// 如果 map[c1] 存在，那么就判断 map[c1] 是否等于 c2，也就是验证之前的映射和当前的字母是否相同
// 对于这道题，我们只需要验证 s - > t 和 t -> s 两个方向即可。如果验证一个方向，是不可以的。

// 举个例子，s = ab, t = cc，如果单看 s -> t ，那么 a -> c, b -> c 是没有问题的。

// 必须再验证 t -> s，此时，c -> a, c -> b，一个字母对应了多个字母，所以不是同构的。
    public boolean isIsomorphic1(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t){
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    // 一个人说中文，一个人说法语，怎么判断他们说的是一个意思呢？把中文翻译成英语，把法语也翻译成英语，然后看最后的英语是否相同即可。
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前映射是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}
// @lc code=end

