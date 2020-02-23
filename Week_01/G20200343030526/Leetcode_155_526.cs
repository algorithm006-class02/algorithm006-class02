/*
 * @lc app=leetcode.cn id=155 lang=csharp
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (51.09%)
 * Likes:    380
 * Dislikes: 0
 * Total Accepted:    72.3K
 * Total Submissions: 140.6K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */

// @lc code=start
using System.Collections.Generic;
public class MinStack
{

    List<int> stack = new List<int>();
    int min = 0;
    /** initialize your data structure here. */
    public MinStack()
    {
        stack.Clear();
    }

    public void Push(int x)
    {
        if (stack.Count == 0)
        {
            min = x;
        }
        else
        {
            min = System.Math.Min(x, min);
        }
        stack.Add(x);
    }

    public void Pop()
    {
        if (stack.Count == 0)
        {
            throw new System.Exception("Stack is empty");
        }
        else
        {
            var remove = stack[stack.Count - 1];
            stack.RemoveAt(stack.Count - 1);
            if (remove == min)
            {
                for (int i = 0; i < stack.Count; i++)
                {
                    int item = stack[i];
                    if (i == 0)
                    {
                        min = item;
                    }
                    else
                    {
                        min = System.Math.Min(item, min);
                    }
                }
            }
        }

    }

    public int Top()
    {
        if (stack.Count == 0)
        {
            throw new System.Exception("Stack is empty");
        }
        else
        {
            return stack[stack.Count - 1];
        }
    }

    public int GetMin()
    {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(x);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */
// @lc code=end

