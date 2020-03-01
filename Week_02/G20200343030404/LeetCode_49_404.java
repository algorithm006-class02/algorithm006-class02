class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> codeMap = new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        String code = null;
        for(String str : strs) {
            code = getCode(str);
            if (!codeMap.containsKey(code)) {
                codeMap.put(code, new LinkedList<String>());
                result.add(codeMap.get(code));
            }
            codeMap.get(code).add(str);
        }

        return result;
    }

    private String getCode(String str) {
        int[] charCount = new int[26];
        char[] chars = str.toCharArray();
        for(char c : chars) {
            charCount[c - 97] = ++ charCount[c - 97]; // 此处注意++的位置 放后面就坑了
        }
        String result = null;
        for(int i = 0 ; i < charCount.length ; i ++) {
            if (charCount[i] > 0) {
                result += i + "-" + charCount[i] + "-";
            }
        }
        return result;
    }
}