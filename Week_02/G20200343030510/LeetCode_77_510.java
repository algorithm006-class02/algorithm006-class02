import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> list2 = new ArrayList();
        for (int i=0; i<k; i++){
            list2.add(0);
        }
        int i = 0;
        while (i >= 0){
            list2.set(i,list2.get(i)+1);
            if (list2.get(i) > n){
                i--;
            } else if (i == k-1){
                list.add(new ArrayList(list2));
            } else {
                i++;
                list2.set(i,list2.get(i-1));
            }
        }
        return list;
    }
}
