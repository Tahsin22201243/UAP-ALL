#include<bits/stdc++.h>
using namespace std;

int V = 5;
int visited[5];
int G[5][5] =
{
    {0,1,0,0,1},
    {1,0,0,1,1},
    {0,0,0,1,0},
    {0,1,1,0,1},
    {1,1,0,1,0}
};

void DFS(int current)
{
    visited[current] = 1;
    printf("%d ", current);

    for(int j=0; j<V; j++)
    {
        if(G[current][j]==1 && visited[j]==0)
        {
            DFS(j);///not need the stack because recursion work like dfs
        }
    }
}

int main()
{

    DFS(0);
}

///only print visited node(visited node and complete node not same in dfs)
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
