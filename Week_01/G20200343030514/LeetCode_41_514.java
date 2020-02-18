ass Solution {
    public int firstMissingPositive(int[] nums) {
        
        int maxPositiveInt = 0;
        
        for (int num : nums) {
            if (num > maxPositiveInt) {
                maxPositiveInt = num;    
            }
        }
        
        // the size of records is the most important thing
        // 其实不必标记所有的可能数字，只需要记录nums.length的即可，对于大于nums.length的数字直接丢弃
        // 如果length内数字连续，那丢失的比如为连续数字的下一个
        // 如果length内的数字有缺失，则缺失数字必然在length内 e.g. 1,2,3,6,99 length=5, 第一个丢失的数据为4
        int[] records = new int[nums.length];
            
        
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                // 将数字n存在records的第n-1个位置上
                records[num - 1] = 1;
            }
        }
            
        for (int i = 0; i < records.length; i++) {
            
            if (records[i] == 0) {
                return i + 1;
            }
        }
        
        return maxPositiveInt + 1;
        
    }
}
