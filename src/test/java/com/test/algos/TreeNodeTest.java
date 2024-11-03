package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TreeNodeTest {

    @Test
    @DisplayName("彩灯装饰记录 I")
    public void test01() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        Integer[] input  = new Integer[]{8,17,21,18,null,null,6};
        int idnex  = 0;
        TreeNode treeNode = arrayToTreeList(input, idnex);
        System.out.println(Arrays.toString(decorateRecord(treeNode)));
    }

    public int[] decorateRecord(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> res = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.getVal());
            if(node.getLeft()!=null)queue.offer(node.getLeft());
            if(node.getRight()!=null)queue.offer(node.getRight());
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i <= res.size() - 1; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }


    private TreeNode arrayToTreeList(Integer[] input,int index){
        if(index>input.length-1||input[index]==null){
            return null;
        }
        TreeNode root = new TreeNode(input[index]);
        root.setLeft(arrayToTreeList(input,2*index+1));
        root.setRight(arrayToTreeList(input,2*index+2));

        return root;

    }

    @Test
    @DisplayName("测试数组转树结构")
    public void test02() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        Integer[] input  = new Integer[]{1,2,3,4,5,6,7,8,9};
        TreeNode treeNode = arrayToTreeList(input, 0);
        System.out.println(treeNode.toString());
    }


    private int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> res = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.getVal());
            if(node.getLeft()!=null)queue.offer(node.getLeft());
            if(node.getRight()!=null)queue.offer(node.getRight());
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i <= res.size() - 1; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }


}
