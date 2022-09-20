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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val < key)
            deleteNode(root.right, key);
        else if(root.val > key)
            deleteNode(root.left,key);
        else {
            if(root.left == null && root.right == null)
                root = null;
            else if(root.right != null){
                TreeNode temp = findSmallest(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, root.val);
            } else  {
                TreeNode temp = findLargest(root.left);
                root.val = temp.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    private TreeNode findSmallest(TreeNode root){
        TreeNode cur = root;
        while(cur.left != null)
            cur = cur.left;
        return cur;
    }
    

    private TreeNode findLargest(TreeNode root){
        TreeNode cur = root;
        while(cur.right != null)
            cur = cur.right;
        return cur;
    }
}