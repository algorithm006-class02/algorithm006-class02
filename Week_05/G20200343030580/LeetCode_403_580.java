class Solution {
    public boolean canCross(int[] stones) {
        Set<Integer> set = new HashSet<>(stones.length);
        for (int stone : stones) {
            set.add(stone);
        }
        Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();
        return canCross(0, 1, stones[stones.length - 1], set, cache);
    }

    private boolean canCross(int current, int step, int end, Set<Integer> set, Map<Pair<Integer, Integer>, Boolean> cache) {
        Pair<Integer, Integer> key = new Pair<>(current, step);
        Boolean cacheValue = cache.get(key);
        if (cacheValue != null) {
            return cacheValue;
        }
        int next = current + step;
        if (next == end) {
            cache.put(key, true);
            return true;
        }
        if (set.contains(next) == false) {
            cache.put(key, false);
            return false;
        }
        boolean result = false;
        if (step == 1) {
            result = canCross(next, step, end, set, cache) ? true : canCross(next, step + 1, end, set, cache);
        } else {
            result = canCross(next, step - 1, end, set, cache) ? true : canCross(next, step, end, set, cache) ? true : canCross(next, step + 1, end, set, cache);
        }
        cache.put(key, result);
        return result;
    }
}
