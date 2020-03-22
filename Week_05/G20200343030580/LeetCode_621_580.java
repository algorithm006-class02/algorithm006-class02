class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int time = (map[25] - 1) * (n + 1);
        for (int i = 25; i > -1; i--) {
            if (map[i] == map[25]) {
                time++;
            } else {
                break;
            }
        }
        return Math.max(time, tasks.length);
    }
}