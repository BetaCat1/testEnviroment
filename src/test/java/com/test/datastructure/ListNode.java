package com.test.datastructure;

import lombok.Data;

@Data
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        if(next != null){
            return val + " ——> "+next.toString();
        }
        return val+"";
    }


}
