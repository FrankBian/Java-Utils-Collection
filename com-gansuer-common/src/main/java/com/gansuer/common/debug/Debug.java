package com.gansuer.common.debug;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * 常用的一些控制台输出的语句
 * <p>
 * Created by Frank on 4/17/15.
 */
public class Debug {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger("Debug");


    public static void println(String string) {
        System.out.println(string);
    }

    public static void println() {
        System.out.println();
    }

    public static void print(int[] nums) {
        for (int item : nums) {
            System.out.print(item + "   ");
        }
        System.out.println();
    }

    public static void print(int[] nums, int lineNumber) {
        for (int i = 0; i < nums.length; i++) {
            if (i % lineNumber == 0) {
                System.out.println();
            }
            System.out.print(nums[i] + "   ");
        }
        System.out.println();
    }

    public static void print(Object[] objs) {

        for (Object item : objs) {
            System.out.print(item.toString() + "   ");
        }
        System.out.println();
    }

    public static void print(Object[] objs, int lineNumber) {

        for (int i = 0; i < objs.length; i++) {
            if (i != 0 && i % lineNumber == 0) {
                System.out.println();
            }
            System.out.print(objs[i].toString() + "   ");
        }
        System.out.println();
    }

    public static void print(List<String> list) {
        for (String item : list) {
            System.out.print(item + "    ");
        }
        System.out.println();
    }

    public static void println(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static void print(List<String> list, int lineNumber) {
        for (int i = 0; i < list.size(); i++) {
            if (i != 0 && i % lineNumber == 0) {
                System.out.println();
            }
            System.out.print(list.get(i) + "    ");
        }
        System.out.println();
    }

    public static void logError(Object obj) {
        logger.error(obj);
    }

    public static void logWarning(Object obj) {
        logger.warn(obj);
    }

    public static void logInfo(Object obj) {
        logger.info(obj);
    }


}
