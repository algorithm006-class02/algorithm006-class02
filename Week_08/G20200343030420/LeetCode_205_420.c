bool isIsomorphic(char * s, char * t) {
    if ((!s) && (!t)) 
        return true; 
    if ((!s) || (!t)) 
        return false; 
    int i, len = strlen(s); 
    if (len != strlen(t))
        return false; 
    int *sa = calloc(128, sizeof(int)); 
    int *ta = calloc(128, sizeof(int)); 
    for (i = 0; i < len; i++) {
        if ((0 == sa[s[i]]) && (0 == ta[t[i]])) {
            sa[s[i]] = i + 1; 
            ta[t[i]] = i + 1; 
        }
        else if (sa[s[i]] != ta[t[i]]) 
            return false; 
    } 
    free(sa); 
    free(ta); 
    return true; 
}
