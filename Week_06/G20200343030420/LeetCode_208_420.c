#define ALPHA_LENGTH    (26) 
typedef struct _Trie {
    struct _Trie *next[ALPHA_LENGTH]; 
    int endFlag; 
} Trie;

/** Initialize your data structure here. */
Trie* trieCreate() {
    Trie *root = calloc(1, sizeof(Trie)); 
    return root; 
}

/** Inserts a word into the trie. */
void trieInsert(Trie* obj, char * word) {
    Trie *curr = obj; 
    for (int i = 0; '\0' != word[i]; i++) {
        if (!curr->next[word[i] - 'a']) 
            curr->next[word[i] - 'a'] = trieCreate(); 
        curr = curr->next[word[i] - 'a']; 
    }
    curr->endFlag = 1; 
}

/** Returns if the word is in the trie. */
bool trieSearch(Trie* obj, char * word) {
    Trie *curr = obj; 
    for (int i = 0; '\0' != word[i]; i++) {
        if (!curr->next[word[i] - 'a'])
            return false; 
        curr = curr->next[word[i] - 'a']; 
    }
    return ((curr->endFlag) ? true : false); 
}

/** Returns if there is any word in the trie that starts with the given prefix. */
bool trieStartsWith(Trie* obj, char * prefix) { 
    Trie *curr = obj; 
    for (int i = 0; '\0' != prefix[i]; i++) {
        if (!curr->next[prefix[i] - 'a'])
            return false; 
        curr = curr->next[prefix[i] - 'a']; 
    }
    return true; 
}

void trieFree(Trie* obj) {
    if (!obj) 
        return; 
    for (int i = 0; i < ALPHA_LENGTH; i++) 
        trieFree(obj->next[i]); 
    free(obj);  
}

/**
 * Your Trie struct will be instantiated and called as such:
 * Trie* obj = trieCreate();
 * trieInsert(obj, word);
 
 * bool param_2 = trieSearch(obj, word);
 
 * bool param_3 = trieStartsWith(obj, prefix);
 
 * trieFree(obj);
*/
