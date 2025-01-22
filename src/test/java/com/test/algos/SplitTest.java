package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static com.test.algos.TreeNodeTest.decorateRecord;

public class SplitTest {

    int[] preorder;
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
}
