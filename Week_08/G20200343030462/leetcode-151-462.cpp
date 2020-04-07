class Solution {
public:
    string reverseWords(string s) {
        stack<string> memo;
        stringstream in(s);
        string str;
        while(in >> str)
            memo.push(str);
        
        stringstream out;
        while(!memo.empty())
        {
            out << memo.top() << " ";
            memo.pop();
        }
        str = out.str();
        return str.substr(0,str.size() - 1);
    }
};
