/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxPath = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) 
            return 0;
        
        maxPath = 0;
        getMaxPath(root, root.val);
        
        return maxPath;
    }

    private int getMaxPath(TreeNode node, int val) {
        if (node == null)
            return 0;
        
        int left = getMaxPath(node.left, node.val);
        int right = getMaxPath(node.right, node.val);
        maxPath = Math.max(maxPath, left + right);
        
        if (val == node.val)
            return Math.max(left, right) + 1;
        
        return 0;
    }
    
}