class Algorithm {
    public class TreeNode { // This is how the TreeNode class is set up
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode searchBST(TreeNode root, int val) { // Recursive method
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }else if(val < root.val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) { // Iterative method
        while(root != null && root.val != val){
            root = val < root.val ? root.left:root.right;
        }
        return root;
    }
}