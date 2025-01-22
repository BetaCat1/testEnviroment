package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static com.test.algos.TreeNodeTest.decorateRecord;

public class SplitTest {

    int[] preorder;
    int[] post;
    int[] record, tmp;
    HashMap<Integer, Integer> hmap = new HashMap<>();
    @Test
    @DisplayName("构建树")
    public void test01() {
//        输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
         preorder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        for (int i = 0; i <= inOrder.length - 1; i++) {
            hmap.put(inOrder[i], i);
        }

        TreeNode treeNode = deduceTree(preorder, inOrder);


        System.out.println(Arrays.toString(decorateRecord(treeNode)));


    }

    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        return recur(0,0,inorder.length-1);
    }


    private TreeNode recur(int root,int left,int right){
        if(left>right){
            return null;
        }
        int i = hmap.get(preorder[root]);

        TreeNode rootNode = new TreeNode(preorder[root]);

        rootNode.setLeft(recur(root+1,left,i-1));
        rootNode.setRight(recur(root + 1+i-left, i + 1, right));

        return rootNode;
    }


    @Test
    @DisplayName("验证二叉搜索树的后序遍历序列")
    public void test02() {
        int[] postorder = new int[]{4,9,6,5,8};
        post = postorder;
        boolean res = verifyTreeOrder(postorder);


        System.out.println(res);


    }


    public boolean verifyTreeOrder(int[] postorder) {
        return validate(post.length - 1, 0, post.length - 1);
    }



    private boolean validate(int root,int left,int right){
        if(left>=right){
            return true;
        }
        int m=0;
        for (int i = 0; i <= right; i++) {
            if(post[i]>post[root]){
                m = i;
                break;
            }
        }

        for (int i = m; i <= right; i++) {
            if(post[i]<post[root]){
                return false;
            }
        }
        return validate(m-1,0,m-1)&&validate(right-1,m,m-1);

    }


    @Test
    @DisplayName("交易逆序对的总数")
    public void test03() {
        int[] stock  = new int[]{9, 7, 5,4,6};
        int res = reversePairs(stock);
        System.out.println(res);



    }

    public int reversePairs(int[] record) {
        this.record = record;
        tmp = new int[record.length];
        return mergeSort(0, record.length-1);


    }


    private int mergeSort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
//        合并阶段
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = record[k];

        }

        for (int k = l; k <= r; k++) {
             if (j == r + 1 || tmp[i] <= tmp[j]) {
                record[k] = tmp[i++];
            } else if (i == m + 1) {
                record[k] = tmp[j++];
            }else {
                res += m - i + 1;
                record[k] = tmp[j++];
            }


        }

        return res;


    }














}
