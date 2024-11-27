package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class SearchTest {

    @Test
    @DisplayName("二分查找")
    public void test01() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(input,10));

    }

    public int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1,m;
        while(i<=j){
            m = i + (j - i) / 2;
            if(nums[m]<target){
                i = m + 1;
            }
            if(nums[m]>target){
                j = m - 1;
            }
            if(nums[m]==target){
                return m;
            }
        }
        return -1;
    }

    /* 二分查找插入点（无重复元素） */
    public int binarySearchInsertionSimple(int[] nums, int target) {
        int i = 0, j = nums.length - 1,m;
        while(i<=j){
            m = i + (j - i) / 2;
            if(nums[m]<target){
                i = m + 1;
            }
            if(nums[m]>target){
                j = m - 1;
            }
            if(nums[m]==target){
                return m;
            }
        }
        return i;
    }

    /* 二分查找插入点（存在重复元素） */
    public int binarySearchInsertion(int[] nums, int target) {
        int i = 0, j = nums.length - 1,m;
        while(i<=j){
            m = i + (j - i) / 2;
            if(nums[m]<target){
                i = m + 1;
            }
            if(nums[m]>target){
                j = m - 1;
            }
            if(nums[m]==target){
//                i = m + 1;找右边界
                j = m - 1;
            }
        }
        return i;
    }

    public int binarySearchInsertionRight(int[] nums, int target) {
        int i = 0, j = nums.length - 1,m;
        while(i<=j){
            m = i + (j - i) / 2;
            if(nums[m]<target){
                i = m + 1;
            }
            if(nums[m]>target){
                j = m - 1;
            }
            if(nums[m]==target){
                i = m + 1;
            }
        }
        return i;
    }


    @Test
    @DisplayName("找边界")
    public void test02() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 6, 6, 9};
        System.out.println(binarySearchInsertion(input,6));

    }


    @Test
    @DisplayName("招式拆解II")
    public void test03() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(input,10));

    }

    public char dismantlingAction(String arr) {
        char[] chars = arr.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char a : chars) {
            map.put(a, !map.containsKey(a));

        }
        for (char a : chars){
            if(map.get(a)){
                return a;
            }
        }
        return ' ';
    }


    @Test
    @DisplayName("统计目标成绩的出现次数")
    public void test04() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8};
        int target = 1;
        System.out.println(countTarget(input,target));

    }

    public int countTarget(int[] scores, int target) {
        int left = binarySearchInsertion(scores, target);
        int right = binarySearchInsertionRight(scores, target);
        return right - left;
    }


    @Test
    @DisplayName("点名")
    public void test05() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{0,  2, 3, 4, 5, 6,7, 8};
        int target = 1;
        System.out.println(takeAttendance(input));

    }

    public int takeAttendance(int[] records) {
        int i = 0, j = records.length - 1;
        while (i<=j) {
            int m = i + (j - i) / 2;
            if(records[m]>m){//缺号在前[i,m-1]
                j = m - 1;
            }
            if(records[m]==m){//缺号在后[m+1,j]
                i = m + 1;
            }
        }
        return i;
    }


    @Test
    @DisplayName("寻找目标值 - 二维数组")
    public void test06() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[][] input = new int[][]{{2,3,6,8},{4,5,8,9},{5,9,10,12}};
        int target = 8;
        System.out.println(findTargetIn2DPlants(input,target));

    }


    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int i = plants.length - 1, j = 0;
        while(i>=0&&j<=plants[0].length-1){
            if(plants[i][j]>target){
                i--;
            }
            if(plants[i][j]<target){
                j++;
            }
            if(plants[i][j]==target){
                return true;
            }
        }
        return false;


    }




}
