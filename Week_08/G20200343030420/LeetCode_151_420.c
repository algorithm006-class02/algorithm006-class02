char * reverseWords(char * s) {
    if (!s)
        return s; 
    int i, start = 0, pos = 0, len = strlen(s), spacePos = len;  
    for (i = 0; i < len; i++) 
        if (' ' != s[i]) {
            start = i; 
            break; 
        }
    char *res = calloc(len + 1, sizeof(char)); 
    for (i = len - 1; i >= start - 1; i--) {
        if ((i == start - 1) || (s[i] == ' ')) {
            if (spacePos == i + 1) {
                spacePos = i; 
                continue; 
            } 
            strncpy(res + pos, s + i + 1, spacePos - i - 1); 
            pos += spacePos - i - 1; 
            if (i == start - 1)
                break; 
            res[pos++] = ' '; 
            spacePos = i; 
        }
    }
    strncpy(s, res, pos); 
    if (pos < len)
        s[pos] = '\0'; 
    free(res); 
    return s; 
}
