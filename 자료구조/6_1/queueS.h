#pragma once
#define Q_SOZE 4
typedef char element;

typedef struct {
    element queue[Q_SOZE];
    int front, rear;
} QueueType;

QueueType* createQueue(void);
int isQueueEmpty(QueueType* Q);
int isQueueFull(QueueType* Q);
void enQueue(QueueType* Q, element item);
element deQueue(QueueType* Q);
element peekQ(QueueType* Q);
void printQ(QueueType* Q);
