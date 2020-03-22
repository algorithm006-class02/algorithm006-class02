class Solution {
public:
    //似乎这个题目也没用到什么算法，纯粹就是思考
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        //(dx[i],dy[i])构成了(x,y)坐标轴上的一个坐标点，初始情况下，机器人是面向北方的，你可以在坐标轴上建立一个上北下南左西右东的地图坐标系，它的北刚好和y轴正方向相同。于是x-y坐标(0,1)表示机器人现在面向的是北方，(1,0)坐标表示的机器人在面向北方的情况下进行了右转；(0,-1)，则表示向后转；(-1,0)坐标表示在向左转。你可以想象这个机器人是一个高为1的立体。
        
        set<std::pair<int,int>> unsetObstacles;       //障碍物，方便后续的查找，这里set的模板参数是string原因是set的模板参数不能使pair<>
        for(auto const &obstacle : obstacles)
        {
            unsetObstacles.insert(std::pair<int,int>(obstacle[0],obstacle[1]));
        }
        
        int di = 0;     //机器人接收到指令和的方向，它是dx和dy的下标
        int x = 0, y = 0;   //机器人在坐标轴上的位置
        int ans = 0;
        for(auto cmd : commands)
        {
            //左转90度
            if(-2 == cmd)
                di = (di + 3) % 4; //要的是(dx[3],dy[3])
            else if (-1 == cmd)
                di = (di + 1) % 4;  //要的是(dx[1],dy[1])
            else
                for(int k = 0; k < cmd; ++k)    //移动，因为如果只是转向的话，不需要移动位置
                {
                    int nx = x + dx[di];    //因为这里是x + dx[di]的缘故，所以最后一次循环的时候nx = cmd，也就是题目要求移动的步长，所以循环控制条件是k < cmd
                    int ny = y + dy[di];
                    //判断在(nx,ny)这个位置上是不是有障碍物，如果有障碍物，则机器人被阻塞在这里，但是nx和ny可以继续变化，并执行后续的指令
                    if(unsetObstacles.end() == unsetObstacles.find(make_pair(nx,ny)) )
                    {
                        //没有障碍物
                        x = nx;
                        y = ny;
                        ans = std::max(ans,x*x+y*y);
                    }
                }
            }
        return ans;
    }
};
