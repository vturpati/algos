 /**
 * name
 */
public class Edge implements Comparable<Edge>{
    private final int v,w;
    private final double weight;

    public Edge (int v ,int w , int weight) {
        this.v= v;
        this.w =w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if(vertex == v) return w;
        else return v;
    }

    public int compareTo(Edge e){
        if(e.weight < this.weight ) return 1;
        else if(e.weight > this.weight ) return -1;
        else return 0;
    }


}