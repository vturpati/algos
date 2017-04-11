
public class LazyPrimMST {

    private boolean[] marked ;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<Edge>();
        mst = new LinkedList<Edge>();
        marked = new boolean[G.V];
        visit(G,0);

        while(!pq.isEmpty()){
            Edge e = pq.delMin();
            int v= e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.add(e)
            if(!marked[v]) visit(G,v);
            if(!marked[w]) visit(G,w);
        }
    }

    private visit(EdgeWeightedGraph G,int v){
        marked[v] = true;

        for(Edge e : G.adj(v)){
            if(!marked[e.other(v)])
            pq.insert(e);
        }
    }

    public Iterable<Edge> mst(){
        return mst;
    }
}