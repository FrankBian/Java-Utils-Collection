package com.gansuer.common.util;

import com.gansuer.common.debug.Debug;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Frank on 5/9/15.
 */
public class ChineseSortUtilTest {
    private List<String> src = null;

    private ChineseComparator comparator;

    @Before
    public void setUp() throws Exception {
        src = new ArrayList<>();
        src.add("暗金");
        src.add("恩来");
        src.add("日出");
        src.add("美好");
        src.add("无赖");
        src.add("无聊");
        src.add("不变");
        src.add("舞曲");
        src.add("哪呢");
        src.add("大大");
        src.add("考试");
        comparator = new ChineseComparator();
    }

    @Test
    public void testChineseList() throws Exception {
        Debug.print(src);

        ChineseSortUtil.chineseList(src);
        Debug.print(src);

        Assert.assertTrue(src != null);
        for (int i = 1; i < src.size(); i++) {
            Assert.assertTrue(comparator.compare(src.get(i), src.get(i - 1)) >= 0);
        }
    }

    @Test
    public void testChineseArray() throws Exception {
        String[] arr = new String[src.size()];
        int index = 0;
        for (String str : src) {
            arr[index++] = str;
        }
        ChineseSortUtil.chineseArray(arr);
        Debug.print(Arrays.asList(arr));

        for (index = 1; index < arr.length; index++) {
            Assert.assertTrue(comparator.compare(arr[index], arr[index - 1]) >= 0);
        }
    }
}