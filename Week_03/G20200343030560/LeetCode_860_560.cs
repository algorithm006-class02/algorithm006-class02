using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
    public class LeetCode_860_560
    {
        public static bool LemonadeChange(int[] bills)
        {
            int five = 0; int ten = 0;
            foreach (var item in bills)
            {
                if (item == 5)
                {
                    five++;
                }
                if (item == 10)
                {
                    if (five == 0)
                        return false;
                    else
                    {
                        ten++;
                        five--;
                    }
                }
                if (item == 20)
                {
                    if (five > 0 && ten > 0)
                    {
                        five--;
                        ten--;
                    }
                    else if (five >= 3)
                    {
                        five -= 3;
                    }
                    else
                    {
                        return false;
                    }
                }

            }
            return true;
        }
    }
}
