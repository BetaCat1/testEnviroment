package com.test.algos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class OnehunderdProblem {

    @Test
    @DisplayName("两数之和")
    public void test01() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{ 2,7,11,15};

        int target = 9;
        int[] res = twoSum(input, target);

        System.out.println(Arrays.toString(res));







    }


    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int length = nums.length;
        for (int i = 0; i <= length - 1; i++) {
            //如果缓存中有就返回
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }


}
