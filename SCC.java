import java.util.Stack;

public class SCC{

    private boolean[] marked;    // check for given node is tranversed or not
    private int[] id;        // have same id for connected components      
    private int[] size;      // to get size of the connected component  
    private int[] edgeTo; 
    private int count; // to get number of connected component

    public SCC(Digraph G,int s){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        edgeTo = new int[G.V()];
        count = 0 ;
        DepthFirstOrder revGraph = new DepthFirstOrder(G.reverse());

        for(int v: revGraph.reversePost()){
            if(!marked[v]){
                edgeTo[v] =s;
                dfs(G,v);
                count++;
            }
        }

    }

    private void dfs(Digraph G, int s){
        marked[s] =true;
        id[s] = count;
        size[count]++;
        for(int v: G.adj(s)){
            if (!marked[v]) {
                edgeTo[v] =s;
                dfs(G,v);
            }
        }
    }

    public int id(int v) {
        return id[v];
    }

    public int size(int v) {
        return size[id[v]];
    }

    public int count() {
        return count;
    }


    public boolean stronglyConnected(int v, int w) {
        return id(v) == id(w);
    }



}