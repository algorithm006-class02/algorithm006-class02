class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>(k);
        for (int i = 1; i < k + 1; i++) {
            first.add(i);
        }
        result.add(first);
        combine(n, k + 1, result);
        return result;
    }

    private void combine(int n, int tmp, List<List<Integer>> list) {
        if (tmp > n) {
            return;
        } else {
            List<List<Integer>> tmpList = new ArrayList<>();
            tmpList.addAll(generatNewList(list, tmp));
            list.addAll(tmpList);
            combine(n, tmp + 1, list);
        }
    }

    private List<List<Integer>> generatNewList(List<List<Integer>> list, int number) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> l : list) {
            for (int i = 0; i < l.size(); i++) {
                Integer currentReplaceNumber = l.get(i);
                List<Integer> nl = new ArrayList<>(l);
                nl.remove(i);
                nl.add(number);
                set.add(nl);
            }
        }
        result.addAll(set);
        return result;
    }
}
