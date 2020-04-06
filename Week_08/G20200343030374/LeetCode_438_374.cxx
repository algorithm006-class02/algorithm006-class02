// https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/

#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution
{
public:
  vector<int> findAnagrams(string s, string p)
  {
    unordered_map<char, int> counts;
    unordered_map<char, int> window;
    for (char c : p)
      counts[c]++;
    int left = 0, right = 0;
    int match = 0;
    vector<int> ans;
    while (right < s.size())
    {
      char c1 = s[right];
      if (counts.count(c1))
      {
        window[c1]++;
        if (window[c1] == counts[c1])
          match++;
      }
      right++;
      while (match == counts.size())
      {
        if (right - left == p.size())
          ans.push_back(left);
        char c2 = s[left];
        if (counts.count(c2))
        {
          window[c2]--;
          if (window[c2] < counts[c2])
            match--;
        }
        left++;
      }
    }
    return ans;
  }
};