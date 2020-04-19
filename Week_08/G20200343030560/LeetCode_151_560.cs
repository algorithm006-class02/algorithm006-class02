using System;
using System.Collections.Generic;
using System.Text;

namespace Test
{
    class LeetCode_151_560
    {
        public string ReverseWords(string s)
        {
            s = s.Trim();
            var wordList = s.Split(" ");
            var reversList = wordList.Reverse();
            return string.Join(" ", reversList.Where(r => !string.IsNullOrEmpty(r)));

        }
    }
}
