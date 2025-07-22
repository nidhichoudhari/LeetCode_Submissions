class Solution {
    int preOrderIndex = 0; 
    Map<Integer, Integer> map = new HashMap<>(); 
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        
        return check(preorder, 0, postorder.length - 1);
    }

    public TreeNode check(int[] preorder, int start, int end) {
        if (preOrderIndex >= preorder.length || start > end) return null;

       
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

       
        if (start == end) return root;

        
        int leftChildValue = preorder[preOrderIndex];
        int rootIndex = map.get(leftChildValue); 

        root.left = check(preorder, start, rootIndex);
        root.right = check(preorder, rootIndex + 1, end - 1); 

        return root;
    }
}