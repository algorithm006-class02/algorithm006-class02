using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
    class LeetCide_541_560
    {
        public string ReverseStr(string s, int k)
        {
            char[] a = s.ToCharArray();
            for (int start = 0; start < a.Length; start += 2 * k)
            {
                int i = start, j = Math.Min(start + k - 1, a.Length - 1);
                while (i < j)
                {
                    char tmp = a[i];
                    a[i++] = a[j];
                    a[j--] = tmp;
                }
            }
            return new String(a);

        }
    }
}
