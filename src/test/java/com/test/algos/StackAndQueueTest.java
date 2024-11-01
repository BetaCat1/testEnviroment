package com.test.algos;

import com.test.datastructure.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StackAndQueueTest {

    @Test
    @DisplayName("验证图书取出顺序")
    public void test01() {
//        输入：putIn = [6,7,8,9,10,11], takeOut = [9,11,10,8,7,6]
//输出：true
//解释：我们可以按以下操作放入并拿取书籍：
//push(6), push(7), push(8), push(9), pop() -> 9,
//push(10), push(11),pop() -> 11,pop() -> 10, pop() -> 8, pop() -> 7, pop() -> 6
        int[] putIn  = new int[]{1,0,2};
        int[] takeOut  = new int[]{2,1,0};
//        int[] putIn  = new int[]{6,7,8,9,10,11};
//        int[] takeOut  = new int[]{9,11,10,8,7,6};
        System.out.println(validateBookSequences(putIn, takeOut));
    }

//    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
//        Deque<Integer> stack = new LinkedList<>();
//        int k = takeOut.length-1;
//        for (int i = 0; i <= takeOut.length - 1; i++) {
//            stack.addLast(takeOut[i]);
//            while(!stack.isEmpty()&&stack.getLast()==putIn[k]){
//                stack.removeLast();
//                k--;
//            }
//        }
//        return stack.isEmpty();
//
//    }

    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack<>();
        int i = takeOut.length-1;
        for(int num : putIn) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == takeOut[i]) { // 循环判断与出栈
                stack.pop();
                i--;
            }
        }
        return stack.isEmpty();
    }


    @Test
    @DisplayName("望远镜中最高的海拔")
    public void test02() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        int[] heights  = new int[]{14,2,27,-5,28,13,39};
        int limit  = 3;
        System.out.println(Arrays.toString(maxAltitude(heights, limit)));
    }


    public int[] maxAltitude(int[] heights, int limit) {
        if(heights==null||limit==0){
            return new int[]{};
        }
        int[] res = new int[heights.length - limit + 1];
        Deque<Integer> deque = new LinkedList<>();

        for(int j = 0, i = 1 - limit; j <= heights.length-1; i++, j++) {
            if(i>0&&deque.peekFirst()==heights[i-1]){
                deque.removeFirst();
            }

            while(!deque.isEmpty()&&deque.peekLast()<heights[j]){
                deque.removeLast();
            }
            deque.addLast(heights[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

}
