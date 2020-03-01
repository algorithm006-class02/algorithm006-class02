=begin
  题目描述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
  示例：输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
  输出：
  [
    ["ate","eat","tea"],
    ["nat","tan"],
    ["bat"]
  ]
=end


#解法一、用字母构建哈希表
def group_anagrams(strs)
  h = {}
  return [] if strs.length == 0
  #循环遍历字符串数组，将字符串元素的字符数组排序后，作为哈希表的key
  for s in strs
    h[s.chars.sort] = [] if !h.has_key?(s.chars.sort)
  #将key为相应的字符数组的字符串，添加到相应的value中
    h[s.chars.sort].push(s)
  end
  #返回所有value，即为所有的字母异位词组合
  return h.values
end