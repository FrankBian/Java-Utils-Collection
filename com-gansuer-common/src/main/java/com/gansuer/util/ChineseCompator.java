package com.gansuer.util;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * 用作中文排序的Comparator
 * Created by Frank on 4/27/15.
 */
public class ChineseCompator implements Comparator<String> {

    private static Collator cmp = Collator.getInstance(Locale.CHINA);

    public int compare(String o1, String o2) {

        if (cmp.compare(o1,o2) > 0){
            return 1;
        }else if (cmp.compare(o1,o2) < 0){
            return -1;
        }else {
            return 0 ;
        }
    }
}
