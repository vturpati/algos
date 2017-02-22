

class BST<Key extends Comparable<Key> , Value > {
    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left , right;
        int count ;
        public  Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            count = 0;
        }
    }

    public void put(Key key,Value value){
        root = put(root , key , value);
    }

    private Node put(Node x, Key key ,Value value){
        if( x == null) return new Node(key,value);

        int cmp = key.compareTo(x.key);
        if(cmp < 0 ) put(x.left , key , value);
        else if(cmp > 0 ) put(x.right , key , value);
        else x.value = value;
        x.count = 1+ size(x.left) + size(x.right);
        return x;    
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        return x.count;
    }

    public  Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0 ) x = x.left;
            else if(cmp > 0) x = x.right;
            else return x.value;
        }

        return null;

    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    } 

    public Key min() {
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    
    public void deleteMin(){
       root=  deleteMin(root);
    }

    public Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);

        return x;
    }
}