/*
 * @lc app=leetcode.cn id=72 lang=javascript
 *
 * [72] 编辑距离
 */

// @lc code=start
/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function (word1, word2) {
    // 在字符串前添加空格，方便初始化 dp 的第一行及第一列
    let str1 = ' ' + word1;
    let str2 = ' ' + word2;

    const n = str1.length, m = str2.length;
    // 若字符间有一个为0，直接返回另一字符的长度，加上此判断可以快 4ms。
    if (n * m === 0) {
        return n + m;
    }
    // 初始化 dp 为 n 行，m 列的二维数组。
    let dp = [...new Array(n)].map(() => new Array(m));
    // 初始化 dp 第一列的编辑次数，如 ' ' 需要 3 次编辑才能变成 ' xxx'。
    for (let i = 0; i < n; i++) {
        dp[i][0] = i;
    }
    // 初始化 dp 第一行的编辑次数，如 ' xxx' 需要经过 3 次编辑才能变成 ' '。
    for (let j = 0; j < m; j++) {
        dp[0][j] = j;
    }

    for (let i = 1; i < n; i++) {
        for (let j = 1; j < m; j++) {
            // 若 str1 的第 i 位可以匹配 str2 的第 j 位，那么其编辑次数就等于
            // str1 的前 i - 1 位 与 str2 的前 j - 1 位的编辑次数。
            if (str1[i] === str2[j]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                // 若 str1 的第 i 位不匹配 str2 的第 j 位，那么其编辑次数有三种情况:
                // 1. str1 的前 i 位与 str2 的前 j - 1 位的编辑次数, 加上添加 str2 的第 j 位字符于 str1 的操作，即 dp[i][j - 1] + 1
                // 2. str1 的前 i - 1 位与 str2 的前 j 位的编辑次数, 加上将 str1 的第 i 位字符删除的操作，即 dp[i - 1][j] + 1
                // 3. str1 的前 i - 1 位与 str2 的前 j - 1位的编辑次数，加上将 i 位字符替换成 j 位字符的操作，即 dp[i - 1][j - 1] + 1
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
            }
        }
    }

    return dp[n - 1][m - 1];
};

