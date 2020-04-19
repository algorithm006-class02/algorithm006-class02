uint32_t reverseBits(uint32_t n) {
    uint32_t res = 0; 
    for (int i = 0; i < 32; i++) {
        if (n & 1) 
            res |= (uint32_t)1 << (31 - i); 
        n >>= 1; 
    }
    return res; 
}
uint32_t reverseBits_2(uint32_t n) {
    uint32_t ans = 0;
    for (int i = 0; i < 32; i++){
        ans <<= 1;
        ans += (n & 1);
        n >>= 1;
    }
    return ans;
}
