#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "traversalBT.h"

// data를 루트 노드로 하여 왼쪽 서브 트리와 오른족 서브 트리를 연결하는 연산
treeNode* makeRootNode(element data, treeNode* leftNode, treeNode* rightNode) {
    treeNode* root = (treeNode*)malloc(sizeof(treeNode));
    root->data = data;
    root->left = leftNode;
    root->right = rightNode;
    return root;
}

// 이진 트리에 대한 전위 순회 연산
void preorder(treeNode* root) {
    if(root) {
        printf("%c", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

// 이진 트리에 대한 중위 순회 연산
void inorder(treeNode* root) {
    if(root) {
        inorder(root->left);
        printf("%c", root->data);
        inorder(root->right);
    }
}

// 이진 트리에 대한 후위 순회 연산
void postorder(treeNode* root) {
    if(root) {
        postorder(root->left);
        postorder(root->right);
        printf("%c", root->data);
    }
}
