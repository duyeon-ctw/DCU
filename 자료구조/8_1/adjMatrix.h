#pragma once
#define MAX_VERTEX 30

// 그래프를 인접 행렬로 표현하기 위한 구조체 정의
typedef struct graphType {
    int n;
    int adjMatrix[MAX_VERTEX][MAX_VERTEX];
} graphType;

void createGraph(graphType* p);
void insertVertex(graphType* g, int v);
void insertEdge(graphType* g, int u, int v);
void print_adjMatrix(graphType* g);
