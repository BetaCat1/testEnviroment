package com.test.datastructure;

import lombok.Data;

@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString(){
        return "    " + getVal() + "\n" +
                "  /" + "   " + "\\" +"\n"+
                (left==null?"null":left.toString()) + "          "
                + (right==null?"null":right.toString()) +"\n";
    }

//    @Override
//    public String toString(){
//        return getVal()+""+((null==left)?"null":left.toString());
//    }
}