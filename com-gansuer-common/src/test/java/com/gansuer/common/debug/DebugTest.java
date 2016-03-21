package com.gansuer.common.debug;

import org.junit.Test;

/**
 * Created by Frank on 4/17/15.
 */
public class DebugTest {

    @Test
    public void testPrint() throws Exception {
        String[] src = {"a", "tyu", "bnn"};
        Debug.print(src);
        int[] src1 = {1, 2, 3};
        Debug.print(src1);


    }
}