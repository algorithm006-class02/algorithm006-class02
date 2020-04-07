=begin
题目描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
=end

#解法一、动态规划
def longest_palindrome(s)
    len = s.length
    return s if len < 2

    dp = Array.new(len) {[] * len}
    for i in 0...len
        dp[i][i] = true
    end

    max_len = 1
    start = 0

    for j in 1...len
        i = j - 1
        while i >= 0
            if s[i] == s[j]
                if (j - i) < 3
                    dp[i][j] = true
                else
                    dp[i][j] = dp[i + 1][j - 1]
                end
            else
                dp[i][j] = false
            end
            if dp[i][j]
                cur_len = j - i + 1
                if cur_len > max_len
                    max_len = cur_len
                    start = i
                end
            end
            i -= 1
        end
    end
    return s[start...start + max_len]
end
