#include <iostream>
using namespace std;
//Creation of Node
struct Node
{
    int data;
    Node* left;
    Node* right;
    Node(int d)
    {
        data=d;
        left=NULL;
        right=NULL;
    }
};
//Function to calculate preorder
void preorder(Node* root)
{
    if(root==NULL)
        return;
    cout<<root->data<<" ";
    preorder(root->left);
    preorder(root->right);
}
//Function to calculate inorder
void inorder(Node* root)
{
    if(root==NULL)
        return;
    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);
}
//Function to calculate postorder
void postorder(Node* root)
{
    if(root==NULL)
        return;
    postorder(root->left);
    postorder(root->right);
    cout<<root->data<<" ";
}
//Function to traversal
void traversal(Node* root)
{
    cout<<"\nPreorder: "; preorder(root); cout<<endl;
    cout<<"Inorder: "; inorder(root); cout<<endl;
    cout<<"Postorder: "; postorder(root); cout<<endl;
}
//Function to insert node
struct Node* insertNode(struct Node* root, int data)
{
    if(root == NULL)
    {
        return new Node(data);
    }
    if(root->data > data)
    {
        root->left = insertNode(root->left, data);
    }
    else
    {
        root->right = insertNode(root->right, data);
    }
    return root;
}
//Function to find inorder sucessor
Node* searchLeftMost(Node* root)
{
    Node* t=root;
    while(t->left)
    {
        t=t->left;
    }
    return t;
}
//Function to deleteNode
struct Node* deleteNode(struct Node* root, int data)
{
   
    if(root->data<data)
    {
        root->right = deleteNode(root->right, data);
    }
    else if(root->data>data)
    {
        root->left = deleteNode(root->left, data);
    }
    else
    {
        if(root->left == NULL)
        {
            Node* temp=root->right;
            free(root);
            return temp;
        }
        else if(root->right == NULL)
        {
            Node* temp=root->left;
            free(root);
            return temp;
        }
        Node* temp = searchLeftMost(root->right);
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);
    }
    return root;
}
int main()
{
    int ele,ch;
    Node* root=NULL;
    do
    {
        cout<<"\n1. Enter Data\n2. Delete Data\n0. Exit\n-> ";
        cin>>ch;
        switch(ch)
        {
            case 1:
                    cout<<"\nEnter data to be inserted: ";
                    cin>>ele;
                    if(root == NULL)
                        root = insertNode(root, ele);
                    else
                        insertNode(root, ele);
                        traversal(root);
                    break;
            case 2:
                    cout<<"\nEnter data to be deleted: ";
                    cin>>ele;
                    deleteNode(root, ele);
                    traversal(root);
                    break;
            case 0:
                    break;
            default:
                    cout<<"\nEnter Valid Choice:";
        }
    }while(ch);
    return 0;
}

