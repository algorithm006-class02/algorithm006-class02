class Solution {
    //构建映射组合
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();

    public void backtrack(String combina, String next_data) {
        if (next_data.length() == 0) {
            output.add(combina);
        } else {
            String new_next = next_data.substring(0, 1);
            String letters = map.get(new_next);
            for (int i = 0; i < letters.length(); i++) {
                String letter = map.get(new_next).substring(i, i + 1);
                backtrack(combina + letter, next_data.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) backtrack("", digits);
        return output;
    }
}