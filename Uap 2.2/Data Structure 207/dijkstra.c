#include <limits.h>
#include <stdbool.h>
#include <stdio.h>

// Number of vertices in the graph
#define V 5

int minDistance(int dist[], bool sptSet[])
{
    // Initialize min value
    int min = INT_MAX, min_node;

    for (int v = 0; v < V; v++)
        if (sptSet[v] == false && dist[v] <= min)
            min = dist[v], min_node = v;

    return min_node;
}

void printSolution(int dist[])
{
    printf("Vertex \t\t Distance from Source\n");
    for (int i = 0; i < V; i++)
        printf("%d \t\t\t\t %d\n", i, dist[i]);
}


void dijkstra(int graph[V][V], int src)
{
    int dist[V];

    bool sptSet[V];

    for (int i = 0; i < V; i++)
        dist[i] = INT_MAX, sptSet[i] = false;

    // Distance of source vertex from itself is always 0
    dist[src] = 0;


    for (int count = 0; count < V; count++) {

        int u = minDistance(dist, sptSet);
        sptSet[u] = true;


        for (int v = 0; v < V; v++)

            if (sptSet[v]==false
                && graph[u][v]
                && dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
    }


    printSolution(dist);
}

int main()
{
    int graph[V][V] = { { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 3, 6 },
                        { 3, 2, 0, 7, 0 },
                        { 0, 0, 0, 0, 5 },
                        { 0, 0, 0, 0, 0 },
                    };
    int source=2;
    dijkstra(graph, source);

    return 0;
}


/*
int graph[V][V] = {
    { 0, 0, 0, 0, 1 },  // Node 0 connected to Node 4 with weight 1
    { 0, 0, 0, 3, 6 },  // Node 1 connected to Node 3 with weight 3, Node 4 with weight 6
    { 3, 2, 0, 7, 0 },  // Node 2 connected to Node 0 with weight 3, Node 1 with weight 2, Node 3 with weight 7
    { 0, 0, 0, 0, 5 },  // Node 3 connected to Node 4 with weight 5
    { 0, 0, 0, 0, 0 },  // Node 4 has no outgoing edges
};

*/
