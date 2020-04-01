class Solution {
public:
    string toLowerCase(string str) {
        for( auto &alphabet : str )
        {
            if(isupper(alphabet))
                alphabet = tolower(alphabet);
        }
        return str;
    }
};
