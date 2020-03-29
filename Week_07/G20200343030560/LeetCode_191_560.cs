using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
    public class LeetCode_191_560
    {
        public int HammingWeight(uint n)
        {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++)
            {
                if ((n & mask) != 0)
                {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }
}
