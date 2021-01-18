/**
 *  For additional documentation on this implementation of insertion sort,
 *  see <a href="https://algs4.cs.princeton.edu/21elementary">Section 2.1</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Insertion {
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static final void sort(int[] a) {
        sort(a, 0, a.length-1);
    }

    /**
     * Rearranges the subarray a[lo..hi] in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param lo left endpoint (inclusive)
     * @param hi right endpoint (inclusive)
     */
    public static final void sort(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            // Insert a[i] into a[lo..i-1].
            int value = a[i];
            int j = i;
            while (j > lo && a[j-1] > value) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = value;
        }

        assert(isSorted(a, lo, hi));
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    public static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    public static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++)
            if (!(a[i + 1] >= a[i]))
                return false;
        return true;
    }

    // This class should not be instantiated.
    private Insertion() { }

}
