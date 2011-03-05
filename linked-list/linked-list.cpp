#include <iostream>

using namespace std;

class Node {
public:
    double data; // data
    Node* next; // pointer to next
};

class List {
public:
    List(void)
    { head = NULL;
		cout <<"Head value is "<<head<<endl; } // constructor
    ~List(void); // destructor
    bool IsEmpty() { return head == NULL; }
	
    Node* InsertNode( double x);
    int FindNode(double x);
    int DeleteNode(double x);
    void DisplayList(void);
    Node* InsertAfter(double,double);
	
private:
    Node* head;
};

Node* List::InsertAfter(double x,double y)
{
    Node* prevNode = NULL;
    Node* currNode = head;
    while (currNode && currNode->data != x)
    {
		prevNode = currNode;
		currNode = currNode->next;
    }
    if (currNode)
    {
		if (prevNode)
		{
			Node* newNode = new Node;
			newNode->data = y;}
    }}

List::~List(void) {
    Node* currNode = head, *nextNode = NULL;
    while (currNode != NULL) {
		nextNode = currNode->next;
		// destroy the current node
		delete currNode;
		currNode = nextNode;
    }
}


Node* List::InsertNode(double x) {
    int currIndex = 0;
    Node* currNode = head;
    Node* prevNode = NULL;
    cout <<"The x value is "<<x<<endl;
    cout <<"CurrNode value is :"<<currNode<<endl;
    cout <<"PrevNode value is :"<<prevNode<<endl;
	
    while (currNode && x > currNode->data) {
		cout <<"currNode->data is "<<currNode->data<<endl;
		prevNode = currNode;
		cout <<"PrevNode value is :"<<prevNode<<endl;
		currNode = currNode->next;
		cout <<"CurrNode value is :"<<currNode<<endl;
        cout <<"currIndex is "<<currIndex<<endl;
		currIndex++;
    }
	
    Node* newNode = new Node;
    cout<<"New node is created the address is "<<newNode<<endl;
    newNode->data = x;
    cout <<"newNode->data :"<<newNode->data<<endl;
    if (currIndex == 0) {
		newNode->next = head;
		cout <<" newNode->next value is head = "<<newNode->next<<endl;
		
		head = newNode;
		cout <<"The head value is newNode address"<<head<<endl<<endl;
		
    } else {
		newNode->next = prevNode->next;
		cout<<"newNode->next is "<<newNode->next<<endl;
		prevNode ->next = newNode;
		cout <<"prevNode->next is "<<prevNode ->next;
    }
	
    return newNode;
}

int List::FindNode(double x) {
    Node* currNode = head;
    int currIndex = 1;
    while (currNode && currNode->data != x) {
		currNode = currNode->next;
		currIndex++;
    }
    if (currNode)
		return currIndex;
    else
		return 0;
}

int List::DeleteNode(double x) {
    Node* prevNode = NULL;
    Node* currNode = head;
    int currIndex = 1;
    while (currNode && currNode->data != x) {
		prevNode = currNode;
		currNode = currNode->next;
		currIndex++;
    }
    if (currNode) {
		if (prevNode) {
			prevNode->next = currNode->next;
			delete currNode;
		}
		if(!currNode)
		{
			head = currNode->next;
			delete currNode;
		}
		return currIndex;
    }
    return 0;
}




void List::DisplayList()
{
    int num = 0;
    Node* currNode = head;
    while (currNode != NULL) {
		cout << currNode->data << ", ";
		currNode = currNode->next;
		num++;
    }
    cout << "\nNumber of nodes in the list: " << num << endl;
}

int main()
{
    List list;
    int number;
    
    list.InsertNode(7);
    system("PAUSE");
    list.InsertNode(5);
    system("PAUSE");
	list.InsertNode(6);
    system("PAUSE");
	list.InsertNode(4);
    //system("PAUSE");
	list.InsertNode(2);
    //system("PAUSE");
	//list.InsertNode(4);
    cout<<endl<<endl;
    system("PAUSE");
    list.DisplayList();
    	
    list.InsertAfter(2,6);
    list.DisplayList();
	
    system("PAUSE");
    return 0;
}
