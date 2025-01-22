package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TreeNodeTest {

    TreeNode head,pre;
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

    public static int[] decorateRecord(TreeNode root) {
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


    public static TreeNode arrayToTreeList(Integer[] input,int index){
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

    @Test
    @DisplayName("彩灯装饰记录 II")
    public void test03() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
        Integer[] input  = new Integer[]{8,17,21,18,null,null,6};
        TreeNode treeNode = arrayToTreeList(input, 0);
        System.out.println(decorateRecord01(treeNode));
    }


    public List<List<Integer>> decorateRecord01(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i >0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.getVal());
                if(node.getLeft()!=null)queue.offer(node.getLeft());
                if(node.getRight()!=null)queue.offer(node.getRight());

            }
            res.add(tmp);
        }
        return res;
    }

    @Test
    @DisplayName("彩灯装饰记录 III")
    public void test04() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
//        Integer[] input  = new Integer[]{8,17,21,18,null,null,6};
        Integer[] input  = new Integer[]{1,2,3,4,5};
        TreeNode treeNode = arrayToTreeList(input, 0);
        System.out.println(decorateRecord02(treeNode));
    }

    public List<List<Integer>> decorateRecord02(TreeNode root) {
        Stack<TreeNode> queue = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)queue.push(root);
        Boolean flag = true;
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            Stack<TreeNode> tmpS = new Stack<>();
            for (int i = queue.size(); i >0; i--) {
                TreeNode node = queue.pop();
                tmp.add(node.getVal());

                if (flag) {
                    if(node.getLeft()!=null)tmpS.push(node.getLeft());
                    if(node.getRight()!=null)tmpS.push(node.getRight());
                }else {
                    if(node.getRight()!=null)tmpS.push(node.getRight());
                    if(node.getLeft()!=null)tmpS.push(node.getLeft());

                }

            }
            flag = !flag;
            queue = tmpS;
            res.add(tmp);
        }
        return res;
    }

    @Test
    @DisplayName("子结构判断")
    public void test05() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
//        Integer[] input  = new Integer[]{8,17,21,18,null,null,6};
        Integer[] A  = new Integer[]{3,6,7,1,8};
        Integer[] B  = new Integer[]{6,1};
        TreeNode treeNodeA = arrayToTreeList(A, 0);
        TreeNode treeNodeB = arrayToTreeList(B, 0);
        System.out.println(isSubStructure(treeNodeA,treeNodeB));
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B)
                || isSubStructure(A.getLeft(), B)
                || isSubStructure(A.getRight(), B));

    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B==null) return true;
        if(A == null || A.getVal() != B.getVal()) return false;
        return recur(A.getLeft(), B.getLeft()) && recur(A.getRight(), B.getRight());

    }


    @Test
    @DisplayName("翻转二叉树")
    public void test06() {
        Integer[] A  = new Integer[]{5,7,9,8,3,2,4};
        TreeNode treeNodeA = arrayToTreeList(A, 0);
        System.out.println(flipTree(treeNodeA));
    }

    public TreeNode flipTree(TreeNode root) {
        if (root ==null) return null;
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        TreeNode tmp = left;
        root.setLeft(right);
        root.setRight(tmp);
        flipTree(left);
        flipTree(right);

        return root;

    }


    @Test
    @DisplayName("判断对称二叉树")
    public void test07() {
        Integer[] A  = new Integer[]{5,7,9,8,3,2,4};
        TreeNode treeNodeA = arrayToTreeList(A, 0);
        System.out.println(checkSymmetricTree(treeNodeA));
    }

    public boolean checkSymmetricTree(TreeNode root) {
        return root==null&&recursive(root.getLeft(), root.getRight());

    }

    private boolean recursive(TreeNode a, TreeNode b) {
        if(a==null&&b==null){
            return true;
        }
        if (a.getVal()==b.getVal()) return true;
        if (a==null||b==null||(a.getVal() != b.getVal())) return false;
        return   recursive(a.getRight(), b.getLeft()) && recursive(a.getLeft(), b.getRight());
    }

    @Test
    @DisplayName("将二叉搜索树转化为排序的双向链表")
    public void test08() {
        Integer[] A  = new Integer[]{5,7,9,8,3,2,4};
        TreeNode treeNodeA = arrayToTreeList(A, 0);
        System.out.println(treeToDoublyList(treeNodeA));
    }


    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.setLeft(pre);
        pre.setRight(head);
        return head;

    }

    private void dfs(TreeNode node){
        TreeNode cur=null;
        if (node!=null) {
            cur = node;
            cur.setLeft(pre);
        }else {
            return;
        }
        dfs(node.getLeft());
        if(head!=null){
            pre.setRight(cur);
        }else {
            head = cur;
        }
        pre = cur;
        dfs(node.getRight());

    }


    @Test
    @DisplayName("计算二叉树的深度")
    public void test09() {
        Integer[] A  = new Integer[]{5,7,9,8,3,2,4};
        TreeNode treeNodeA = arrayToTreeList(A, 0);
        System.out.println(calculateDepth(treeNodeA));
    }


    public int calculateDepth(TreeNode root) {

        if(root == null) return 0;
        return so(root.getLeft(),root.getRight())+1;
    }

    public int so(TreeNode left,TreeNode right) {
        if(left == null&&right==null) return 0;
        if(left == null) return so(right.getLeft(),right.getRight())+1;
        if(right == null) return so(left.getLeft(),left.getRight())+1;
        return Math.max(so(left.getLeft(),left.getRight()), so(right.getLeft(),right.getRight())) + 1;
    }


    @Test
    @DisplayName("判断是否为平衡二叉树")
    public void test10() {
        Integer[] A  = new Integer[]{5,7,9,8,3,2,4};
        TreeNode treeNodeA = arrayToTreeList(A, 0);
        System.out.println(isBalanced(treeNodeA));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(calculateDepth(root.getLeft()) - calculateDepth(root.getRight()))<=1 &&(isBalanced(root.getLeft())&&isBalanced(root.getRight()));
    }

    @Test
    @DisplayName("求二叉搜索树的最近公共祖先")
    public void test11() {
        Integer[] A  = new Integer[]{5,7,9,8,3,2,4};
        TreeNode treeNodeA = arrayToTreeList(A, 0);
        System.out.println(isBalanced(treeNodeA));
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.getVal()<p.getVal()&&root.getVal()<q.getVal()){
//            在root的右子树中
            lowestCommonAncestor(root.getRight(), p, q);
        }

        if(root.getVal()>p.getVal()&&root.getVal()>q.getVal()){
//            在root的左子树中
            lowestCommonAncestor(root.getLeft(), p, q);
        }
//        root=p或者q
        return root;


    }

    @Test
    @DisplayName("寻找二叉树的最近公共祖先")
    public void test12() {
        Integer[] A  = new Integer[]{5,7,9,8,3,2,4};
        TreeNode treeNodeA = arrayToTreeList(A, 0);
        System.out.println(isBalanced(treeNodeA));
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.getLeft(), p, q);
        TreeNode right = lowestCommonAncestor1(root.getRight(), p, q);
        if(left==null){
            return right;
        }
        if (right ==null) return left;
        return root;
    }



}
