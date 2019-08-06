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
    
    private int i = 0;
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstTreeSequence = new ArrayList<>();
        getSequence(firstTreeSequence, root1);
        
        return compareSequence(firstTreeSequence, root2);
    }
    
    private void getSequence(List<Integer> list, TreeNode node){
        if(node == null)
            return;
        if(node.left == null && node.right == null)
            list.add(node.val);
        else{
            getSequence(list, node.left);
            getSequence(list, node.right);
        }
    }
    
    private boolean compareSequence(List<Integer> list, TreeNode node){
        if(node == null)
            return true;
        if(node.left == null && node.right == null){
            if(node.val != list.get(i))
                return false;
            else{
                i++;
                return true;
            }
        }
        
        return compareSequence(list, node.left) && compareSequence(list, node.right);    
    }
}