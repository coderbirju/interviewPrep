/**
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

 */


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
     Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //1. break the recursion
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //2. find the tree root, which is the first value of 
        TreeNode root = new TreeNode(preorder[preStart]); // 3
        //3. find root in the inorder, then left of root will be left tree, right of root will be right tree. 
        int rootIndex = inorderMap.get(root.val);
        int numsOnLeft = rootIndex - inStart; // 1 - 0
        
        //4. root left will go over of inorder everything left on the root 
        root.left = build(preorder, preStart + 1, preStart + numsOnLeft, inorder, inStart, rootIndex - 1); 
        //5. root right will go over of inorder everyhting right on the right
        root.right = build(preorder, preStart + numsOnLeft + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}