package dailyCheckin;

import ref.TreeNode;

/**
 * @author kanglo
 * @create 2022-08-2022/8/20 17:53
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[]nums){
        if (nums == null || nums.length == 0)
            return null;
        return constructMaximumBinaryTree(nums,0,nums.length-1);

    }
    private TreeNode constructMaximumBinaryTree(int[]nums,int left,int right){
        int max = 0;
        int index = 0;
        if (left == right)
            return new TreeNode(nums[left]);
        if (left > right)
            return null;
        for (int i = left;i <= right;i++){
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode cur = new TreeNode(max);
        TreeNode leftNode = constructMaximumBinaryTree(nums,left,index-1);
        TreeNode rightNode = constructMaximumBinaryTree(nums,index+1,right);
        cur.left = leftNode;
        cur.right = rightNode;
        return cur;
    }
}
