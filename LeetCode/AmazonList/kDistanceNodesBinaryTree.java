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
    
    private void mapParents(TreeNode root, HashMap<TreeNode, TreeNode> mapParent){
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left != null){
                mapParent.put(cur.left, cur);
                q.add(cur.left);
            }
            if(cur.right != null){
                mapParent.put(cur.right, cur);
                q.add(cur.right);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> mapParent = new HashMap();
        mapParents(root, mapParent);
        Queue<TreeNode> q = new LinkedList();
        HashSet<TreeNode> visited = new HashSet();
        int level = 0;
        q.add(target);
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k)
                break;
            level++;
            for(int i =0;i<size;i++){
                TreeNode cur = q.poll();
                visited.add(cur);
                if(cur.left != null && !visited.contains(cur.left))
                    q.add(cur.left);
                if(cur.right != null && !visited.contains(cur.right))
                    q.add(cur.right);
                if(mapParent.get(cur) != null && !visited.contains(mapParent.get(cur)))
                    q.add(mapParent.get(cur));
            }
        }
        
        List<Integer> ans = new ArrayList();
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            ans.add(cur.val);
        }
        
        return ans;
    }
}