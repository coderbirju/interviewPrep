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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
            do level order traversal using bfs
            while adding to the queue
        */
        List<List<Integer>> ans = new ArrayList();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        List<Integer> sublist;
        int lvl =0;
        while(!q.isEmpty()){
            int size = q.size();
            sublist = new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
                if(lvl%2 == 0){
                    sublist.add(cur.val);
                } else {
                    sublist.add(0,cur.val);
                }
            }
            lvl++;
            ans.add(sublist);
        }
        return ans;
    }
}