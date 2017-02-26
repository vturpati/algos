import java.util.Stack;

public class DirectedDFS{

    private boolean[] marked;    // check for given node is tranversed or not
    private int[] edgeTo;        // check for a given node is came from             
    private final int s;

    public DirectedDFS(Digraph G,int s){
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G,s);
    }

    private void dfs(Digraph G, int s){
        marked[s] =true;
        for(int v: G.adj(s)){
            if (!marked[v]) {
                edgeTo[v] =s;
                dfs(G,v);
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