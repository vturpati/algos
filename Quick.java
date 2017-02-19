import java.util.Comparator;

public class Quick {

    private Quick() { }
    
    public static void sort(Comparable[] a) {
        //Randamise the array TBD

        sort(a,0,a.length - 1);
    }

    private static void sort(Comparable[] a, int lo , int hi) {
        if(hi <= lo ) return;
        Comparable v = a[lo];
        int i = lo;
        int lt = lo;
        int gt = hi;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if(cmp < 0 ) exch(a, i++ , lt++);
            else if( cmp > 0) exch(a, i, gt--);
            else i++;
        }

        sort(a, lo , lt -1);
        sort(a, gt +1 , hi);
    }
    
    public static void sort(Object[] a, Comparator c) {
        // Randomise the array TBD
        sort(c,a,0,a.length - 1);
    }

    private static void sort(Comparator c,Object[] a, int lo , int hi) {
        if(hi <= lo ) return;
        Object v = a[lo];
        int i = lo;
        int lt = lo;
        int gt = hi;
        while (i <= gt) {
            int cmp = c.compare(a[i],v);
            if(cmp < 0 ) exch(a, i++ , lt++);
            else if( cmp > 0) exch(a, i, gt--);
            else i++;
        }

        sort(c,a, lo , lt -1);
        sort(c,a, gt +1 , hi);
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
        Quick.sort(a);
        //Quick.sort(a,new SizeComparator());
        show(a);
    }
}


class SizeComparator implements Comparator<String> {
	@Override
	public int compare(String tv1, String tv2) {
        return tv1.compareTo(tv2);
	}
}