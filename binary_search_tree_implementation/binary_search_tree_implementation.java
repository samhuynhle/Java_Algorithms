/*
Binary Search Tree: a node-based binary tree data structure
which has the following properies:
1 - The left subtree of a node contains only nodes with keys less than the node's key
2 - the right subtree of a node contains only nodes with keys greater than the node's key
3 - the left and right subtree each must also be a binary search tree
4 - In this case, there will be no duplicate nodes

*/

class BinarySearchTree {
    class Node {
        int key;
        Node left, right; 
        
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of the Binary Search Tree
    Node root;
    
    // Constructor for BST
    BinarySearchTree() {
        root = null;
    }

    // Insert methods
    void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.key){
            root.left = insertRec(root.left, key);
        } else {
            root.right = instertRec(root.right, key);
        }

        return root;
    }

    // In order traversal methods
    void inorder(){
        inorderRec(root);
    }

    void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    // Delete Method
    void deleteKey(int key){
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key){
        if(root == null){
            return root;
        }
        if(key < root.key){
            root.left = deleteRec(root.left, key);
        } else if(key > root.key){
            root.right = deleteRec(root.right, key);
        } else {
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root){
        int minv = root.key;
        while(root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}