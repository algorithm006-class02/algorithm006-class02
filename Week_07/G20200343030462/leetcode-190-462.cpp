class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t result = 0;
        for(int i = 0; i <= 31; ++i)
        {
            //将n的每一位取出来
            uint32_t tmp = n >> i;
            //取i位的二进制位
            tmp = tmp & 1;
            //将i位的二进制位移动到31-i位置上完成交换
            tmp = tmp << (31 -i);
            //将结果这一个二进制bit合并到最终的结果上
            result |= tmp;
        }
        
        return result;
    }
};
