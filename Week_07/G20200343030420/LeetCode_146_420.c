typedef struct _DoubleListNode {
    int key; 
    int value; 
    struct _DoubleListNode  *prev; 
    struct _DoubleListNode  *next; 
} DLNode; 

typedef struct _hashNode {
    DLNode  dlnode; 
    struct _hashNode    *hnext; 
} hashNode; 

typedef struct {
    int currNum; 
    int capacity; 
    DLNode  *head; 
    DLNode  *tail; 
    hashNode    *bucket;  
} LRUCache;

#define HASH_FUNC(key)  ((key) % obj->capacity)

LRUCache* lRUCacheCreate(int capacity) {
    LRUCache *obj = calloc(1, sizeof(LRUCache)); 
    obj->currNum    = 0; 
    obj->capacity   = capacity; 
    obj->head   = calloc(1, sizeof(DLNode)); 
    obj->tail   = calloc(1, sizeof(DLNode)); 
    obj->head->next = obj->tail; 
    obj->tail->prev = obj->head; 
    obj->bucket = calloc(capacity, sizeof(hashNode)); 
    return obj; 
}

void lRUCacheAdd(LRUCache* obj, DLNode *node) {
    //始终加在双向链表尾部
    node->next = obj->tail; 
    node->prev = obj->tail->prev; 
    obj->tail->prev->next = node; 
    obj->tail->prev = node; 
}
void lRUCacheDel(LRUCache* obj, DLNode *node) {
    //有head和tail，所以不必考虑边界情况
    node->prev->next = node->next; 
    node->next->prev = node->prev; 
} 
void lRUCacheAddMoveToTail(LRUCache* obj, DLNode *node) {
    lRUCacheDel(obj, node); 
    lRUCacheAdd(obj, node); 
} 
void lRUCacheAddPopHead(LRUCache* obj) {
    lRUCacheDel(obj, obj->head->next); 
} 
int lRUCacheGet(LRUCache* obj, int key) {
    hashNode *p = obj->bucket[HASH_FUNC(key)].hnext; 
    while (p) {
        if (key == p->dlnode.key) {
            lRUCacheAddMoveToTail(obj, &p->dlnode); 
            return p->dlnode.value; 
        } 
        p = p->hnext; 
    } 
    return -1; 
}
void lRUCachePut(LRUCache* obj, int key, int value) {
    //先在hash表中查找 
    hashNode *pp = &(obj->bucket[HASH_FUNC(key)]), *p = pp->hnext; 
    while (p) {
        if (p->dlnode.key == key) {
            p->dlnode.value = value; 
            break; 
        } 
        pp = p; 
        p = pp->hnext; 
    }

    //pp始终是p的prev
    if (p) {
        lRUCacheAddMoveToTail(obj, &p->dlnode);  
    } 
    else {
        //未找到，p指向新建结点
        if (obj->currNum == obj->capacity) {
            hashNode *delpp = &(obj->bucket[HASH_FUNC(obj->head->next->key)]); 
            p = delpp->hnext; 
            while (p) {
                if (p->dlnode.key == obj->head->next->key) {
                    break; 
                } 
                delpp = p; 
                p = delpp->hnext;  
            }
            delpp->hnext = p->hnext; 
            lRUCacheAddPopHead(obj); 
            obj->currNum--; 
        } 
        p = calloc(1, sizeof(hashNode)); 
        p->dlnode.key = key; 
        p->dlnode.value = value; 
        lRUCacheAdd(obj, &p->dlnode); 
        //pp必须重新获取，有可能前面已经删掉了
        pp = &(obj->bucket[HASH_FUNC(key)]); 
        p->hnext = pp->hnext; 
        pp->hnext = p; 
        obj->currNum++; 
    }
}

void lRUCacheFree(LRUCache* obj) {
    hashNode *h, *hn; 
    for (int i = 0; i < obj->capacity; i++) {
        h = obj->bucket[i].hnext; 
        while (h) {
            hn = h->hnext; 
            free(h); 
            h = hn; 
        }
    }
    free(obj->bucket); 
    free(obj->head); 
    free(obj->tail); 
    free(obj); 
}

/**
 * Your LRUCache struct will be instantiated and called as such:
 * LRUCache* obj = lRUCacheCreate(capacity);
 * int param_1 = lRUCacheGet(obj, key);
 
 * lRUCachePut(obj, key, value);
 
 * lRUCacheFree(obj);
*/
void lru_print(LRUCache *obj) {
    int i = 0; 
    hashNode    *h; 
    DLNode      *p; 
    printf("\nhtable: "); 
    for (i = 0; i < obj->capacity; i++) {
        h = obj->bucket[i].hnext; 
        printf("[%d]next:", i);
        while (h) {
            printf("%d:%d->" , h->dlnode.key, h->dlnode.value); 
            h = h->hnext; 
        }
        printf("null\t"); 
    } 
    printf("\ndl: "); 
    for (i = 0, p = obj->head->next; i < obj->currNum; i++, p = p->next) 
        printf("%d->", p->key); 
} 
void leetcode_test_146_2() {
    int value; 
    LRUCache *cache = lRUCacheCreate(2); 
    lRUCachePut(cache, 1, 11); 
    lru_print(cache); 
    lRUCachePut(cache, 2, 22); 
    lru_print(cache);     
    value = lRUCacheGet(cache, 1); 
    lru_print(cache); 
    lRUCachePut(cache, 3, 33); 
    lru_print(cache); 
    value = lRUCacheGet(cache, 2); 
    lru_print(cache); 
    lRUCachePut(cache, 4, 44); 
    lru_print(cache); 
    value = lRUCacheGet(cache, 1); 
    lru_print(cache); 
    value = lRUCacheGet(cache, 3); 
    lru_print(cache); 
    value = lRUCacheGet(cache, 4); 
    lru_print(cache); 

    lRUCacheFree(cache); 
}
void leetcode_test_146_1() {
    int value; 
    LRUCache *cache = lRUCacheCreate(1); 
    lRUCachePut(cache, 2, 11); 
    lru_print(cache); 
    value = lRUCacheGet(cache, 2); 
    lru_print(cache); 
    lRUCachePut(cache, 3, 22); 
    lru_print(cache);  
    value = lRUCacheGet(cache, 2); 
    lru_print(cache); 
    value = lRUCacheGet(cache, 3); 
    lru_print(cache); 

    lRUCacheFree(cache); 
}
void leetcode_test_146() {
    int value; 
    LRUCache *cache = lRUCacheCreate(3); 
    lRUCachePut(cache, 1, 11); lru_print(cache); 
    lRUCachePut(cache, 2, 22); lru_print(cache); 
    lRUCachePut(cache, 3, 33); lru_print(cache); 
    lRUCachePut(cache, 4, 44); lru_print(cache); 
   
    value = lRUCacheGet(cache, 4); lru_print(cache); 
    value = lRUCacheGet(cache, 3); lru_print(cache); 
    value = lRUCacheGet(cache, 2); lru_print(cache); 
    value = lRUCacheGet(cache, 1); lru_print(cache); 

    lRUCachePut(cache, 5, 55); lru_print(cache); 

    value = lRUCacheGet(cache, 1); lru_print(cache); 
    value = lRUCacheGet(cache, 2); lru_print(cache); 
    value = lRUCacheGet(cache, 3); lru_print(cache); 
    value = lRUCacheGet(cache, 4); lru_print(cache); 
    value = lRUCacheGet(cache, 5); lru_print(cache); 

    lRUCacheFree(cache); 
}
