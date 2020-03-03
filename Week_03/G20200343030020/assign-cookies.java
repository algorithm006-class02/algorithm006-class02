class Solution {
    public int findContentChildren(int[] children, int[] cookie) {
        Arrays.sort(children);
        Arrays.sort(cookie);
        int child = 0;
        for (int cooki = 0; child < children.length && cooki < cookie.length; cooki++) {
            if (cookie[cooki] >= children[child]) child++; //饼干必须是大于等于，才能满足小朋友
        }
        return child;
    }
}
