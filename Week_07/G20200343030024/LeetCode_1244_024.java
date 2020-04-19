class Leaderboard {
    private TreeMap<Integer, Integer> map;

    public Leaderboard() {
        map = new TreeMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        int ans = 0;
        List<Integer> list = new LinkedList<>(map.values());
        Collections.sort(list, (n1, n2) -> n2 - n1 > 0 ? 1 : n2 == n1 ? 0 : -1);
        for (int i = 0; i < K; i++) {
            ans += list.get(i);
        }
        return ans;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }

}