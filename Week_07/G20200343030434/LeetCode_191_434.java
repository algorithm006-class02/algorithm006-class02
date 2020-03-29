public int hammingWeight(int n) {
    int count = 0;
    int data = 1;
    for (int i = 0; i < 32; i++) {
        if ((n & data) != 0) {
            count++;
        }
        data <<= 1;
    }
    return count;
}

