import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    //BFS
    public int minMutation1(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if(!set.contains(end)) {
            return -1;
        }
        char[] four = {'A','C','G','T'};
        Queue <String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while(queue.size() > 0) {
            step++;
            for(int count = queue.size(); count > 0; --count) {
                char[] tempStringChars = queue.poll().toCharArray();
                for(int i = 0, len = tempStringChars.length; i < len; ++i) {
                    char oldchar = tempStringChars[i];
                    for(int j = 0; j < 4; ++j) {
                        tempStringChars[i] = four[j];
                        String newGeneric = new String(tempStringChars);
                        if(end.equals(newGeneric)) {
                            return step;
                        } else if (set.contains(newGeneric)) {
                            set.remove(newGeneric);
                            queue.offer(newGeneric);
                        }
                    }
                    tempStringChars[i] = oldchar;
                }
            }
        }
    return -1;
    }

    public int minMutation2(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        for(String b: bank) {
            bankSet.add(b);
        }
        char[] charSet = new char[]{'A','C','G','T'};
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) {
                    return level;
                }
                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c : charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        HashSet<String> startSet = new HashSet<String>();
        startSet.add(start);
        HashSet<String> endSet = new HashSet<String>();
        endSet.add(end);
        HashSet<String> tempNewSet = new HashSet<>();
        int step = 0;
        while (startSet.size() > 0 && endSet.size() > 0) {
            step++;
            if (startSet.size() > 0 && endSet.size() > 0) {
                HashSet<String> temp = new HashSet<>(startSet);
                startSet = endSet;
                endSet = temp;
            }

            for (String item : startSet) {
                char[] tempStringChars = item.toCharArray();
                for (int i = tempStringChars.length - 1; i >= 0; --i) {
                    char oldchar = tempStringChars[i];
                    for (int j = 0; j < 4; j++) {
                        tempStringChars[i] = four[j];
                        String newStr = new String(tempStringChars);
                        if (endSet.contains(newStr)) {
                            return step;
                        } else if (set.contains(newStr)) {
                            set.remove(newStr);
                            tempNewSet.add(newStr);
                        }
                    }
                    tempStringChars[i] = oldchar;
                }
            }
            startSet = new HashSet<>(tempNewSet);
            tempNewSet.clear();
        }
        return -1;
    }
}
// @lc code=end

