package com.test.algos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {


    @Test
    @DisplayName("冒泡排序")
    public void test01() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{ 2, 9,4, 5, 7, 8, 3, 1,6};
        bubbleSort(input);
        System.out.println(Arrays.toString(input));





    }

    public void bubbleSort(int[] in){
        int length = in.length;
        for (int i = 0; i <= length - 2; i++) {
            for (int j = 0; j <= length - i - 2; j++) {
                if (in[j] > in[j + 1]) {
                    int tmp = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = tmp;
                }
            }
        }


    }



    @Test
    @DisplayName("归并排序")
    public void test02() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{2, 9, 4, 5, 7, 8, 3, 1, 6};
        mergeSort(input,0,input.length-1);
        System.out.println(Arrays.toString(input));



    }

    public void mergeSort(int[] nums, int l, int r) {
        if(l>=r){
            return;
        }

        int m = (r + l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        int[] tmp = new int[r - l+1];

        for (int k = l; k <= r ; k++) {
            tmp[k - l] = nums[k];
        }
        int i = 0;
        int j = m-l+1;//如果是右半边的数组，那么只有这样才能知道它在临时数组中的位置
        for (int k = l; k <= r; k++) {
            if(i==m-l+1){
                nums[k] = tmp[j++];
            }else if(j == r-l+1||tmp[i]<tmp[j]){
                nums[k] = tmp[i++];
            }else {
                nums[k] = tmp[j++];
            }

        }

    }


    @Test
    @DisplayName("快速排序")
    public void test03() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] input = new int[]{2, 9, 4, 5, 7, 8, 3, 1, 6};
        quickSort(input,0,input.length-1);
        System.out.println(Arrays.toString(input));



    }

    void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(nums, left, right);

        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot+1, right);


    }
    
    
    
    /* 元素交换 */
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        while(i<j){
            while(i<j&&nums[left]<=nums[j]){
                j--;
            }
            while(i<j&&nums[left]>=nums[i]){
                i++;
            }
            swap(nums,i,j);
        }
        swap(nums, i, left);
        return i;
    }




}
