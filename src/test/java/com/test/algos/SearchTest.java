package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
