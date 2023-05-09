#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "StackS.h"

int top = -1;

// 스택이 공백 상태인지 확인하는 연산
int isStackEmpty(void) {
    if (top == - 1) {
        return 1;
    } else {
        return 0;
    }
}

// 스탣이 포화 상태인지 확인하는 연산
int isStackFull(void) {
    if (top == STACK_SIZE - 1) {
        return 1;
    } else {
        return 0;
    }
}

// 스택의 top에 원소를 삽입하는 연산
void push(element item) {
    if (isStackFull()){
        printf("\n\n Stack in FULL! \n");
        return;
    } else {
        stack[++top] = item;
    }
}

// 스택의 top에서 원소를 삭제하는 연산
element pop(void) {
    if(isStackEmpty()) {
        printf("\n\n Stack in Empty! \n");
        return 0;
    } else {
        return stack[top--];
    }
}

// 스택의 top에서 원소를 검색하는 연산
element peek(void) {
    if(isStackEmpty()) {
        printf("\n\n Stack in Empty! \n");
        return 0;
    } else {
        return stack[top];
    }
}

// 스택의 원소를 출력하는 연산
void printStack(void) {
    int i;
    printf("\n STACK [ ");
    for (i = 0; i<= top; i++) {
        printf("%d ", stack[i]);
    }
    printf("] ");
}
