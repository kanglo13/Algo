package dp;

import ref.TreeNode;

/**
 * @author kanglo
 * @create 2021-09-2021/9/6 21:53
 */
public class MaxPathSum {
    private int result= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return result;
    }
    private int dfs(TreeNode root){
        if (root == null)
            return 0;
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        result = Math.max(result,Math.max(left+right+root.val,result));
        return Math.max(left,right) + root.val;
    }
}
