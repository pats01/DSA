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

void dfsTraversal(int src, vector<bool> vis, vector<int> adj[], int n)
{
    cout<<"\n\nDFS Traversal: "<<endl;
    // Stack for DFS
    stack<int> st;
    st.push(src);
    int d[n+1]; //Start Node
    int f[n+1]; //Finish Node
    for(int i=0; i<=n; i++)
    {
        d[i]=f[i]=-1;
    }
    int cnt=1;
    while (!st.empty())
    {
        //Pop a vertex from stack and print it
        int node = st.top();
        // Print the popped item if stack contain 
        //same vertex twice & if it is not visited.
        if (!vis[node])
        {
            cout << node << " ";
            if(d[node] == -1) d[node]=cnt++;
            vis[node] = 1;
        }
        bool flag = 1;
        // Get all adjacent vertices of the popped vertex s
        // Push adjacent vertices into the 
        // stack if it has not been visited
        for (auto i : adj[node])
        {
            if (!vis[i])
            {
                st.push(i);
                flag=0;
            }
        }
        if(flag)
        {
            if(f[node] == -1) f[node]=cnt++;
            st.pop();
        }
    }
    cout<<"\n\node"<<"\t"<<"d(Start)\t"<<"f(Finish)"<<endl;
    for(int i=1; i<=n; i++)
    {
        cout<<" "<<i<<"\t "<<d[i]<<"\t\t"<<f[i]<<endl;
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
    cout<<"\n--------DFS--------"; dfsTraversal(src, vis, adj, n);
    return 0;
}