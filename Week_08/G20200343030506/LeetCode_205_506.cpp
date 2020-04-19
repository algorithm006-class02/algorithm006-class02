/*
 * @lc app=leetcode.cn id=205 lang=cpp
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution 
{
public:
	bool isIsomorphic(string s, string t) 
	{
		char c1, c2;
		int flag = 0;
		int i, j;
		if (s.size()==0) return true;
		while (flag < s.size())
		{
			if (s[flag] == '*')
			{
				flag++;
				continue;
			}
			i = flag;
			j = flag;
			c1 = s[i];
			c2 = t[i];
			while (i < s.size())
			{
				if ((s[i] != c1) && (t[i] != c2))
					i++;
				else
					if ((s[i] != c1)&&(t[i] == c2))
						return false;
					else
					{
						j = i;
						if (t[j] == c2)
						{
							t[j] = '*';
							s[i] = '*';
							i++;
						}
						else
							return false;
					}

			}
			flag++;
		}
		return true;
	}
};
// @lc code=end

