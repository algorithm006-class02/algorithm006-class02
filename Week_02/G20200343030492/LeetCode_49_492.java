package Week_02.G20200343030492;

/**
 * LeetCode_49_492
 */
public class LeetCode_49_492 {

	/**
	 *  整体思路：字母计数法，使用数组来保存字符串各字母出现的次数。时间复杂度：O(n * k)，n是字符串个数，k是字符串数组中最大的字符串长度。空间复杂度：O(n * k)
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return new ArrayList<>();
        Map<String,List> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append(i).append('#');
            }
            String key;
            if (!map.containsKey((key = sb.toString()))) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
	}
	
	/**
	 * 整体思路：对每个字符串排序后来判断。时间复杂度：O(n * klogk)，n是字符串个数，k是字符串数组中最大的字符串长度。空间复杂度：O(n * k)。
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return new ArrayList<>();
        Map<String,List> map = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}