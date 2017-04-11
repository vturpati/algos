
public class EdgeWeightedGraph {
    int V;
    private final Bag<Edge>[] adj;

    public EdgeWeightedGraph (int v) {

    this.V = v;
    adj = (Bag<Edge>[])  new Bag<Edge>[v];
    for(int i=0;i<v;i++){
        adj[i] = new Bag<Edge>();
    }
    }   

    public void  addEdge(){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }    
}
