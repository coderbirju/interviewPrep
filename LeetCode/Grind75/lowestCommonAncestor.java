/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1
Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 
    Use Recursion, don't do Bfs
    There are multiple variations for this problem:
    -> LCA of Binary Search Tree
        -> For this Approach next recursive call is determined by the fact that the elements are ordered 
        based on their value i.e lesser than root is left and so on. 
        -> if(root == null) 
            return null
            
            if(p == root.val || q == root.val)
            return root;

            if((p< root.val && q > root.val) || (q < root.val && p > root.val))
            return root
    
    -> LCA of Binary Tree (when p and q are guaranteed)
        -> use the following approach
    -> LCA of Binary Tree (when p and q are not guaranteed)
        -> same approach but a tweak
            -> maintain global booleans of pFound and qfound
            -> if root.val is equal to either of therm then set corresponding boolean to true
            -> after the outer recursion call if both pFound and qfound aren't true then return null

 */
class Solution {
    
    public TreeNode search(TreeNode root,TreeNode p, TreeNode q) {
       /*
        for each node
         if(root == null) 
            return null
         if(root is either p or q)
          return root
         leftSearch = lca(root.left);
         rightSearch = lca(root.right);
         if(leftSearch == null)
            return rightSearch;
         if(rightSearch == null)
            return leftSearch;
        */
        /* 
            base cases 
            -> if root == null reutrn null
            -> if either p or q is root then none of it's children can be LCA so just return the root
        */
        /*
            Other cases
            -> call lca on both the sub trees
            -> If both left and right have something return root
            -> if you havent found lca in left subtree return right sub tree search result
            -> if you haven't found lca in right subtree return left search result
        */
        if(root == null)
            return null;
        
        
        TreeNode leftSubtreeResult = search(root.left,p,q);
        TreeNode rightSubtreeResult = search(root.right,p,q);
        
        if(root.val == p.val || root.val == q.val)
            return root;
        
        // This means that one key is found on the left and another is found on the right then root is the LCA
        if(leftSubtreeResult != null && rightSubtreeResult != null)
            return root;
        
        return leftSubtreeResult == null ? rightSubtreeResult : leftSubtreeResult;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p,q);
    }
}