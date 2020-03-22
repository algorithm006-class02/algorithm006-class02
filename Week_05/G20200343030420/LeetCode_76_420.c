#define MIN_VAL     (-50000)
/* 用两个hash表应该更好理解 */ 
char * minWindow(char * s, char * t) {
    if ((!s) || (!t) || (strlen(s) < strlen(t))) 
        return ""; 
    char *resStr = NULL; 
    int l, r, sLen = strlen(s), tLen = strlen(t), match = 0, cnt = 0;
    int start, minLen = sLen + 1; 
    int hash[128]; 
    for (l = 0; l < 128; l++) 
        hash[l] = MIN_VAL; 
    for (l = 0; l < tLen; l++) {
        hash[t[l]] = (MIN_VAL == hash[t[l]]) ? 1 : (hash[t[l]] + 1); 
        match++; 
    }

    l = 0; 
    r = 0; 
    while (r < sLen) {
        if (hash[s[r]]-- > 0) 
            cnt++; 
        r++; 

        while (match == cnt) {            
            if (r - l < minLen) {
                /* 找到更小长度的符合要求的子串，记录位置和长度 */ 
                start = l; 
                minLen = r - l; 
            } 
            hash[s[l]]++; 
            if (hash[s[l]] > 0)                 
                cnt--; 
            l++; 
        }
    }
    if (minLen != (sLen + 1)) {
        resStr = calloc(minLen + 1, sizeof(char)); 
        strncpy(resStr, s + start, minLen); 
        return resStr; 
    }
    return ""; 
}
