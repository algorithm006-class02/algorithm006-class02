/*
 * @lc app=leetcode.cn id=874 lang=cpp
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
/*
 * @lc app=leetcode.cn id=874 lang=cpp
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
private:
    map<int, vector<int>> m_map;
    vector<vector<int>> array;
    int m_x = 0;
    int m_y = 0;
    int m_direcion = 0; // 0北（y++） 1东（x++） 2南（y--） 3西（x--）
public:
    void turn(int commands) {
        if (commands == -1) { m_direcion++; }
        else if (commands == -2) { m_direcion--;}
        m_direcion = (m_direcion + 4) % 4;
    }
    
    bool NoObstacle(int x, int y) {
        auto it = m_map.find(x);
        if (it != m_map.end()) {
            for (auto p: it->second) {
                if (y == p) return false;
            }
        }
        return true;
    }

    void move(int commands ,vector<vector<int>>& obstacles) {
        switch (m_direcion) {
            case 0 : 
                while (commands-- and NoObstacle(m_x, m_y + 1)) m_y++; 
                break;
            case 1 : 
                while (commands-- and NoObstacle(m_x + 1, m_y)) m_x++; 
                break;
            case 2 : 
                while (commands-- and NoObstacle(m_x, m_y - 1)) m_y--; 
                break;
            case 3 : 
                while (commands-- and NoObstacle(m_x - 1, m_y)) m_x--; 
            default: break;
        } 
    }

    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        for (auto place: obstacles) {
            auto it = m_map.find(place[0]);
            if (it != m_map.end()) {
                m_map[place[0]].push_back(place[1]);
            }
            else {
                vector<int> temp;
                temp.push_back(place[1]);
                m_map.insert(pair<int, vector<int>>(place[0], temp));
            }
        }
        int m_max = 0;
        for (int i = 0 ; i < commands.size(); i++) {
            if (commands[i] >= 1 and commands[i] <= 9) {
                move(commands[i], obstacles);
                m_max = max(m_max, m_x*m_x + m_y*m_y);
                continue;
            }
            turn(commands[i]);
        }
        return m_max;
    }
};
// @lc code=end


// @lc code=end

