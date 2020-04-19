class Solution {
    HashMap<Integer,Integer> store = new HashMap<Integer,Integer>();
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n < 3) return n;
        if (store.containsKey(n)){
            return store.get(n);
        }
        int steps = climbStairs(n - 1) + climbStairs(n - 2);
        store.put(n,steps);
        return steps;
    }
}