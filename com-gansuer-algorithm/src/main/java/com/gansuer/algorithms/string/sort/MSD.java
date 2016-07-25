package com.gansuer.algorithms.string.sort;

/**
 * Created by Frank on 7/25/16.
 */
public class MSD {

    private static final int BITS_PER_BYTE = 8;
    private static final int BITS_PER_INT = 32;
    private static final int R = 256;   // extended ASCII alphabet size
    private static final int CUTOFF = 15; // cutoff to insertion sort

    private MSD() {
    }

    /**
     * Rearranges the array of extended ASCII strings in ascending order
     *
     * @param a the array to be sorted
     */
    public static void sort(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, 0, n - 1, 0, aux);
    }

    //sort from a[low] to a[high], starting at the dth character
    private static void sort(String[] a, int low, int high, int d, String[] aux) {

        // cutoff to insertion sort for small subarrays
        if (high <= low + CUTOFF) {
            insertion(a, low, high, d);
            return;
        }

        // compute frequency counts
        int[] count = new int[R + 2];
        for (int i = low; i <= high; i++) {
            int c = charAt(a[i], d);
            count[c + 2]++;
        }
        //transform frequency to indicies
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        //distribute
        for (int i = low; i <= high; i++) {
            int c = charAt(a[i], d);
            aux[count[c + 1]++] = a[i];
        }
        //copy back
        for (int i = low; i <= high; i++) {
            a[i] = aux[i - low];
        }

        //recursively sort for each character (excludes sentinel -1 )
        for (int r = 0; r < R; r++) {
            sort(a, low + count[r], low + count[r + 1] - 1, d + 1, aux);
        }
    }

    // return the dth character of string, -1 if d = length of string
    private static int charAt(String string, int d) {
        assert d >= 0 && d <= string.length();
        if (d == string.length()) return -1;
        return string.charAt(d);
    }

    // insertion sort a[low ... high] ,starting at dth character
    private static void insertion(String[] a, int low, int high, int d) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1], d); j--)
                swap(a, j, j - 1);
        }
    }

    private static boolean less(String a, String b, int d) {
        int len = Math.min(a.length(), b.length());
        for (int i = d; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) return a.charAt(i) < b.charAt(i);
        }
        return a.length() < b.length();
    }

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /********************
     * integer arrays
     ******************************/

    public static void sort(int[] a) {
        int n = a.length;
        int[] aux = new int[n];
        sort(a, 0, n - 1, 0, aux);
    }

    private static void sort(int[] a, int low, int high, int d, int[] aux) {

        if (high <= low + CUTOFF) {
            insertion(a, low, high, d);
            return;
        }

        //compute frequency counts (need R = 256)
        int[] count = new int[R + 1];
        int mask = R - 1; //0xFF
        int shift = BITS_PER_INT - BITS_PER_BYTE * d - BITS_PER_BYTE;

        for (int i = low; i <= high; i++) {
            int c = (a[i] >> shift) & mask;
            count[c + 1]++;
        }
        //transform counts to indicies
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }
        //distribute
        for (int i = low; i <= high; i++) {
            int c = (a[i] >> shift) & mask;
            aux[count[c]++] = a[i];
        }

        //copy back
        for (int i = low; i <= high; i++)
            a[i] = aux[i - low];
        // no more bits
        if (d == 4) return;

        //recursively sort for each character
        if (count[0] > 0)
            sort(a, low, low + count[0] - 1, d + 1, aux);
        for (int r = 0; r < R; r++)
            if (count[r + 1] > count[r])
                sort(a, low + count[r], low + count[r + 1] - 1, d + 1, aux);
    }

    private static void insertion(int[] a, int low, int high, int d) {
        for (int i = low; i <= high; i++)
            for (int j = i; j > low && a[j] < a[j - 1]; j--)
                swap(a, j, j - 1);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
