/**
 * DjikstraSP
 */
public class DjikstraSP {
   
   private DirectedEdge[] edgeTo;
   private double[] distTo;
   private IndexMinPQ<double> pq; 

    public DjikstraSP (EdgeWeightedDigraph G, int s) {
        int v= G.V();
        edgeTo = new DirectedEdge[v];
        distTo = new double[v];
        pq = new IndexMinPQ<Double>(v); 
        for(int i=0;i<v;i++)
        distTo[i]= Double.MAX_VALUE;

        distTo[s] = 0.0;
        pq.insert(s,0.0);

        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for(DirectedEdge e : G.adj(v)){
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e){
        int v= e.from();
        int w= e.to();
        if(distTo[w]> distTo[v]+e.weight()){
            distTo[w] = distTo[v]+e.weight();
            edgeTo[w] = e;
            if(pq.contain(w)) decreaseKey(w,distTo[w]);
            else pq.insert(w,distTo[w])
        }

    }
}