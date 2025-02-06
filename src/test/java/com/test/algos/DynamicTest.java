package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
