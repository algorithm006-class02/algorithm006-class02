/* */ 
void quickSortString(char* array, int left, int right) { 
	char temp = array[left];
    int l = left, r = right; 
	if (left >= right) {
		return;
	} 
	while (l < r) {
		while (l < r && array[r] >= temp) {
			r--;
		}
		if (l < r) {
			array[l] = array[r];
		}
		while (l < r && array[l] <= temp) {
			l++;
		}
		if (l < r) {
			array[r] = array[l];
		}
	}
	array[l] = temp;
	quickSortString(array, left, l - 1);
	quickSortString(array, l + 1, right);
}
bool isAnagram(char * s, char * t) {
    if ((!s) || (!t)) 
        return false; 
    if (strlen(s) != strlen(t)) 
        return false; 
    quickSortString(s, 0, strlen(s) - 1); 
    quickSortString(t, 0, strlen(t) - 1); 
    return ((0 == strcmp(s, t)) ? true : false);  
}
bool isAnagram_2(char * s, char * t){
    int i = 0, sLen = strlen(s), tLen = strlen(t);
    if (sLen != tLen)
        return false; 

    int *cnt = calloc(26, sizeof(int));
    for (i = 0; i < sLen; i++) {
        cnt[s[i] - 'a']++;
        cnt[t[i] - 'a']--;
    }
    for (i = 0; i < 26; i++)
        if (0 != cnt[i])
            return false;
    return true;
}
