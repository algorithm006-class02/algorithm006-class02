class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int count = 0;
        for ( const auto &stone : S )
        {
            if ( string::npos != J.find(stone) )
            {
                ++count;
            }
        }
        return count;
    }
};
