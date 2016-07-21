package com.gansuer.algorithms.string.sort;

/**
 * Radix Sort
 * Least Significant Digit first
 * LSD radix sort
 * <p>
 * - Sort a String[] array of n extended ASCII strings (R = 256), each of length w.
 * <p>
 * - Sort an int[] array of n 32-bit integers, treating each integer as
 * a sequence of w = 4 bytes (R = 256).
 * <p>
 * Uses extra space proportional to n + R.
 * <p>
 * Created by Frank on 7/21/16.
 */
public class LSD {

    private static final int BITS_PER_BYTE = 8;


    /**
     * Rearrange the array of W-characters strings in ascending order
     *
     * @param strs the array to be sorted
     * @param w    the number of characters per string
     */
    public static void sort(String[] strs, int w) {
        int len = strs.length;
        int r = 256; // ASCII 256
        String[] aux = new String[len];
        for (int index = w - 1; index >= 0; index--) {
            // sorted bt key-indexed counting on the index character

            // compute frequency counts
            int[] count = new int[r + 1];
            for (int i = 0; i < len; i++) {
                count[strs[i].charAt(index) + 1]++;
            }

            // compute cumulates
            for (int i = 0; i < r; i++) {
                count[i + 1] += count[i];
            }

            // move data
            for (int i = 0; i < len; i++) {
                aux[count[strs[i].charAt(index)]++] = strs[i];
            }

            for (int i = 0; i < len; i++) {
                strs[i] = aux[i];
            }
        }

    }

    /**
     * Rearranges the array of 32-bit integers in ascending order
     * This is about 2-3x faster than Arrays.sort()
     *
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        final int BITS = 32;                   // each int is 32 bits
        final int R = 1 << BITS_PER_BYTE;      // each bytes is between 0 and 255
        final int MASK = R - 1;   // 0xFF
        final int w = BITS / BITS_PER_BYTE;   // each int is 4 bytes

        int n = a.length;
        int[] aux = new int[n];

        for (int d = 0; d < w; d++) {

            // compute frequency counts
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
                count[c + 1]++;
            }

            // compute cumulates
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == w - 1) {
                int shift1 = count[R] - count[R / 2];
                int shift2 = count[R / 2];
                for (int r = 0; r < R / 2; r++)
                    count[r] += shift1;
                for (int r = R / 2; r < R; r++)
                    count[r] -= shift2;
            }

            //move data
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
                aux[count[c]++] = a[i];
            }
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }

    /**
     * @param arr
     * @param d   , the length of the Max in the array
     */
    public static void sort(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[n];
        int mod = 1, cLen = 10;
        for (int i = 0; i < d; i++) {

            int[] count = new int[cLen + 1];
            for (int j = 0; j < n; j++) {
                count[(arr[j] / mod) % 10 + 1]++;
            }

            for (int j = 0; j < cLen; j++) {
                count[j + 1] += count[j];
            }

            for (int j = 0; j < n; j++) {
                temp[count[arr[j] / mod % 10]++] = arr[j];
            }

            for (int j = 0; j < n; j++) {
                arr[j] = temp[j];
            }

            mod *= 10;
        }

    }
}
