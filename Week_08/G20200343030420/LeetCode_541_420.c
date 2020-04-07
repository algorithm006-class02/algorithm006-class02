void reverse(char *s, int start, int end) {
    char temp; 
    while (start < end) {
        temp = s[start]; 
        s[start] = s[end]; 
        s[end] = temp; 
        start++; 
        end--; 
    }
}
char * reverseStr(char * s, int k) {
    if (!s)
        return s; 
    int i, len = strlen(s); 
    char *as = calloc(len + 1, sizeof(char)); 
    strncpy(as, s, len); 
    for (i = 0; i < len; i += 2 * k) {
        if (i + k < len) 
            reverse(as, i, i + k - 1); 
        else 
            reverse(as, i, len - 1); 
    }
    strncpy(s, as, len); 
    free(as); 
    return s; 
}
