class Solution {
    
    // BFS
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int[] cache = new int[amount + 1];
        
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        int level = 0;
        int size = queue.size();
        // 加cache做bfs的剪枝，如果一个节点在之前出现过，则不需要再次加入计算，因为再计算只可能大于等于之前的层数
        cache[amount] = 1;
        while(!queue.isEmpty()) {
            int item = queue.poll();
            size--;
            
            for (int coin : coins) {
                if (item == coin) {
                    return level + 1;        
                }
                if (item > coin) {
                    if (cache[item - coin] > 0) {
                        continue;    
                    } else {
                        queue.offer(item - coin);
                        cache[item - coin] = 1;
                    }
                }
            }
            
            if (size == 0) {
                size = queue.size();
                level++;
            }
        }
        return -1;
        
    }
}
