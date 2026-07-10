package leetcode;

/**
 * LeetCode 226: Invert Binary Tree
 * Difficulty: Easy
 * 
 * Problem Statement:
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * Time Complexity: O(N) - Visiting every node of the tree once.
 * Space Complexity: O(H) - Call stack depth proportional to height H of the tree.
 */
public class InvertBinaryTree {

    // TreeNode definition
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Recursive DFS traversal to invert left and right nodes
    public static TreeNode invertTree(TreeNode root) {
        // Base case: empty node
        if (root == null) {
            return null;
        }

        // Swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursive inversion of subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // Inorder traversal display helper
    public static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- LeetCode 226: Invert Binary Tree ---");
        
        /*
                 4
               /   \
              2     7
             / \   / \
            1   3 6   9
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("Original Inorder: ");
        printInorder(root); // Expected: 1 2 3 4 6 7 9
        System.out.println();

        TreeNode inverted = invertTree(root);
        
        System.out.print("Inverted Inorder: ");
        printInorder(inverted); // Expected: 9 7 6 4 3 2 1
        System.out.println();
    }
}
