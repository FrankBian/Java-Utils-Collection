package com.gansuer.algorithms.string.sort;

import com.gansuer.algorithms.stdlib.StdRandom;

/**
 * Created by Frank on 7/25/16.
 */
public class Quick3String {

    private static final int CUTOFF = 15; //  cutoff to insertion sort

    private Quick3String() {
    }

    public static void sort(String[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1, 0);

        assert isSorted(a);
    }

    private static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }
        return true;
    }

    private static void sort(String[] a, int low, int high, int d) {
        if (high <= low + CUTOFF) {
            insertion(a, low, high, d);
            return;
        }

        int lt = low, gt = high;
        int v = charAt(a[low], d);
        int i = low + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) swap(a, lt++, i++);
            else if (t > v) swap(a, i, gt--);
            else i++;
        }

        //a[low .. lt-1] < v = a[lt...gt] < a[gt+1...high]
        sort(a, low, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d);
        sort(a, gt + 1, high, d);
    }

    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }

    private static void insertion(String[] a, int low, int high, int d) {
        for (int i = low; i <= high; i++)
            for (int j = i; j > low && less(a[j], a[j - 1], d); j--)
                swap(a, j, j - 1);
    }

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(String a, String b, int d) {
        assert a.substring(0, d).equals(b.substring(0, d));

        for (int i = d; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) return a.charAt(i) < b.charAt(i);
        }
        return a.length() < b.length();
    }

}
