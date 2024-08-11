package com.test.algos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArratListTest {
    @Test
    public void testRm() {
        ArrayList res = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        for (int i = 0; i <= res.size() - 1; i++) {
            if (i == 4) {
                res.remove(i);
            }
//            虽然size在删除后会减少，但是i依然会指向原来数组的最后一个元素，所以会导致数组越界。
            System.out.println(res.get(i));
        }

    }

    @Test
    @DisplayName("输出：[1,3,5,2,4] ")
    public void testRm1() {
        int[] arr = {1, 2, 3, 4, 5};
//        第一个偶数
        int a = 0;
        int[] res = new int[arr.length];

        for (int i = 0; i <= arr.length - 1; i++) {
//            奇数
            if (arr[i] % 2 != 0) {
                res[a] = arr[i];
                a++;
            }

        }

        for (int i = 0; i <= arr.length - 1; i++) {
//            偶数
            if (arr[i] % 2 == 0) {
                res[a] = arr[i];
                a++;
            }
        }

        System.out.println(Arrays.toString(res));

    }

    @Test
    @DisplayName("输出：[1,3,5,2,4] 双指针")
    public void testRm02() {
        int[] actions = {1, 2, 3, 4, 5};
//        第一个偶数
        int tmp = 0;
//j找奇数，i找偶数
        for (int i = 0, j =actions.length-1; i <j; i++,j--) {
//           i找偶数， 奇数就++
            for (; i <j ; ) {
                if (actions[i] % 2 != 0) {
                    i++;
                }else{
                    break;
                }
            }

            for (; i <j ; ) {
                //            j找奇数,偶数就--
                if (actions[j] % 2 == 0) {
                    j--;
                }else{
                    break;
                }
            }
            tmp = actions[i];
            actions[i] = actions[j];
            actions[j] = tmp;

        }


        System.out.println(Arrays.toString(actions));

    }


    @Test
    @DisplayName("文件组合 滑动窗口")
    public void test() {
        System.out.println(Arrays.deepToString(fileCombination(18)));
    }

    private int[][] fileCombination(int target) {
        int length = target / 2;
        List<int[]> res = new ArrayList<>();
//        左右边界和求和
        int i = 1, j = 2, s = 3;

        while(i<j){
            if (s == target) {
                int[] ints = new int[j - i + 1];
                for (int k = i; k <= j ; k++) {
                    ints[k-i] = k;
                }
                res.add(ints);
                s -= i;
                i++;
            }
            if (s > target) {
                s -= i;
                i++;
            }
            if (s < target) {
                j++;
                s += j;

            }
        }
        return  res.toArray(new int[0][]);
    }
    
    @Test
    @DisplayName("按规则计算统计结果")
    public void test01() {
//        输出：[1920, 960, 640, 480, 384]
        int[] inputs = {2, 4, 6, 8, 10};
        statisticalResult(inputs);
    }

    public int[] statisticalResult(int[] a) {
        //边界条件的判断
        if (a == null || a.length == 0)
            return a;
        int length = a.length;
        int[] res = new int[length];
        res[0] = 1;

        for (int i = 1; i <= res.length - 1; i++) {
            res[i] = res[i - 1] * a[i-1];
        }
        int right = 1;

        for (int i = res.length - 1; i >=0 ; i--) {
            res[i] = res[i] * right;
            right *= a[i];
        }
        return res;
    }
    
    @Test
    @DisplayName("螺旋遍历二维数组")
    public void test02() {
        int[][] inputs = {{1,2,3},{8,9,4},{7,6,5}};
        System.out.println(Arrays.toString(spiralArray(inputs)));
    }


    public int[] spiralArray(int[][] array) {
        if(array.length == 0) return new int[0];
        int l = 0, r = array[0].length - 1, t = 0, b = array.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = array[t][i]; // left to right
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = array[i][r]; // top to bottom
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = array[b][i]; // right to left
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = array[i][l]; // bottom to top
            if(++l > r) break;
        }
        return res;
    }

}
