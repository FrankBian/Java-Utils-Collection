package com.gansuer.leetcode;

public class Solution1 {

    /**
     * Runtime : 432 ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int index1 = -1, index2 = -1 , tmp = -1;
        for (int i =0 ;i < nums.length ; i++){
            index1 = i ;
            tmp = target - nums[index1] ;
            for (int j=0 ; j< nums.length ; j++){
                if (nums[j] == tmp && j != index1){
                    index2 = j ;
                    break;
                }
            }
            if (index2 >= 0){
                return ++index1 < ++index2 ? new int[]{index1 , index2} : new int[]{index2 , index1} ;
            }
        }

        return null;
    }

    /**
     * Runtime : 452ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int index1 = -1, index2 = -1 , tmp = -1;
        for (int i =0;i < nums.length -1 ; i++){
            index1 = i ;
            tmp = target - nums[index1] ;
            for (int j=i+1; j< nums.length ; j++){
                if (nums[j] == tmp){
                    index2 = j ;
                    break;
                }
            }
            if (index2 >= 0){
                return ++index1 < ++index2 ? new int[]{index1 , index2} : new int[]{index2 , index1} ;
            }
        }

        return null;
    }

    public static void main(String[] args){

        Solution1 solution1 = new Solution1();
        int[] res = solution1.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("(index1, index2) : (" + res[0] + "," + res[1] +")");
    }
}