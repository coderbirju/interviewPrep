
Given a binary search tree (BST), 
find the lowest common ancestor (LCA) of 
two given nodes in the BST.

According to the definition of LCA on Wikipedia:
 “The lowest common ancestor is defined between 
 two nodes p and q as the lowest node in T that has both p and q as descendants 
 (where we allow a node to be a descendant of itself).”

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.


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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* 
            a solution is guaranteed to exist 
            Idea is to find the split, that is the lowest common ancestor
            If one of the values is equal to root then that is the lowest common ancestor
            because any child of it can't be it's ancestor
        */
        
        while(root != null){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            } else if(root.val > p.val && root.val > q.val){
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
}