import java.util.*;

public class LeetCode_1244_600 {
    private TreeMap<Integer, Integer> map;

    public LeetCode_1244_600() {
        map = new TreeMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        int ans = 0;
        List<Integer> list = new LinkedList<>(map.values());
        Collections.sort(list, Comparator.comparingInt(x -> -x));
        for (int i = 0; i < K; i++) {
            ans += list.get(i);
        }
        return ans;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}
