#include<iostream>
#include<stack>
#include<vector>
#include<queue>
using namespace std;

void printAdjList(int n, vector<int> adj[])
{
    cout<<"\n\n--Adjency List--"<<endl;
    for(int i=1; i<=n; i++)
    {
        cout<<i<<" : ";
        for(auto node : adj[i])
        {
            cout<<node<<" ";
        }
    cout<<endl;
    }
}

void bfsTraversal(int src,vector<bool> vis, vector<int> adj[])
{
    //Queue For BFS
    queue<int> q;
    // Enqueue it in queue and marked as visited
    q.push(src);
    q.push(-1); //to check level
    vis[src]=1;
    int level = 0;
    while(!q.empty())
    {
       
        if(q.front()!=-1)
        {
            //Dequeue the vertex from queue and print it
            cout<<"\nLevel: "<<level;
            int node=q.front();
            q.pop();
            cout<<" Node: "<<node;
            // Get all adjacent vertices of the dequeued vertex s
            // If Adjacent vertice has not been visited,
            // then mark it visited and enqueue it
            for(auto a: adj[node])
            {
                if(!vis[a])
                {
                    vis[a]=1;
                    q.push(a);
                }
            }  
        }
        else
        {
            while(q.front() ==-1)
            q.pop();
            level++;
            q.push(-1);
        }
    }
}

int main()
{
    int n,m;
    cout<<"\nEnter N (Nodes): ";
    cin>>n;
    cout<<"Enter M (Edges): ";
    cin>>m;
    vector<bool> vis(n+1, 0);
    vector<int> adj[n+1];
    int u,v;
    bool undirected;
    cout<<"\nGraph undirected? (0/1): ";
    cin>>undirected;
    for(int i=0; i<m; i++)
    {
        cout<<"Enter src -> dest: ";
        cin>>u>>v;
        adj[u].push_back(v);
        if(undirected)
        adj[v].push_back(u);
    }
    int src;
    cout<<"\nEnter Source Node: ";
    cin>>src;
    printAdjList(n, adj);
    cout<<"\n--------BFS--------"; bfsTraversal(src, vis, adj);
    cout<<endl<<endl;
    return 0;
}