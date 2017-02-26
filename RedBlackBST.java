import java.util.Date;



class RedBlackBST<Key extends Comparable<Key> , Value > {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        private Key key;
        private Value value;
        private Node left , right;
        int count ;
        boolean color;    // color of parent link
        public  Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            color = RED;
            count = 1;
        }
    }

    private boolean isRed(Node x){
        if(x == null) return BLACK;
        return x.color == RED; 
    }


    private void flipColor(Node h ){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }


    private Node rotateLeft(Node h){

        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.count = h.count;
        h.count = size(h.left) + size(h.right) + 1;
        return x; 
    }

        private Node rotateRight(Node h){

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.count = h.count;
        h.count = size(h.left) + size(h.right) + 1;
        return x; 
    }

    public void put(Key key,Value value){
        root = put(root , key , value);
    }

    private Node put(Node x, Key key ,Value value){
        if( x == null) return new Node(key,value);

        int cmp = key.compareTo(x.key);
        if(cmp < 0 ) x.left = put(x.left , key , value);
        else if(cmp > 0 ) x.right = put(x.right , key , value);
        else x.value = value;

        if(isRed(x.right) && !isRed(x.left)) x=rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x= rotateRight(x);
        if(isRed(x.left) && isRed(x.right)) flipColor(x);

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

    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.value;
        }
        return null;
    }


    public Key min() {
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    

    public static void main(String[] args) { 
        RedBlackBST<Integer, Integer> st = new RedBlackBST<Integer, Integer>();
        Date date1 = new Date();
        for (int i = 0; i < 100000000; i++) {
            st.put(i, i);
        }
        Date date2 = new Date();
        System.out.println("value of 521 "+st.get(4545));
        float diff = (date2.getTime()-date1.getTime())/1000;
        System.out.println("time took is :"+diff);
    
    }

}