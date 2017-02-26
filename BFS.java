import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BFS{

    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;    // check for given node is tranversed or not
    private int[] edgeTo;        // check for a given node is came from             
    private int[] distTo;
    private final int s;

    public BFS(Graph G,int s){
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        for(int i=0;i<G.V();i++){
            distTo[i] = INFINITY;
        }
        bfs(G,s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        marked[s] =true;
        distTo[s] = 0;
        while (q.isEmpty()) {
            int v = q.remove();
            for(int w : G.adj(v)){
                if(!marked[w]){
                    q.add(w);
                    distTo[w] = distTo[v]+1;
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }

    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path= new Stack<Integer>();
        for(int x =v;x !=s ;x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }



}