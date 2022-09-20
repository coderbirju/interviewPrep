/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    * Sort based solution
    - do inorder traversal and see if the array is sorted, if not then it's not a valid bst
    - use a global single variable prev, that holds the previous visited node value.. 
    - if current val < prev then invalid BST
    */
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) { 
        if(root == null)
            return true;
        
        
        if(!isValidBST(root.left))
            return false;
        if(root.val <= prev)
            return false;
        prev = root.val;
        return isValidBST(root.right);
    }
    
    /*
    * Range Based Solution
    maintain upper and lower bound for each node, initially its max and min value
    if going left then upper bound = root.val
    if going right then lower bound = root.val
    return true if cur.val is between range and left and right subtree is also balanced

    */
    public boolean isValidBST(TreeNode root) { 
        long lower = Long.MIN_VALUE;
        long upper = Long.MAX_VALUE;
        if(root.left == null && root.right == null)
            return true;
        return rangeCheck(root,lower,upper);
    }
    public boolean rangeCheck(TreeNode root, long lower, long upper){
        if(root == null)
            return true;
        if(root.val<upper && root.val>lower){
            boolean left = rangeCheck(root.left,lower,root.val);
            boolean right = rangeCheck(root.right,root.val,upper);
            return left && right;
        } 
        return false;
    }
}