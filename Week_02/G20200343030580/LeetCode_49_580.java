class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sortedString = sortedString(s);
            List<String> list = map.get(sortedString);
            if (list == null) {
                list = new ArrayList<>();
                map.put(sortedString, list);
            }
            list.add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    private String sortedString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}