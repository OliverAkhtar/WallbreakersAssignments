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
    int maxDepth = -1, value;
    
    public int findBottomLeftValue(TreeNode root) {
        search(root, 0);
        
        return value;
    }
    
    private void search(TreeNode node, int depth){
        if(node == null)
            return;
        else if(depth > maxDepth){
            maxDepth = depth;
            value = node.val;
        }
        
        search(node.left, depth + 1);
        search(node.right, depth + 1);
    }
}