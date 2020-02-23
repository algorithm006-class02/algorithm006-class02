/*
 * @lc app=leetcode.cn id=874 lang=cpp
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
public:
    void left(char& c)
    {
        if(c == 'U') c = 'L';
        else if(c == 'L') c = 'D';
        else if(c == 'D') c = 'R';
        else c = 'U';
    }
    
    void right(char& c)
    {
        if(c == 'U') c = 'R';
        else if(c == 'R') c = 'D';
        else if(c == 'D') c = 'L';
        else c = 'U';
    }
    int distance(pair<int,int> curr_point)
    {
        return curr_point.first * curr_point.first + curr_point.second * curr_point.second;
    }
    struct pair_hash
    {
        template <class T1, class T2>
        std::size_t operator () (std::pair<T1, T2> const &pair) const
        {
            std::size_t h1 = std::hash<T1>()(pair.first);
            std::size_t h2 = std::hash<T2>()(pair.second);

            return h1 ^ h2;
        }
    };
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        char c = 'U';
        pair <int,int> curr_point = make_pair(0,0);
        unordered_set < pair<int,int> , pair_hash> obs;
        int dist = 0;
        for(auto w: obstacles) obs.insert(make_pair(w[0],w[1]));
        for(int i = 0; i < commands.size(); ++i)
        {
            if(commands[i] == -1) right(c);
            else if(commands[i] == -2) left(c);
            else
            {
                bool obstacle = false;
                for(int j = 1; j <= commands[i] and not obstacle; ++j)
                {
                    if(c == 'R')
                    {
                        if(obs.find(make_pair(curr_point.first+1,curr_point.second)) != obs.end())
                        {
                            
                            obstacle = true;
                        }
                        else curr_point.first += 1;
                    }
                    else if(c == 'U')
                    {
                        
                       if(obs.find(make_pair(curr_point.first,curr_point.second+1)) != obs.end())
                        {
                            
                            obstacle = true;
                        }
                        else
                        {
                            curr_point.second += 1;
                        }
                    }
                    else if(c == 'D')
                    {
                        
                        if(obs.find(make_pair(curr_point.first,curr_point.second-1)) != obs.end())
                        {
                            
                            obstacle = true;
                        }
                        else curr_point.second -= 1;
                    }
                    else if(c == 'L')
                    {
                        if(obs.find(make_pair(curr_point.first-1,curr_point.second)) != obs.end())
                        {
                            
                            obstacle = true;
                        }
                        else curr_point.first -= 1;
                    }
                    dist = max(dist,distance(curr_point));
                }
            }
        }
        return dist;        
    }
};
// @lc code=end

