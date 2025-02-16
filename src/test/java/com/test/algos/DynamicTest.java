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


    @Test
    @DisplayName("编辑距离")
    public void test05() {

        System.out.println(editDistanceDP("c","abc"));

    }


    /* 编辑距离：动态规划 */
    int editDistanceDP(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        // 状态转移：首行首列
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }
        // 状态转移：其余行和列
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 若两字符相等，则直接跳过此两字符
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 最少编辑步数 = 插入、删除、替换这三种操作的最少编辑步数 + 1  这能预见未来的？
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];
    }


    @Test
    @DisplayName("连续天数的最高销售额")
    public void test06() {


//        int[] sales = new int[]{5,4,-1,7,8};
//        int[] sales = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] sales = new int[]{8,-19,5,-4,20};

        System.out.println(maxSales(sales));


    }



    public int maxSales(int[] sales) {

        int length = sales.length;


        int res = sales[0];
//        int flag = sales[0];
        int flag = sales[0];


        for (int i = 1; i <= length - 1; i++) {
            if(flag<=0){
                flag = sales[i];

            }else {
                flag += sales[i];

            }
            res = Math.max(res, flag);

        }
        return res;



    }


    @Test
    @DisplayName("买卖芯片的最佳时机")
    public void test07() {

        int[] prices = new int[]{3, 6, 2, 9, 8, 5};

        System.out.println(bestTiming(prices));

    }


    public int bestTiming(int[] prices) {

        int length = prices.length;
        if(length<=1){
            return 0;
        }
        int res = 0;

        int[] dp = new int[length];

        int cost = prices[0];
        for (int i = 1; i <=length -1; i++) {
            cost = Math.min(cost, prices[i]);
            dp[i] =  prices[i ]- cost;
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
