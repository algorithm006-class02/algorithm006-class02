
import collections

class Solution:


    def groupAnagrams(self, strs) :
        """

        :param strs:
        :return:
        """
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return ans.values()

