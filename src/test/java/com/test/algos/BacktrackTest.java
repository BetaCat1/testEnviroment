package com.test.algos;

import com.test.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class BacktrackTest {

    public String goods = "agew";
    @Test
    @DisplayName("斐波那契数")
    public void test01() {

         int [] inputs = new int[]{3,1,5,8};

        int rs = maxCoins(inputs);
        System.out.println(rs);


    }

    public int[][] rec;
    public int[] val;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }


    @Test
    @DisplayName("全排列I  考虑重复元素")
    public void test02() {

        int [] choices = new int[]{1,1,2};
        boolean[] selected = new boolean[choices.length];
        for (int i = 0; i <= choices.length - 1; i++) {
            selected[i] = false;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();

//        backtrack(new ArrayList<>(), choices, selected, res);

        System.out.println(res);

    }


//    public void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res){
//
//        if(state.size()==choices.length){
//            res.add(new ArrayList<Integer>(state));
//            return;
//        }
//        Set<Integer> duplicated = new HashSet<Integer>();
//
//        for (int i = 0; i <= choices.length - 1; i++) {
//            if (!selected[i]&&!duplicated.contains(choices[i])) {
//                duplicated.add(choices[i]);
//                state.add(choices[i]);
//                selected[i] = true;
//                backtrack(state, choices, selected, res);
//                state.remove(state.size() - 1);
//                selected[i] = false;
//            }
//
//
//        }
//
//
//
//
//    }



    @Test
    @DisplayName("求解子集和 I")
    public void test03() {
        int [] nums = new int[]{4,3,5};
        List<Integer> state = new ArrayList<>(); // 状态（子集）
        Arrays.sort(nums); // 对 nums 进行排序
        int start = 0; // 遍历起始点
        int target = 9;
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrack(state, target, nums, start, res);

        System.out.println(res);

    }


    public void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res){

        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }

        for (int i = start; i <= choices.length - 1; i++) {
            if(target-choices[i]<0){
                break;
            }
            state.add(choices[i]);
            backtrack(state, target - choices[i], choices, i, res);
            state.remove(state.size() - 1);
        }





    }


    @Test
    @DisplayName("字母迷宫")
    public void test04() {

        char[][] grid = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String target = "ABCCED";
        System.out.println(wordPuzzle(grid, target));

    }

    public boolean wordPuzzle(char[][] grid, String target) {
        for (int i = 0; i <= grid.length - 1; i++) {
            for (int j = 0; j <= grid[0].length - 1; j++) {
                if(dfs(i, j, 0, grid, target)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i,int j,int k,char[][] grid,String target){
        if(i<0||j<0||i> grid.length-1||j>grid[0].length - 1||target.charAt(k)!=grid[i][j]){
            return false;
        }
        if(k==target.length()-1){
            return true;
        }

        grid[i][j] = '\0';
        boolean res = dfs(i - 1, j, k + 1, grid, target)
                || dfs(i + 1, j, k + 1, grid, target)
                || dfs(i, j + 1, k + 1, grid, target)
                || dfs(i, j - 1, k + 1, grid, target);
        grid[i][j] = target.charAt(k);
        return res;


    }



    @Test
    @DisplayName("二叉树中和为目标值的路径")
    public void test05() {
        Integer[] inputs = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode treeNode = TreeNodeTest.arrayToTreeList(inputs, 0);
        System.out.println(pathTarget(treeNode, 22));

    }
/*
这道题之所以答案不对是因为构造树的那个方法有问题，没有考虑到当中缺一个子树的情况，但是在leetcode上是对的
 */
    public List<List<Integer>> pathTarget(TreeNode root, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack01(new ArrayList<>(), target, root, res);
        return res;
    }


    public void backtrack01(List<Integer> state, int target,  TreeNode root, List<List<Integer>> res){

        if(root==null){
            return;
        }

        state.add(root.getVal());
        if (target- root.getVal() == 0&&root.getRight()==null&&root.getLeft()==null) {
            res.add(new ArrayList<>(state));
        }

        backtrack01(state, target - root.getVal(),  root.getLeft(), res);
        backtrack01(state, target- root.getVal(), root.getRight(), res);
        state.remove(state.size() - 1);





    }

    @Test
    @DisplayName("套餐内商品的排列顺序")
    public void test06() {

//        String[] strings = goodsOrder(goods);
//        for (String a:strings){
//            System.out.println(a);
//        }

        System.out.println(goodsOrder(goods));
    }

    public List<String> goodsOrder(String goods) {
        List<String> res = new ArrayList<>();
        char[] input = goods.toCharArray();
        boolean[] selected = new boolean[input.length];
        backtrack02(new ArrayList<>(), input,selected,  res);
        return res ;
//["aegw","aewg","agew","agwe","aweg","awge","eagw","eawg","egaw","egwa","ewag","ewga","gaew","gawe","geaw","gewa","gwae","gwea","waeg","wage","weag","wega","wgae","wgea"]
//[agew, agwe, aegw, aewg, awge, aweg, gaew, gawe, geaw, gewa, gwae, gwea, eagw, eawg, egaw, egwa, ewag, ewga, wage, waeg, wgae, wgea, weag, wega]
    }


    public void backtrack02(List<Character> state, char[] input, boolean[] selected,  List<String> res){

        if(input.length==state.size()){
            res.add(String.valueOf(state.stream()
                    .map(String::valueOf)  // 将 Character 转换为 String
                    .collect(Collectors.joining())));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i <= input.length - 1; i++) {
            if(!selected[i] && !set.contains(input[i])) { // 重复，因此剪枝
                set.add(input[i]);
                state.add(input[i]);
                selected[i] = true;
                backtrack02(state, input, selected, res);
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }





    }

}
