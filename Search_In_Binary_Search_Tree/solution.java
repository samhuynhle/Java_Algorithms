class Algorithm {
    public class TreeNode { // This is how the TreeNode class is set up
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode searchBST(TreeNode root, int val) { // Recursive method
        if(root == null){ // base case to return null if the node we get is null
            return null;
        }
        if(root.val == val){ // base case to return the current node if the val matches
            return root;
        }else if(val < root.val){ // this conditional checks for the left tree, use BST's properties
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val); // this conditional checks for the right tree, use BST's properties
        }
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) { // Iterative method
        while(root != null && root.val != val){ // This is how we are traversing through the tree
            root = val < root.val ? root.left:root.right; // Ternary
        }
        return root; 
    }
}