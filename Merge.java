import java.util.Comparator;

public class Merge {

    private Merge() { }
    
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length - 1);
    }

    private static void sort(Comparable[] a,Comparable[] aux, int lo , int hi) {
        if(hi <= lo ) return;
        int mid = lo + (hi - lo )/2;
        sort(a,aux,lo,mid);
        sort(a, aux , mid+ 1 , hi);
        merge(a,aux,lo,mid,hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux ,int lo , int mid ,int hi){
        for(int k =lo;k<=hi;k++){
            aux[k] = a[k];
        }

        int i= lo;
        int j=mid+1;

        for(int k = lo ; k<= hi ;k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if( less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    
    public static void sort(Object[] a, Comparator c) {
        Object[] aux = new Object[a.length];
        sort(c,a,aux,0,a.length - 1);
    }

    private static void sort(Comparator c,Object[] a,Object[] aux, int lo , int hi) {
        if(hi <= lo ) return;
        int mid = lo + (hi - lo )/2;
        sort(c,a,aux,lo,mid);
        sort(c,a, aux , mid+ 1 , hi);
        merge(c,a,aux,lo,mid,hi);
    }

    private static void merge(Comparator c,Object[] a, Object[] aux ,int lo , int mid ,int hi){
        for(int k =lo;k<=hi;k++){
            aux[k] = a[k];
        }

        int i= lo;
        int j=mid+1;

        for(int k = lo ; k<= hi ;k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if( less(c,aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }    

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }
        
        

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
        
    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator c) {
        return isSorted(a, c, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(c, a[i], a[i-1])) return false;
        return true;
    }



    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them; 
     * and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = {"banna","apple","leeche","culted","apple"};
        //Merge.sort(a);
        Merge.sort(a,new SizeComparator());
        show(a);
    }
}


class SizeComparator implements Comparator<String> {
	@Override
	public int compare(String tv1, String tv2) {
        return tv1.compareTo(tv2);
	}
}