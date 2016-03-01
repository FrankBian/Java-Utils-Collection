package com.gansuer.file;

import com.gansuer.others.JavaSourceCodeAnalysisHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Frank on 6/21/15.
 */
public class JavaSourceCodeAnalysisHelperTest {

    private String path = "";
    private JavaSourceCodeAnalysisHelper helper = null;

    @Before
    public void setUp() throws Exception {
        path = "/Users/Frank/Desktop/JDK-SRC/src/java/util";
        helper = new JavaSourceCodeAnalysisHelper();

    }

    @Test
    public void testRun() throws Exception {
        helper.run(path);

        Map<String, Map<String, Set<String>>> result = helper.getResult();
        Map<String, String> exceptions = helper.getExceptions();
        Map<String, String> classTypeMap = helper.getClassTypeMap();
        List<Map<File, Boolean>> files = helper.getFiles();

        Assert.assertNotNull(helper);
        Assert.assertNotNull(result);
        Assert.assertNotNull(exceptions);
        Assert.assertNotNull(classTypeMap);
        Assert.assertNotNull(files);
    }

    @Test
    public void testHandleJavaSource() throws Exception {
        path += "/RegularEnumSet.java";

        File file = new File(path);
        helper.handleJavaSource(file, null, null);
    }


    @Test
    public void testHelper() throws Exception {
        String target = "class RegularEnumSet<E extends Enum<E>> extends EnumSet<E> {";
        int extend = target.lastIndexOf("extends");


        System.out.println(target.substring(0, extend));

        Assert.assertTrue(extend > 0);
    }
}