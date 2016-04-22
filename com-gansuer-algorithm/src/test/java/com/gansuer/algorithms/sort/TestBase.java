package com.gansuer.algorithms.sort;

import com.gansuer.common.util.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Frank on 8/2/15.
 */
public class TestBase {

    private Map<Integer,String> map ;
    private String fileName = "binarySearch/largeT.txt";
    private List<String> list;

    @Before
    public void setUp() throws Exception {
        map = new HashMap<>();
        list = FileUtils.readFile(getClass().getClassLoader().getResource(fileName).getFile());
    }

    @Test
    public void put() throws Exception {
        Date begin = new Date();
        int index = 0;
        for (String item : list){
            map.put(index++,item);
        }
        Date end = new Date();
        System.out.println(end.getTime() - begin.getTime());
    }

}
