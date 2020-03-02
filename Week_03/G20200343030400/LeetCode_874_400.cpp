//874
//https://leetcode-cn.com/problems/walking-robot-simulation

class Solution {
public:
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
        int dx[4] = {1, 0, -1, 0};
        int dy[4] = {0, 1, 0, -1};
        int x = 0, y = 0, dir = 1;

        unordered_set <pair<int,int>, pair_hash> obstacleSet;
        for (vector<int> obstacle: obstacles)
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));

        int distanceSquare = 0;
        for (int cmd: commands) {
            if (-2 == cmd) {
                dir = (dir + 1) % 4;
            } else if (-1 == cmd) {
                dir = (dir + 3) % 4;
            } else {
                for (int steps = cmd; steps > 0; steps--) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (obstacleSet.find(make_pair(nx, ny)) == obstacleSet.end()) {
                        x = nx;
                        y = ny;
                        distanceSquare = max(distanceSquare, x * x + y * y);
                    } else {
                        steps = 0;
                    }
                }
            }
        }
        return distanceSquare;
    }
};
