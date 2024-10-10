package com.test.algos;

import com.test.datastructure.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LinkedTableAlgorithm {

    private ArrayList<Integer> tmp = new ArrayList<Integer>();

    @Test
    @DisplayName("测试链表工厂")
    public void test01() {
        int[] inputs = {3, 6, 4, 1};
        ListNode head = linkedFactory(inputs);
        System.out.println(head.toString());
    }

    private ListNode linkedFactory(int[] input) {
        ListNode head = null;
        ListNode pre = null;

        for (int i = 0; i <= input.length - 1; i++) {
            if (i == 0) {
                head = new ListNode(input[i]);
                pre = head;
                continue;
            }
            pre.setNext(new ListNode(input[i]));
            pre = pre.getNext();
        }

        return head;
    }


    @Test
    @DisplayName("图书整理I")
    public void test02() {
        int[] inputs = {3, 6, 4, 1};
        ListNode head = linkedFactory(inputs);
        int[] res = reverseBookList(head);
        System.out.println(Arrays.toString(res));
    }

    public int[] reverseBookList(ListNode head) {

        recure(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i <= res.length - 1; i++) {
            res[i] = tmp.get(i);
        }
        return res;

    }

    private void recure(ListNode in) {
        if (in == null) {
            return;
        }
        if (in != null) {
            recure(in.getNext());
            tmp.add(in.getVal());
        }
    }


    @Test
    @DisplayName("删除链表节点")
    public void test03() {
        /*输入: head = [4,5,1,9], val = 5
            输出: [4,1,9]*/
        int[] inputs = {4, 5, 1, 9};
        ListNode head = linkedFactory(inputs);

        ListNode res = deleteNode(head,1);
        System.out.println(res);
    }

    private ListNode deleteNode(ListNode input, int val) {
        ListNode pre = null;
        ListNode head = input;
        if(head!=null&&head.getVal()==val){
            return head.getNext();
        }
        pre = head;
        input = input.getNext();
        while (input!=null){
            if (input.getVal()==val){
                pre.setNext(input.getNext());
            }
            input = input.getNext();
            pre = pre.getNext();
        }
        return head;
    }


    @Test
    @DisplayName("删除链表节点")
    public void test04() {
        /*输入: head = [4,5,1,9], val = 5
            输出: [4,1,9]*/
        int[] inputs = {1,2,3,4,5};
        ListNode head = linkedFactory(inputs);

        ListNode res = trainningPlan(head);
        System.out.println(res);
    }


//    public ListNode trainningPlan(ListNode head) {
//
//        ListNode pre = null;
//        ListNode tmp = null;
//
//        while (head != null) {
//            tmp = head.getNext();
//            head.setNext(pre);
//            pre = head;
//            head = tmp;
//        }
//        return pre;
//    }

    public ListNode trainningPlan(ListNode head) {

        return recur(null, head);

    }

    private ListNode recur(ListNode cur, ListNode next) {
        if(next==null){
            return cur;
        }
        ListNode res = recur(next, next.getNext());
        next.setNext(cur);
        return res;

    }

}
