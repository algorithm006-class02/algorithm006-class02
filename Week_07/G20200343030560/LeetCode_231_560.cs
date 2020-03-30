using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
    public class LeetCode_231_560
    {
        public bool IsPowerOfTwo(int n)
        {
            if (n == 0) return false;
            while (n % 2 == 0) n /= 2;
            return n == 1;
        }
    }
}
