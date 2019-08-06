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
    int maxPath;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxPath = 0;
        getHeight(root);
        
        return maxPath;
    }
    
    private int getHeight(TreeNode node){
        if(node == null)
            return -1;
        else{
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            if(((leftHeight + 1) + (rightHeight + 1)) > maxPath)
                maxPath = (leftHeight + 1) + (rightHeight + 1);
            return
                Math.max(leftHeight, rightHeight) + 1;
        }
    }
}