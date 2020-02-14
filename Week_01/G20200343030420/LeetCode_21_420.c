struct ListNode {
    int val;
    struct ListNode *next;
};
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    if (NULL == l1) 
        return l2; 
    if (NULL == l2) 
        return l1; 
    struct ListNode head, *node = &head; 

    while (l1 && l2) {
        if (l1->val < l2->val) {
            node->next = l1; 
            l1 = l1->next; 
        } 
        else {
            node->next = l2; 
            l2 = l2->next; 
        }
        node = node->next;
    } 
    node->next = (NULL == l2) ? l1 : l2; 
    return head.next; 
}
