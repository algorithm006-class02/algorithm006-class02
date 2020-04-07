class Solution {
public:
    int lengthOfLastWord(string s) {
        stringstream in(s);
        string lastWorld;
        while( in >> lastWorld);
        return lastWorld.size();
    }
};
