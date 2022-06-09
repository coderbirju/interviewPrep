public int MaxDepth(TreeNode root) {
     public int maxDepth(TreeNode root) {
         // recursive solution
        if(root == null)
            return 0;
        int lf = maxDepth(root.left);
        int rf = maxDepth(root.right);
        
        return Math.max(lf,rf) + 1;

        // Iterative solution
      /*  TreeNode node = root;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<int> depthStack = new Stack<int>();
        
        int max = 0;
        int depth = 1;
        while (node != null || nodeStack.Count > 0)
        {
            if (node != null)
            {
                nodeStack.Push(node);
                depthStack.Push(depth);
                node = node.left;
                depth++;
            }
            else
            {
                node = nodeStack.Pop();
                depth = depthStack.Pop();
                
                if (depth > max) max = depth;
                
                node = node.right;
                depth++;
            }
        }
        
        return max;
        */
    }



    }