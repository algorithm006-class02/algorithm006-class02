class Solution {
public:
    bool isValid(string s) {
        std:stack<char> stackBrackets;      //放括号的栈
        for(auto &bracket : s)
        {
            switch(bracket)
            {
                case '(' :
                    stackBrackets.push(')');
                break;
                case '{':
                    stackBrackets.push('}');
                break;
                case '[':
                    stackBrackets.push(']');
                break;
                default:
                    //空字符串的时候，这个循环是进不来的，所以如果这里栈为空的话，一定是}先出现在了字符串中，这必定是无效的
                    if(stackBrackets.empty() || stackBrackets.top() != bracket) 
                        return false;
                    stackBrackets.pop();
            }
        }
        return stackBrackets.empty();
    }
};
