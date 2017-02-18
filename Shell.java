import java.util.Comparator;

public class Shell {

    private Shell() { }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        while(h >= 1){
            for (int i = h; i < N; i++) 
            {
                for (int j = h; (j >= h && less(a[j], a[j-h]) ) ; j--) {
                     exch(a,j,j-h);
                }
            }
            h= h/3;
        }
    }

    public static void sort(Object[] a, Comparator c) {
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        while(h >= 1){
            for (int i = h; i < N; i++) 
            {
                for (int j = h; (j >= h && less(c,a[j], a[j-h]) ) ; j--) {
                     exch(a,j,j-h);
                }
            }
            h= h/3;
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
        String[] a = {"banna","apple","leeche","culted"};
       //Shell.sort(a);
        Shell.sort(a,new SizeComparator());
        show(a);
    }
}


class SizeComparator implements Comparator<String> {
	@Override
	public int compare(String tv1, String tv2) {
        return tv1.compareTo(tv2);
	}
}