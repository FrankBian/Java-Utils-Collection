package com.gansuer.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Frank on 4/27/15.
 */
public class ChineseCompatorTest {

    private List<String> src = null;
    @Before
    public void setUp() throws Exception {
        src = new ArrayList<String>();
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
    }

    @Test
    public void testSortChinese(){
        for (String string : src){
            System.out.print(string + "   ");
        }

        Collections.sort(src, new ChineseCompator());

        System.out.println();
        System.out.println("sorted :  ");

        for (String string : src){
            System.out.print(string + "   ");
        }

        Assert.assertEquals(src.size(),11);
    }
}