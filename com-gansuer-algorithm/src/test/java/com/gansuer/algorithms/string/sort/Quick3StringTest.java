package com.gansuer.algorithms.string.sort;

import com.gansuer.common.util.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Frank on 7/25/16.
 */
public class Quick3StringTest {
    private String[] input;

    @Before
    public void setUp() throws Exception {
        List<String> list = FileUtils.readFile(this.getClass().getClassLoader().getResource
                ("string/shells.txt").getFile());
        List<String> res = new ArrayList<>();
        list.forEach(item -> res.addAll(Arrays.asList(item.trim().split(" "))));
        input = res.toArray(new String[res.size()]);
    }

    @Test
    public void sort() throws Exception {
        String[] temp = Arrays.copyOf(input, input.length);

        Arrays.sort(temp);
        Quick3String.sort(input);

        Assert.assertArrayEquals(temp, input);
    }

}