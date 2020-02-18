int* plusOne(int* digits, int digitsSize, int* returnSize) {
    if ((NULL == digits) || (0 == digitsSize)) {
        *returnSize = 0; 
        return NULL; 
    } 
    int *output = calloc(digitsSize + 1, sizeof(int)); 
    int i = digitsSize - 1; 
    memcpy(output, digits, digitsSize * sizeof(int)); 
    *returnSize = digitsSize; 
    while (i >= 0) {
        output[i] = (digits[i] + 1) % 10; 
        if (0 != output[i])
            return output; 
        else {
            if (0 == i) {
                memset(output + 1, 0, digitsSize * sizeof(int)); 
                output[0] = 1; 
                *returnSize += 1; 
                return output; 
            }
            i--; 
        }
    }
    return NULL; 
}
