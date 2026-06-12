#include <avr/interrupt.h>
#include <stdio.h>

typedef struct Node{
  int item;
  struct Node *prev;
  struct Node *next;
} Node;

Node* deleteHead(Node *head){
  if(head == NULL) return NULL;
  Node* del = head;
  head = head ->next;
  if(head != NULL) head->prev = NULL;
  delete del;
  return head;
}

Node* find(Node* head, int target){

  while(head != NULL && head -> item != target){
    head = head ->next;
  }
  if(head == NULL) return NULL;
  return head;
}

void append(Node* head, int value){
  if(head == NULL) return;

  while(head -> next != NULL) head = head -> next;

  head -> next = new Node;
  head -> next -> item = value;
  head -> next -> prev = head;
  head -> next -> next = NULL;
}

int main(){

  int a = 0;
  int b = 0;
  char c[] = "Hallo";

  printf("a = %d  b = %d\n", a++, ++b);
  printf("a = %d  b = %d\n", a, b);

}


