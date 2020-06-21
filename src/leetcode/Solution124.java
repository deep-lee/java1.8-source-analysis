package leetcode;

public class Solution124 {
  private int maxPathSum = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    maxContribution(root);
    return maxPathSum;
  }

  private int maxContribution(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }

    int curVal = treeNode.val;
    int maxLeft = Math.max(maxPathSum(treeNode.left), 0);
    int maxRight = Math.max(maxPathSum(treeNode.right), 0);
    int sum = curVal + maxLeft + maxRight;
    maxPathSum = Math.max(maxPathSum, sum);

    return curVal + Math.max(maxLeft, maxRight);
  }
}
