/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String serializedString = new String();
        List<String> traversalArray = new ArrayList();
        dfsSerialize(root, traversalArray);
        return String.join(",", traversalArray);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitString = data.split(",");
        this.index = 0;
        return dfsDeserialize(splitString);
    }
    
    private void dfsSerialize(TreeNode root, List<String> arr){
        if(root == null){
            arr.add("N");
            return;
        }
        arr.add(String.valueOf(root.val));
        dfsSerialize(root.left, arr);
        dfsSerialize(root.right, arr);
        return;
    }
    
    private TreeNode dfsDeserialize(String[] data){
        if(data[this.index].equals("N")){
            this.index++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(data[this.index]));
        this.index++; // the index takes care of the left and right, we call the left subtree first
        node.left = dfsDeserialize(data);
        node.right = dfsDeserialize(data);
        return node; // this return happens when the subtree with root = current node is completed
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));