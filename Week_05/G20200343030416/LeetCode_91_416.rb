=begin
题目描述：
	一条包含字母 A-Z 的消息通过以下方式进行了编码：
	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26

	给定一个只包含数字的非空字符串，请计算解码方法的总数。
=end


#解法一、动态规划
def num_decodings(s)
    return 0 if s[0] == '0' || s.empty? || s.nil?
    dp = Array.new(s.length)
    #注意初始化，这个dp[-1]会在译码合法时启用，当i下标的译码合法，且i为1时，dp[1 - 2] = dp[-1]的值始终是-1
    dp[-1], dp[0] = 1, 1
    for i in 1...s.length
    	#s[i]为0的情况
        if s[i] == '0' 
            if s[i - 1] == '1' || s[i - 1] == '2'
                dp[i] = dp[i - 2]
            else
                return 0 #因为无论是组合译码还是分开译码均不合法，故返回0
            end
        else #s[i]不为0的情况
            if s[i - 1] == '1' || (s[i - 1] == '2' && '1' <= s[i] && s[i] <= '6')
                dp[i] = dp[i - 1] + dp[i - 2]
            else #其他情况
                dp[i] = dp[i - 1]
             end
        end
    end
    return dp[s.length - 1]
end
