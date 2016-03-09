package com.gansuer.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Frank on 7/28/15.
 */
public class PinyinConverterTest {

    @Test
    public void testChinese2Pinyin() throws Exception {
        String src = "曹孟德";
        String[] res = PinyinConverter.chinese2Pinyin(src, 0);

        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.length);
        Assert.assertEquals("caomengde", res[0]);

        src = "曹孟z德";

        res = PinyinConverter.chinese2Pinyin(src, 0);
        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.length);
        Assert.assertEquals("caomengzde", res[0]);

        src = "FrankBian";

        res = PinyinConverter.chinese2Pinyin(src, 0);
        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.length);
        Assert.assertEquals("FrankBian", res[0]);

        src = "单春秋";
        res = PinyinConverter.chinese2Pinyin(src, 0);
        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.length);
        Assert.assertEquals("danchunqiu", res[0]);
        Assert.assertEquals("chanchunqiu", res[1]);
        Assert.assertEquals("shanchunqiu", res[2]);


        src = "曹孟德";
        res = PinyinConverter.chinese2Pinyin(src, 1);

        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.length);
        Assert.assertEquals("cmd", res[0]);

        src = "曹孟z德";

        res = PinyinConverter.chinese2Pinyin(src, 1);
        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.length);
        Assert.assertEquals("cmzd", res[0]);

        src = "Frank Bian";

        res = PinyinConverter.chinese2Pinyin(src, 1);
        Assert.assertNotNull(res);
        Assert.assertEquals(1, res.length);
        Assert.assertEquals("FrankBian", res[0]);

        src = "单春秋";
        res = PinyinConverter.chinese2Pinyin(src, 1);
        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.length);
        Assert.assertEquals("dcq", res[0]);
        Assert.assertEquals("ccq", res[1]);
        Assert.assertEquals("scq", res[2]);
    }
}