## description 

N个城市，编号 1到N。城市间有 R条单向道路。
每条道路连接两个城市，有长度和过费属性。
Bob Bob只有 K块钱，他想从城市 1走到城市 N。问最短共需要走多长的路.
如果到不了 N，输出 -1

2<=N<=100 2<=N<=100 2<=N<=100
0<=K<=10000 0<=K<=10000 0<=K<=10000
1<=R<=10000 1<=R<=10000 1<=R<=10000
每条路的长度 L, 1 <= L <= 100
每条路的过费 T , 0 <= T <= 100 


## solution

```c++
#include <iostream>
#include <vector>
#include <cstring>
//#include <math>
using namespace std;
int K,N,R;
struct Road{
	int d,L,t;
};
vector<vector<Road> > cityMap(110); // cityMap[i] 表示点i与之相邻的路的集合 

int minLen = 1<<30;//当前找到最优路径长度
int totalLen = 0;//当前走的路径长度
int totalCost ;//当前走路的花销
int visited[110];
int minL[110][10100];
void Dfs(int s){
	if(s == N ){
		minLen = min(minLen,totalLen);
		return ;	
	} 
	for(int i= 0;i<cityMap[s].size();++i){
		int d = cityMap[s][i].d;
		if(!visited[d]){
			int cost = totalCost + cityMap[s][i].t;
			if (cost > K) continue;
			if(totalLen + cityMap[s][i].L > minLen|| 
			totalLen + cityMap[s][i].L > minL[s][cost]) continue; 
			
			totalLen += cityMap[s][i].L;
			totalCost += cityMap[s][i].t;
			visited[d] = 1;
			minL[d][cost] = totalCost;
			
			Dfs(d);
			visited[d] = 0;
			totalLen -=cityMap[s][i].L;
			totalCost -= cityMap[s][i].t;
		}
	}
} 

int main()
{
	cin>>K>>N>>R;
	for(int i=0;i<R;++i){
		int s;
		Road r;
		cin >>s >>r.d >> r.L >>r.t;
		if(s!= r.d)
			cityMap[s].push_back(r);
	}
	for(int i=0;i<110;++i){
		for(int j=0;j<10100;++j)
		minL[i][j]  = 1<<30;
	}
	memset(visited,0,sizeof(visited));
	totalLen = 0;
	totalCost = 0;
	visited[1]  =1;
	minLen = 1<<30;
	Dfs(1);
	if(minLen<(1<<30))
		cout<<minLen<<endl;
	else
		cout<<"-1"<<endl;
}

```