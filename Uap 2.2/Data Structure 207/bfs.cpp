#include<bits/stdc++.h>
using namespace std;
#include <queue>

int V = 5;
int visited[5];
int G[5][5] =
{
    {0,1,0,0,1},
    {1,0,0,1,1},
    {0,0,0,1,0},///graph represent by adjency matrix, connection point identify
    {0,1,1,0,1},
    {1,1,0,1,0}
};

void BFS(int v)
{
    queue<int> Q;

    visited[v] = 1; ///1st visit
    printf("%d ", v);///2nd print
    Q.push(v);///3rd queue

    while(!Q.empty())   ///loop run untill queue not equal to empty
    {
        int current = Q.front();///save the front
        Q.pop();
        for(int j=0; j<V; j++)
        {
            if(G[current][j]==1 && visited[j]==0)///1 connection 0 not connect  (visited[j]!=1)
            {
                visited[j] = 1;
                printf("%d ", j);
                Q.push(j);
            }
        }
    }
}
int main()
{
    BFS(0);
}


///row  = current
///column = j

///only print visited node (visited node and complete node same in bfs)
///try to print complete node and adjency list


/*
int G[5][5] = {
    {0, 1, 0, 0, 1},  // Node 0 is connected to Node 1 and Node 4
    {1, 0, 0, 1, 1},  // Node 1 is connected to Node 0, Node 3, and Node 4
    {0, 0, 0, 1, 0},  // Node 2 is connected to Node 3
    {0, 1, 1, 0, 1},  // Node 3 is connected to Node 1, Node 2, and Node 4
    {1, 1, 0, 1, 0}   // Node 4 is connected to Node 0, Node 1, and Node 3
};
*/
