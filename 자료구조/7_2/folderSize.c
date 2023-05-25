#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "folderSize.h"

// size를 루트 노드로 하여 왼쪽 서브 트리와 오른족 서브 트리를 연결하는 연산
treeNode* makeRootNode(int size, treeNode* leftNode, treeNode* rightNode) {
    treeNode* root = (treeNode*)malloc(sizeof(treeNode));
    root->size = size;
    root->left = leftNode;
    root->right = rightNode;
    return root;
}

// 각 폴더 크기를 계산하기 위한 후위 순회 연사
int postorder_FolderSize(treeNode* root) {
    if(root) {
        postorder_FolderSize(root->left);
        postorder_FolderSize(root->right);
        FolderSize += root->size;
    }
    return FolderSize;
}
