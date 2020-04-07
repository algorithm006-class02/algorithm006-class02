char * reverseOnlyLetters(char * s) {
    if (!s)
        return s; 
    int i, pos = 0, len = strlen(s); 
    char *st = calloc(len, sizeof(char)); 
    strncpy(st, s, len); 
    char *res = calloc(len, sizeof(char)); 
    for (i = len - 1; i >= 0; i--) 
        if (isalpha(st[i])) 
            res[pos++] = st[i]; 

    pos = 0; 
    for (i = 0; i < len; i++) 
        if (isalpha(st[i])) 
            st[i] = res[pos++]; 

    strncpy(s, st, len); 
    free(st); 
    free(res); 
    return s; 
}
