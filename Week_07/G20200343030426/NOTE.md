# 学习笔记

## 位运算

跟位运算是完全不熟，大学也学过，但仅是知道意思

怎么用？有什么用？不清楚...

力扣191题，提到了汉明重量这个词，介绍说在包括信息论、编码理论、密码学等多个领域都有应用

我觉得可以多找一下位运算应用场景相关资料，对我理解这个东西应该很有好处

二进制实话讲真的很不符合人类的正常思维，在这贴一下输出二进制字符串的方法，毕竟在不熟练的时候多打印一下，事半功倍

```
public class BinaryUtils {

    public static String toBinary(int n) {
        StringBuilder builder = new StringBuilder();
        if (n == 0) {
            return "0";
        }
        while (n > 0) {
            if (n % 2 == 1) {
                builder.insert(0, "1");
            } else {
                builder.insert(0, "0");
            }
            n = n / 2;
        }
        return StringUtils.fillStrPrefix(builder.toString(), '0', 32);
    }

}
```

```
public class StringUtils {

    /**
     * 填充字符串
     * 前缀
     *
     * @param string 待填充字符串
     * @param str    填充内容
     * @param length 字符串需达到长度
     * @return
     */
    public static String fillStrPrefix(String string, char str, int length) {
        int num = length - string.length();
        if (num > 0) {
            return fillStrContest(str, num) + string;
        } else {
            return string;
        }
    }

    /**
     * 获取填充内容
     *
     * @param str
     * @param length
     * @return
     */
    private static String fillStrContest(char str, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(str);
        }
        return builder.toString();
    }
}

```

## 布隆过滤器

可以判断一个信息一定不存在和可能存在

## 排序算法

排序算法除了应关注时间空间复杂度外，我觉得还需要关心下，是否稳定

稳定算法，不改变相等元素的前后顺序，这在很多场景中非常重要

