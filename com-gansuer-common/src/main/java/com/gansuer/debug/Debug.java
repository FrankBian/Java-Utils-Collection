package com.gansuer.debug;

import java.util.logging.Logger;

/**
 * 常用的一些控制台输出的语句
 *
 * Created by Frank on 4/17/15.
 */
public class Debug {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger("Debug");


    public void println(String string){
        System.out.println(string);
    }

    public void println(){
        System.out.println();
    }

    public void print(int[] nums){
        for(int i=0;i<nums.length ; i++){
            System.out.print(nums[i] + "   ");
        }
        System.out.println();
    }

    public void print(int[] nums, int seperator ){
        for(int i=0;i<nums.length ; i++){
            if ( i%seperator == 0){
                System.out.println();
            }
            System.out.print(nums[i] + "   ");
        }
        System.out.println();
    }

    public void print(Object[] objs){

        for(int i=0;i<objs.length ; i++){
            System.out.print(objs[i].toString() + "   ");
        }
        System.out.println();
    }

    public void print(Object[] objs , int seperator){

        for(int i=0;i<objs.length ; i++){
            if ( i%seperator == 0){
                System.out.println();
            }
            System.out.print(objs[i].toString() + "   ");
        }
        System.out.println();
    }


}
