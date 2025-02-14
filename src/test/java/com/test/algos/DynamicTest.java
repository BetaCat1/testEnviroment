package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.test.algos.TreeNodeTest.decorateRecord;

public class DynamicTest {


    @Test
    @DisplayName("戳气球")
    public void test01() {
        int [] inputs = new int[]{3,1,5,8};
//        int [] inputs = new int[]{3,8};

        int rs = maxCoins(inputs);
        System.out.println(rs);

    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        //i取倒数第三个开始，一步步向前
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

    @Test
    @DisplayName("斐波那切数列")
    public void test02() {
        System.out.println(fib(1000));

    }


    public int fib(int n) {

        if (n < 1) {
            return -1;
        }

        if(n==1||n==2){
            return n;
        }



        int current = 0;
        int previous = 2;
        int prepre = 1;
        int i = 3;
        while (i <= n) {
            current = previous + prepre;
            prepre = previous;
            previous = current;
            i++;
        }

        return current;

    }

//    public int dismantlingAction(String arr) {
//        if(arr.equals(""))return 0;
//        Map<Character, Integer> dic = new HashMap<>();
//        int res = 0, left = -1, len = arr.length();
//        int[] dp = new int[len];
//        dp[0]=1;
//        dic.put(arr.charAt(0), 0);
//        for(int j = 1; j < len; j++) {
//            int i = dic.getOrDefault(arr.charAt(j), -1); // 获取索引 i
//            dic.put(arr.charAt(j), j); // 更新哈希表
//            //if(i==-1) i=0; // dp[j - 1] -> dp[j]维护一个绝对左边界
//            if(i!=-1&&i<left)i=left;
//            if(i!=-1)left=i;
//            dp[j] = Math.max(dp[j-1], j - left); // max(dp[j - 1], j - i)
//        }
//        return dp[len-1];
//    }

    @Test
    @DisplayName("招式拆解 I")
    public void test04() {

        System.out.println(dismantlingAction(
                "abcabd"));

    }

    public int dismantlingAction(String arr) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0, len = arr.length();
        for(int j = 0; j < len; j++) {
            int i = dic.getOrDefault(arr.charAt(j), -1); // 获取索引 i
            dic.put(arr.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]  他这里是把绝对左边界放在dp表里了
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
