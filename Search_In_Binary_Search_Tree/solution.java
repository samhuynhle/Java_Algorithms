// We are going to demonstrate both the recursive and iterative ways in searching within a
// Binary Search Tree. The primary thought is to look at the current node, left child, then right child.
// This is a form of pre-order traversal (one of the Depth Frist Search Approaches), but we cut off
// path depending on the target values relation to the current nodes' value

class Algorithm {
    // This is the set up for the Binary Search Tree (assume all BST properties applied for input)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    // Recursive Method
    public TreeNode searchBST(TreeNode root, int val) {

        // Base case: If the root is null we return null
        if(root == null){
            return null;
        }

        // Base case: If the root's value equals our target value, we return the current root.
        if(root.val == val){
            return root;
        // If we are not at the correct node, we check the left OR right, depending on the value's relation to current root's value
        }else if(val < root.val){ 
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }

    // Iterative Method
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while(root != null && root.val != val){ // This is how we are traversing through the tree
            root = val < root.val ? root.left:root.right;
        }
        return root; 
    }
}