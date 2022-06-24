/*
* Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []
 

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


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
    public List<Integer> rightSideView(TreeNode root) {
       /*
        Do level order traversal, but:
            - put right child first
            - and for each level use the first element as the rightmost node
        Probably known as reverse level order traversal
       */ 
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null)
            return result;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(i == 0)
                    result.add(cur.val);
                
                if(cur.right != null)
                    queue.add(cur.right);
                
                if(cur.left != null)
                    queue.add(cur.left);
            }
        }
        return result;   
    }
}