class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();
        if (pc.length > sc.length) {
            return list;
        }
        int[] tableP = new int[26];
        int[] tableC = new int[26];
        for (int i = 0; i < pc.length; i++) {
            tableP[pc[i] - 'a']++;
            tableC[sc[i] - 'a']++;
        }
        if (equals(tableC, tableP)) {
            list.add(0);
        }
        for (int i = 1; i + pc.length - 1 < sc.length; i++) {
            tableC[sc[i - 1] - 'a']--;
            tableC[sc[i + pc.length - 1] - 'a']++;
            if (equals(tableC, tableP)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}