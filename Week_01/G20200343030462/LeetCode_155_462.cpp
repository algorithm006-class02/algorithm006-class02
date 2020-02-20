class MinStack {
public:
    /** initialize your data structure here. */
    //注：这只是一道算法题，所以我在pop、top、getMin这三个成员函数里没有做异常处理
    MinStack() {
        
    }
    
    void push(int x) {
        m_stackData.push(x);
        if(true == m_stackMinData.empty())
        {
            m_stackMinData.push(x);     //如果辅助栈为空，那说明是入栈的是加入数据栈的第一个元素，自然就是最小的
        }
        else
        {
            //否则，就要把查看栈顶元素和新压栈的元素谁大谁小了，把小的放在栈顶
            int iMinData = m_stackMinData.top();
            if(iMinData < x)
                m_stackMinData.push(iMinData);
            else
                m_stackMinData.push(x);
        }
    }
    
    void pop() {
        m_stackData.pop();
        m_stackMinData.pop();
    }
    
    int top() {
        return m_stackData.top();
    }
    
    int getMin() {
        return m_stackMinData.top();
    }
private:
    //正常情况下m_stackData和m_stackMinData的大小是一致的
    std::stack<int> m_stackData;    //存储数据的栈，也就是正常对外提供push、pop和top的栈
    std::stack<int> m_stackMinData; //该栈的栈顶存储m_stackData每一次push后新的栈中最小元素
};
