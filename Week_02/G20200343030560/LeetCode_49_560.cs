using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MaxArea
{
    public class LeetCode_49_560
    {
        public IList<IList<string>> GroupAnagrams(string[] strs)
        {
            IList<IList<string>> list = new List<IList<string>>();
            var flagList = new List<string>();
            for (var i = 0; i < strs.Length; i++)
            {
                var arry = new List<string>();
                for (var j = i; j < strs.Length; j++)
                {
                    if (IsAnagram(strs[i], strs[j]))
                    {
                        if (!flagList.Contains(strs[i]))
                        {
                            arry.Add(strs[i]);
                            flagList.Add(strs[i]);
                        }
                        if (!flagList.Contains(strs[j]))
                        {
                            arry.Add(strs[j]);
                            flagList.Add(strs[j]);
                        }
                        if (strs[j].Equals(strs[i]) && i != j)
                            arry.Add(strs[j]);
                    }
                }
                if (arry.Count != 0)
                    list.Add(arry);
            }
            return list;
        }

        public static bool IsAnagram(string s, string t)
        {
            var dict = new Dictionary<string, int>();
            for (var i = 0; i < s.Length; i++)
            {
                if (dict.TryGetValue(s[i].ToString(), out int v))
                {

                    dict[s[i].ToString()] = v + 1;
                }
                else
                {
                    dict[s[i].ToString()] = 1;
                }
            }
            for (var i = 0; i < t.Length; i++)
            {
                if (dict.TryGetValue(t[i].ToString(), out int v))
                {
                    dict[t[i].ToString()] = v - 1;
                    if (dict[t[i].ToString()] == 0)
                    {
                        dict.Remove(t[i].ToString());
                    };
                }
                else
                {
                    return false;
                }
            }
            return !dict.Any();
        }
    }
}
