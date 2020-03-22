class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet(Arrays.asList(bank));
        if (bankSet.contains(end) == false) {
            return -1;
        }
        char[] gs = {'A', 'C', 'G', 'T'};
        Set<String> startSet = new HashSet(), endSet = new HashSet<>(), visited = new HashSet<>();
        int step = 0;
        startSet.add(start);
        endSet.add(end);
        while (startSet.isEmpty() == false && endSet.isEmpty() == false) {
            if (startSet.size() < endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = startSet;
            }
            Set<String> tmp = new HashSet<>();
            for (String gen : startSet) {
                char[] gcs = gen.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char oldc = gcs[i];
                    for (char newc : gs) {
                        if (oldc == newc) {
                            continue;
                        }
                        gcs[i] = newc;
                        String newg = new String(gcs);
                        if (endSet.contains(newg)) {
                            return step + 1;
                        }
                        if (bankSet.contains(newg) && visited.contains(newg) == false) {
                            visited.add(newg);
                            tmp.add(newg);
                        }
                    }
                    gcs[i] = oldc;
                }
            }
            startSet = tmp;
            step++;
        }
        return -1;
    }
}
