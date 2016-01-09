package com.gansuer.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Frank on 8/2/15.
 */
public class QuickSortTest {

    private QuickSort sort;

    @Before
    public void setUp() throws Exception {
        sort = new QuickSort();
    }

    @Test
    public void testSort() throws Exception {
        String s = "MERGESORTEXAMPLE";
        String[] arr = new String[s.length()];
        int index = 0;
        for (char ch : s.toCharArray()) {
            arr[index] = s.charAt(index) + "";
            index++;
        }

        sort.sort(arr);
        sort.show(arr);

    }
}