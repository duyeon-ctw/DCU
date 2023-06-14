#include <stdio.h>
#include "adjList.h"
#include "stackL.h"
#include "DFS.h"

// 그래프 g에서 정점 v에 대한 깊이 우선 탐색 연산
void DFS_adjList(graphType* g, int v) {
    graphNode* w;
    top = NULL;
    push(v);
    g->visited[v] = TRUE;
    printf(" %c", v + 65);
    
    // 스택이 공백이 아닌 동안 깊이 우선 탐색 반복
    while (!isStackEmpty()) {
        w = g->adjList_H[v];
        while (w) {
            if (!g->visited[w->vertex]) {
                push(w->vertex);
                g->visited[w->vertex] = TRUE;
                printf(" %c", w->vertex + 65);
                v = w->vertex;
                w = g->adjList_H[v];
            } else {
                w = w->link;
            }
        }
        v = pop();
    }
}
