public class Graph {
    private int V;
    private int E;
    private Bag<Integer> adj[];

    public Graph(int v){
        this.V=v;
        this.E=0;
        adj = (Bag<Integer>[])new Bag[v];
        for(int i=0;i<v;i++){
            adj[i] = new Bag<Integer>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}