package com.test.algos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.*;

public class BacktrackTest {

    @Test
    @DisplayName("斐波那契数")
    public void test01() {

         int [] inputs = new int[]{3,1,5,8};

        int rs = maxCoins(inputs);
        System.out.println(rs);


    }

    public int[][] rec;
    public int[] val;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }


    @Test
    @DisplayName("全排列I")
    public void test02() {

        int [] choices = new int[]{3,1,2};
        boolean[] selected = new boolean[choices.length];
        for (int i = 0; i <= choices.length - 1; i++) {
            selected[i] = false;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        backtrack(new ArrayList<>(), choices, selected, res);

        System.out.println(res);

    }


    public void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res){

        if(state.size()==choices.length){
            res.add(new ArrayList<Integer>(state));
            return;
        }


        for (int i = 0; i <= choices.length - 1; i++) {
            if (!selected[i]) {
                state.add(choices[i]);
                selected[i] = true;
                backtrack(state, choices, selected, res);
                state.remove(state.size() - 1);
                selected[i] = false;
            }


        }




    }


}
