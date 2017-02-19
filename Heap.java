public class Heap<Key extends Comparable<Key>> {

    
    public Heap(){
    }

    private static boolean  less( Comparable[] a, int i,int j) {
        return a[i-1].compareTo(a[j-1]) > 0 ;
    }

    private static void exch(Comparable[] a, int i , int j){
        Comparable tmp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = tmp;
    }

    private static void sink(Comparable[] a , int k , int N){
        int j = 2*k ;
        while(2*k < N){
            if(j < N && less(a, j,j+1)) j++;
            if(!less(a, k,j)) break;
            exch(a, k, j);
            k=j;
        }
    }

    private static void swim(Comparable[] a, int k , int N){
        while(k > 1 && less(a,k/2,k)){
            exch(a,k , k/2);
            k = k/2;
        }
    }

    public static void sort(Comparable[] pq){
        int N = pq.length;
        for(int k = N/2 ; k >= 1 ; k-- ){
            sink(pq,k,N);
        }

        while(N > 1){
            exch(pq,1,N);
            sink(pq,1,--N);
        }
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = {"banna","apple","leeche","culted","apple"};
        Heap.sort(a);
        show(a);
    }

}