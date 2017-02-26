import java.util.Stack;

public class CC{

    private boolean[] marked;    // check for given node is tranversed or not
    private int[] id;        // have same id for connected components      
    private int[] size;      // to get size of the connected component  
    private int[] edgeTo; 
    private int count; // to get number of connected component

    public CC(Graph G,int s){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        edgeTo = new int[G.V()];
        count = 0 ;
        for(int v=0;v< G.V() ;v++){
            if(!marked[v]){
                edgeTo[v] =s;
                dfs(G,v);
                count++;
            }
        }

    }

    private void dfs(Graph G, int s){
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


    public boolean connected(int v, int w) {
        return id(v) == id(w);
    }



}