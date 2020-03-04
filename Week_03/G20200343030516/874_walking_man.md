### description
874. 模拟行走机器人
机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：

-2：向左转 90 度
-1：向右转 90 度
1 <= x <= 9：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物。

第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])

如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。

返回从原点到机器人的最大欧式距离的平方。

 

示例 1：

输入: commands = [4,-1,3], obstacles = []
输出: 25
解释: 机器人将会到达 (3, 4)
示例 2：

输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
输出: 65
解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 

提示：

0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
答案保证小于 2 ^ 31

### solution
```python
class Solution:
    def robotSim(self, commands, obstacles):
        dx = [0, 1, 0, -1]  #模拟方向
        dy = [1, 0, -1, 0]
        x = y = di = 0
        obstacleSet = set(map(tuple, obstacles))
        ans = 0

        for cmd in commands:
            if cmd == -2:  #left
                di = (di - 1) % 4
            elif cmd == -1:  #right
                di = (di + 1) % 4
            else:
                for k in range(cmd):
                    if (x+dx[di], y+dy[di]) not in obstacleSet: # 需要先判断下一步能不能走，然后再决定
                        x += dx[di]
                        y += dy[di]
                        ans = max(ans, x*x + y*y)

        return ans
```


C++ SOLUTION
```C++
class Solution{

public:
    int robotSim(vector<int>&commands,vector<vector<int>> &obstacles){
        int dx[4] = {0,1,0,-1};
        int dy[4] = {1,0,-1,0};
        int x=0, y=0, to = 0; 
        unordered_set<pair<int,int>> obstacleSet;
        for(vector<int> obstacle: obstacles){
            obstacleSet.insert(make_pair(obstacle[0],obstacle[1]);)
        }
        int ans = 0;
        for(int cmd:commands){
            if(cmd ==-2){
                to  = (to+3) % 4;
            }else if(cmd==-1){
                to == (to+1) % 4;
            } else{
                for(int k=0;k<cmd;++k){
                    int nx = x +dx[to];
                    int ny = y +dy[to];
                    if(obstacleSet.find(make_pair(nx,ny))==obstacle.end()){
                        x = nx;
                        y = ny;
                        ans = max(ans,x*x,y*y);
                    }
                }
            }
        }
        return ans;
    }

};
```