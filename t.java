import java.util.*;
public class t {
    static int adjacency[][];
    static int count=0;
    static List<Integer> dfs;
    static void dfs(int src,boolean traversed[],int start[],int end[]){
        count++;
        start[src]=count;
        System.out.println((src+1)+" inserted");
        dfs.add(src+1);
        traversed[src]=true;
        for(int i=0;i<adjacency[src].length;i++){
            if(adjacency[src][i]==1 && traversed[i]!=true){
                dfs(i,traversed,start,end);
            }
        }
        count++;
        System.out.println((src+1)+" removed");
        end[src]=count;
    }
    static void bfs(int src,int size){
        System.out.println("\nBFS: ");
        boolean traversed[]=new boolean[size];
        List<Integer> bfs=new ArrayList<>();
        List<Integer> queue=new ArrayList<>();
        int level[]=new int[size];
        int counter=0;
        queue.add(src);
        System.out.println((src+1)+" added into the queue");
        traversed[src]=true;
        int vis;
        while (!queue.isEmpty()) {
            vis = queue.get(0);
            bfs.add(vis+1);
            //counter++;
            System.out.println((queue.get(0)+1)+" removed from the queue");
            queue.remove(queue.get(0));
            for(int i = 0; i < size; i++) {
                if (adjacency[vis][i] == 1 && (!traversed[i])) {
                    System.out.println((i+1)+" added into the queue");
                    queue.add(i);
                    level[i] = level[vis] + 1;
                    traversed[i] = true;
                }
            }
        }
        System.out.println("\nBFS: ");
        for(int i=0;i<size;i++) {
            System.out.print(bfs.get(i)+"("+level[bfs.get(i)-1]+")");
        }
    }    
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter n: ");
        int n=sc.nextInt();
        dfs=new ArrayList<>();
        boolean traversed[]=new boolean[n];
        int start[]=new int[n];
        int end[]=new int[n];
        System.out.println("Adjacency: ");
        adjacency=new int[n][n];
        for(int i=0;i<n;i++) {
        start[i]=0;
        end[i]=0;
        for(int j=0;j<n;j++) {
            if(i==j) {
                adjacency[i][j]=0;
            }
            else {
                System.out.print(i+1+" ---> "+(j+1)+" = ");
                adjacency[i][j]=sc.nextInt();
            }
        }
    }
    bfs(0,n);
    dfs(0,traversed,start,end);
    for(int i=0;i<n;i++) {
        System.out.println((i+1)+" : start = "+start[i]+" end = " +end[i] );
    }
    System.out.println("DFS: ");
    for(int i=0;i<n;i++){
        System.out.print(dfs.get(i)+" ");
    }
    }
}