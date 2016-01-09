package com.gansuer.debug;

import org.junit.Test;

/**
 * Created by Frank on 4/17/15.
 */
public class DebugTest {

    @Test
    public void testPrint() throws Exception {
        Debug deg = new Debug();
        String[] src = {"a", "tyu", "bnn"};
        deg.print(src);
        int[] src1 = {1, 2, 3};
        deg.print(src1);


    }
}