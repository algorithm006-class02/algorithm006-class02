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
char * reverseWords(char * s) {
    if (!s)
        return s; 
    int len = strlen(s), start = 0;  
    char *res = calloc(len + 2, sizeof(char)), *p = NULL; 
    strncpy(res, s, len); 
    res[len] = ' '; 
    while (1) {
        p = strchr(res + start, ' '); 
        if (!p)
            break; 
        reverse(res, start, p - res - 1); 
        start += p - res - start + 1; 
    }
    res[len] = '\0'; 
    strncpy(s, res, len); 
    free(res); 
    return s; 
}
