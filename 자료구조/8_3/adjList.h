#pragma once
#define MAX_VERTEX 30
#define FALSE 0
#define TRUE 1

// 인접 리스트의 노드 구조를 구조체로 정의
typedef struct graphNode{
    int vertex;
    struct graphNode* link;
} graphNode;

// 그래프를 인접 리스트로 표현하기 위한 구조체 정의
typedef struct graphType {
    int n;
    graphNode* adjList_H[MAX_VERTEX];
    int visited[MAX_VERTEX];
} graphType;

void createGraph(graphType* g);
void insertVertex(graphType* g, int v);
void insertEdge(graphType* g, int u, int v);
void print_adjList(graphType* g);
