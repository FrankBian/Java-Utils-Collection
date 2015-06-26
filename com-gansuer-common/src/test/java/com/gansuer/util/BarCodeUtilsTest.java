package com.gansuer.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by Frank on 6/26/15.
 */
public class BarCodeUtilsTest {

    private String paike = "http://paike.yunxiao.com";
    private String baidu = "https://www.baidu.com";


    private String destPath = "/Users/Frank/Desktop/inputFile" ;
    @Test
    public void testEncode() throws Exception {
        BarCodeUtils.BarCodeConfig config = new BarCodeUtils.BarCodeConfig();
        config.QRCODE_SIZE = 150 ;
        BarCodeUtils.config = config;
        BarCodeUtils.encode(paike,"abv",destPath);
    }

    @Test
    public void testEncode1() throws Exception {
        BarCodeUtils.BarCodeConfig config = new BarCodeUtils.BarCodeConfig();
        config.QRCODE_SIZE = 150 ;
        config.FORMAT_NAME = "PNG";
        BarCodeUtils.config = config;
        BarCodeUtils.encodeNotLogo(paike, "abv", destPath);
    }

    @Test
    public void testEncode2() throws Exception {
        BarCodeUtils.BarCodeConfig config = new BarCodeUtils.BarCodeConfig();
        config.QRCODE_SIZE = 120 ;
        config.FORMAT_NAME = "JPG";
        BarCodeUtils.config = config;
        BarCodeUtils.encode(paike,"abfdfd",null,destPath);
    }

    @Test
    public void testEncode3() throws Exception {
        BarCodeUtils.BarCodeConfig config = new BarCodeUtils.BarCodeConfig();
        config.QRCODE_SIZE = 150 ;
        config.FORMAT_NAME = "PNG";
        BarCodeUtils.config = config;
        BarCodeUtils.encode(paike,"logoAbc",destPath+File.separator + "logo.png" ,destPath);
    }

    @Test
    public void testEncode4() throws Exception {
        BarCodeUtils.BarCodeConfig config = new BarCodeUtils.BarCodeConfig();
        config.QRCODE_SIZE = 150 ;
        config.FORMAT_NAME = "PNG";
        BarCodeUtils.config = config;
        BarCodeUtils.encode(paike,"abv",destPath);
    }

    @Test
    public void testDecode() throws Exception {
        String res = BarCodeUtils.decode(destPath + File.separator + "abv.PNG");
        Assert.assertEquals(res, paike);
    }

    @Test
    public void testDecode1() throws Exception {
        String path = destPath + File.separator + "abv.PNG";
        String res = BarCodeUtils.decode(new File(path));
        Assert.assertEquals(res, paike);
    }
}