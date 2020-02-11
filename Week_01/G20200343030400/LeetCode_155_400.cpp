//155
//https://leetcode-cn.com/problems/min-stack/

class MinStack {
private:
    stack<pair<int, int>> minStk;

public:   
    void push(int x) {
        if (minStk.empty()) {
            minStk.push({x, x});
        } else {
            minStk.push({x, min(x, minStk.top().second)});
        }
    }
    
    void pop() {
        minStk.pop();
    }
    
    int top() {
        return minStk.top().first;
    }
    
    int getMin() {
        return minStk.top().second;   
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
