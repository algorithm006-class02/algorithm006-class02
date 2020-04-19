//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //endWord也是transformed word, 所以必须存在于wordList中, 否则返回0, 表示无法从beginWord变成endWord
        if(!wordList.contains(endWord))
            return 0;
        //
        int n = beginWord.length();
        //key是通用状态; value是拥有该通用状态的词
        HashMap<String,ArrayList<String>>all_commons = new HashMap<>();
        //记录wordList中所有元素对应的所有通用状态
        wordList.forEach(
                word->{
                    for(int i=0; i<n; i++){
                        String common = word.substring(0,i)+"*"+word.substring(i+1);
                        if(!all_commons.containsKey(common))
                            all_commons.put(common, new ArrayList<String>());
                        all_commons.get(common).add(word);
                    }
                }
        );
        //使用HashSet实现宽度优先遍历bfs
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        //记录访问过的节点
        HashSet<String> visited = new HashSet<>();
        //细节: 返回值的初始化, 由于beginWord!=endWord, 所以至少需要一步变化
        int len = 1;
        while(!begin.isEmpty() && !end.isEmpty()){
            //核心:控制当前循环从哪个方向进行bfs; 让begin指向size更小的集合, 这样就不会一直从一个方向bfs了
            if(begin.size()>end.size()){
                HashSet<String> tmp = begin;
                begin = end;
                end = tmp;
            }
            //记录遍历begin时每个元素的邻居, 也就是cur的邻居
            HashSet<String> neighbor = new HashSet<>();
            for(String cur : begin){
                //遍历cur的邻居
                for(int i=0; i<n; i++){
                    String tmp = cur.substring(0,i)+"*"+cur.substring(i+1);
                    //有了all_commons哈希表,就不用每个位置都遍历'a'~'z'了
                    //细节:如果cur是beginWord的话, all_commons没有统计beginWord的通用状态, 所以all_commons.get(tmp)可能返回null, 所以要提前检查一下
                    if(!all_commons.containsKey(tmp))
                        continue;
                    for(String str : all_commons.get(tmp)){
                        if(end.contains(str))
                            return len+1;
                        if(!visited.contains(str)){
                            visited.add(str);
                            //记录cur的邻居
                            neighbor.add(str);
                        }
                    }
                }
            }
            //处理完begin中的元素后, 让begin指向begin中的元素的邻居
            begin = neighbor;
            //路径长度++
            len++;
        }
        //执行到这里说明双向bfs没有相遇, 也就是没有找到从beginWord到endWord的路径
        return 0;
    }
}

