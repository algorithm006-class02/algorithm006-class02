### Merge Two Sorted Lists  
[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)  

### 题解  
采用递归的方式解决问题。  

```Python
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 or not l2:
            return l1 or l2
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

    def display(self, nums):
        element = []
        node = nums
        while node:
            element.append(node.val)
            node = node.next
        return element


if __name__ == '__main__':
    l1_1 = ListNode(1)
    l1_1.next = ListNode(2)
    l1_1.next.next = ListNode(4)

    l2_1 = ListNode(1)
    l2_1.next = ListNode(3)
    l2_1.next.next = ListNode(4)

    solution = Solution()
    merge_result = solution.mergeTwoLists(l1_1, l2_1)
    show_result = solution.display(merge_result)
    print(show_result)
```

C++的Runtime显示仍然要比Python快:  
```C++
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {

        if (l1 == NULL) {
            return l2;
        }
        if (l2 == NULL) {
            return l1;
        }

        if (l1->val < l2->val) {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        } else {
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
    }
};

void print_listnode(ListNode *node)
{
    while(node!=NULL)
    {
        cout<<node->val<<endl;
        node=node->next;
    }
}

int main(int argc, const char * argv[])
{
    Solution s;
    ListNode a(1);
    ListNode b(2);
    ListNode c(4);
    a.next = &b;
    b.next = &c;

    ListNode d(1);
    ListNode e(3);
    ListNode f(4);
    d.next = &e;
    e.next = &f;

    ListNode *result = s.mergeTwoLists(&a,&d);
    print_listnode(result);
    return 0;
}
```
