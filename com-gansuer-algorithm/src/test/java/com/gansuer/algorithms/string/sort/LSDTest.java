package com.gansuer.algorithms.string.sort;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Frank on 7/21/16.
 */
public class LSDTest {

    private String fileName = "string/words3.txt";

    private String[] input;

    @Before
    public void setUp() throws Exception {
        List<String> list = FileUtils.readFile(this.getClass().getClassLoader().getResource
                (fileName).getFile());
        List<String> temp = new ArrayList<>();
        list.forEach(str -> temp.addAll(Arrays.asList(str.trim().split(" "))));
        temp.forEach(item -> System.out.print(item + " "));
        input = temp.toArray(new String[temp.size()]);
        System.out.println();
        System.out.println(" ----------set up end---------- ");
    }

    @Test
    public void sort() throws Exception {

        String[] temp = Arrays.copyOf(input, input.length);
        Arrays.sort(temp);
        LSD.sort(input, 3);
        for (String s : input) {
            System.out.print(s + " ");
        }
        System.out.println();
        Assert.assertArrayEquals(temp, input);

    }

    @Test
    public void sort1() throws Exception {
        int[] arrs = {34,2,77,12,45,99,5,0,23};
        int[] temp = Arrays.copyOf(arrs,arrs.length);
        Arrays.sort(temp);
        LSD.sort(arrs,2);
        Assert.assertArrayEquals(temp,arrs);
    }
}