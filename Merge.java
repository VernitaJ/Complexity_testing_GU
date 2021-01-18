/**
 *  For additional documentation on this implementation of merge sort,
 *  see <a href="https://algs4.cs.princeton.edu/22mergesort">Section 2.2</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Merge {
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static final void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
        assert Insertion.isSorted(a);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static final void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        merge(a, aux, lo, mid, hi);
    }

    // stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi]
    private static final void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // precondition: a[lo..mid] and a[mid+1..hi] are sorted subarrays
        assert Insertion.isSorted(a, lo, mid);
        assert Insertion.isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)         a[k] = aux[j++];
            else if (j > hi)          a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else                      a[k] = aux[i++];
        }

        // postcondition: a[lo..hi] is sorted
        assert Insertion.isSorted(a, lo, hi);
    }

    // This class should not be instantiated.
    private Merge() { }
}
