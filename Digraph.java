public class Digraph {
    private int V;
    private int E;
    private Bag<Integer> adj[];

    public Digraph(int v){
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
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

}