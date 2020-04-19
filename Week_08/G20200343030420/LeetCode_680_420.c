bool div(char *s, int l, int r) {
    while (l < r) 
        if (s[l++] != s[r--]) 
            return false; 
    return true;  
}
bool validPalindrome(char * s) {
    int l, r, l1, r1; 
    for (l = 0, r = strlen(s) - 1; l < r; l++, r--) 
        if (s[l] != s[r]) 
            return div(s, l + 1, r) || div(s, l, r - 1); 
    return true; 
}
