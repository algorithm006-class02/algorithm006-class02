/*
 * @lc app=leetcode.cn id=874 lang=cpp
 *
 * [874] 模拟行走机器人
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (32.46%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    5.7K
 * Total Submissions: 17.7K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * 
 * 
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 
 * 
 * 在网格上有一些格子被视为障碍物。
 * 
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 
 * 返回从原点到机器人的最大欧式距离的平方。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 
 * 
 * 示例 2：
 * [4,-1,4,-2,4]\n[[2,4]]
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * 
 * 
 * [2,-1,8,-1,6]\n[[1,5],[-5,-5],[0,4],[-1,-1],[4,5],[-5,-3],[-2,1],[-2,-5],[0,5],[0,-1]]
 * 
 * 提示：
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * 
 * 
 */

// @lc code=start
class Solution {
public:
	/*
	解法一:逐个分析命令，判定方向，根据障碍物坐标计算能走到的坐标
	140ms 54.68%
	*/
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        map<int,set<int>> xs ;
        map<int,set<int>> ys ;
        //hash and sort the obstacles
        for( auto &one : obstacles) {
            if(one.size() == 2) {
                xs[one[0]].emplace(one[1]);
                ys[one[1]].emplace(one[0]);
            }
        }
		
		int path = INT_MIN;

        int x = 0 , y = 0 ;
        bool moveY = true ,positiveX = false ,positiveY = true ;
        for( auto cmd : commands ) {
            if(cmd == -1 || cmd == -2 ) {
                if ( moveY ) {
                    positiveX = positiveY ? ( cmd == -2 ? false : true ) : ( cmd == -2 ? true : false ) ;
                }
                else {
                    positiveY = positiveX ? ( cmd == -2 ? true : false ) : ( cmd == -2 ? false : true ) ;
                }
                moveY = ! moveY ;
            }
            else {
                set<int>::iterator  it ;
                set<int>::reverse_iterator itr;
                //move on Y
                if ( moveY ) {
                    //find obstacles
                    if( xs.find(x) != xs.end() ) {

                        if ( positiveY && (it = xs[x].upper_bound(y)) != xs[x].end()) {
                            y  = y+cmd < *it ? y+cmd : *it - 1;                            
                        }
                        else if( !positiveY && (itr = find_if(xs[x].rbegin(),xs[x].rend(),[y](int n) -> bool {return n < y ;}))!=  xs[x].rend() )  {
                            y = *itr  < y-cmd ? y-cmd : *itr + 1;
                        }
                        //no obstacles
                        else {
                            y  =  positiveY  ?  y+cmd : y-cmd ;
                        }
                    }
                    else {
                        y  =  positiveY  ?  y+cmd : y-cmd ;
                    }
                }
                //move on X
                else {
                    if( ys.find(y) != ys.end() ) {
                        if( positiveX && (it = ys[y].upper_bound(x)) != ys[y].end()) {
                            
                            x = x+cmd < *it ? x+cmd : *it -1;
                        }
                        else if (!positiveX && (itr = find_if(ys[y].rbegin(),ys[y].rend(),[x](int n) -> bool {return n < x ;})) != ys[y].rend()) {
                            x = *itr < x - cmd ? x - cmd : *itr + 1 ;
                        }
                        else {
                            x  =  positiveX  ?  x+cmd : x-cmd ;
                        }
                    }
                    else {
                        x  =  positiveX  ?  x+cmd : x-cmd ;
                    }
                }

				path = max(path,x*x+y*y);
            }
            
        }

        

        return path ;
    }


    /*
     *社区高赞解法
     */
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        unordered_set<string> obs;
        for(int i=0;i<obstacles.size();i++) obs.insert(to_string(obstacles[i][0])+"#"+to_string(obstacles[i][1]));
        int res=0, dir=0, x=0, y=0;
        vector<vector<int>> ds={{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int i=0;i<commands.size();i++) {
            if(commands[i]==-2) dir--;
            else if(commands[i]==-1) dir++;
            else {
                for(int j=0;j<commands[i];j++) {
                    string pos=to_string(x+ds[dir][0])+"#"+to_string(y+ds[dir][1]);
                    if(obs.find(pos)!=obs.end()) break;
                    x+=ds[dir][0], y+=ds[dir][1];
                }
                res=max(res, x*x+y*y);
            }
            if(dir==-1) dir=3;
            if(dir==4) dir=0;
        }
        return res;
    }
};
// @lc code=end

