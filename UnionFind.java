class UnionFind{
    

    private int[] id;
    private int[] s;
    private int n;

    public UnionFind(int n){
        id = new int[n];
        s = new int[n];
        this.n = n;
        for(int i =0; i < n ; i++){
            id[i] = i ;
            s[i] = 1;
        }
    }

    private int root(int i ){
        while (i != id[i]) {
            id[i] = id[id[i]];
            i= id[i];
        }
    }

    public boolean connected(int p , int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        if(s[pid] > s[qid]){
            id[qid] = pid;
            s[pid] += s[qid]; 
        }
        else{
            id[pid] = qid;
            s[qid] += s[pid]; 
        }
    }
    
    /*
    public static void main(String[] a){
        System.out.println("hello world");
    }
    */
}