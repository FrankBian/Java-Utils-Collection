package com.gansuer.common.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Frank on 5/9/15.
 */
public class ChineseSortUtil {
    /**
     * sort the chinese list
     *
     * @param list unsorted list
     */
    public static void chineseList(List<String> list) {
        Collections.sort(list, new ChineseCompator());
    }


    public static void chineseArray(String[] arrs) {
        Arrays.sort(arrs, new ChineseCompator());
    }
}
