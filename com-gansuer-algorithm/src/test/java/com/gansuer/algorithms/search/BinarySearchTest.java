package com.gansuer.algorithms.search;

import com.gansuer.debug.Debug;
import com.gansuer.file.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Frank on 4/17/15.
 */
public class BinarySearchTest {



    private static int[] target = {7,0,67,54,1,89,2,789,67} ;
    @Test
    public void testBinarySearch() throws Exception {
        Arrays.sort(target);

        int ret = BinarySearch.binarySearch(target,89,0,target.length);
//        int ret = BinarySearch.binarySearch(target,89,0,target.length-1);

        print(target);

        System.out.println(ret);

        Assert.assertTrue(ret>0);

    }

    @Test
    public void testBinarySearchByLoop() throws Exception {
        Arrays.sort(target);

//        int ret = BinarySearch.binarySearchByLoop(target,89,0,target.length-1);
        int ret = BinarySearch.binarySearchByLoop(target, 89, 0, target.length);

        print(target);

        System.out.println(ret);

        Assert.assertTrue(ret>0);
    }

    @Test
    public void testBinarySearch1() throws Exception {
        Arrays.sort(target);

//        int ret = BinarySearch.binarySearchByLoop(target,89,0,target.length-1);
        int ret = BinarySearch.binarySearch(target, 89);

        print(target);

        System.out.println(ret);

        Assert.assertTrue(ret>0);
    }

    private static void print(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i] + "   ");
        }
        System.out.println();
    }

    private static int forceSearch(int[] src ,int key){
        for (int i = 0;i< src.length;i++){
            if (src[i] == key){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testBinary2Force(){
//        int key = 999722;
//        String fileName = "binarySearch/largeT.txt";
        int key = 967386;
        String fileName = "binarySearch/largeW.txt";
        List<String> date = new ArrayList<String>();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Date time1 =new Date();
            List<String> txt = FileUtils.readFile(classLoader.getResource(fileName).getFile());
            Date time2 = new Date();
            date.add("Finished file reading : " + (time2.getTime() - time1.getTime()));
            int[] src = new int[txt.size()];
            for (int i=0;i<txt.size(); i++){
                src[i] = Integer.parseInt(txt.get(i).trim());
            }
            Date time3 = new Date();
            date.add("Convert String List to Integer Array [finished] : " + (time3.getTime() - time2.getTime()));
            Arrays.sort(src);
            Date time4 = new Date();
            date.add("Integer Array Sorting [finished] : " + (time4.getTime() - time3.getTime()));

            int ret = BinarySearch.binarySearch(src, key);
            Date time5 = new Date();
            date.add("Binary Search [finished] : "+(time5.getTime() - time4.getTime()));

            int ret2 = forceSearch(src,key);
            Date time6 = new Date();
            date.add("Force Search [finished] : " +(time6.getTime() - time5.getTime()));

            date.add("Binary Search Result = " +ret);
            date.add("Force Search Result = " +ret2);
            date.add("Array[index] = " +src[ret]);

            Debug.println(date);

            Assert.assertEquals(ret, ret2);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}