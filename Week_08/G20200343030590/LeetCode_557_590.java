public class LeetCode_557_590 {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(new StringBuffer(strArr[i]).reverse().toString() + " ");
        }
        return sb.toString().trim();
    }
}
