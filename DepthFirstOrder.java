/* 
Reverse DFS postorder of a DAG(Digraph acyclic graph) is topological order 
*/

import java.util.Stack;

public class DepthFirstOrder{

    private boolean[] marked;    // check for given node is tranversed or not
    private Stack<Integer> reversePost;            

    public DepthFirstOrder(Graph G){

        // Check Digraph is DAG or not if it is not DAG stop here and return null
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];
        for(int i =0;i< G.V();i++){
            if(!marked[i])
            dfs(G,i);
        }
        
    }

    private void dfs(Graph G, int s){
        marked[s] =true;
        for(int v: G.adj(s)){
            if (!marked[v]) {
                dfs(G,v);
            }
        }
        reversePost.push(v);
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }



}