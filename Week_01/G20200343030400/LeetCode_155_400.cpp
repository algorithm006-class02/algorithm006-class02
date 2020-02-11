//155
//https://leetcode-cn.com/problems/min-stack/

class MinStack {
private:
    stack<int> stk;
    stack<int> minStk;

public:   
    void push(int x) {
        stk.push(x);
        if (minStk.empty()) {
            minStk.push(x);
        } else if (x <= minStk.top()) {
            minStk.push(x);
        }
    }
    
    void pop() {
        if (stk.top() == minStk.top()) {
            minStk.pop();
        }
        stk.pop();
    }
    
    int top() {
        return stk.top();
    }
    
    int getMin() {
        return minStk.top();   
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
