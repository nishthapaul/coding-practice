package Leetcode;

import java.util.ArrayList;

public class Q538_BSTToGreaterTree {
    ArrayList<TreeNode> A;

    // inorder of BST will always give sorted order
    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            A.add(root);
            inorder(root.right);
        }
    }

    public TreeNode convertBST(TreeNode root) {
        A = new ArrayList<>();
        inorder(root);
        int n = A.size();
        for (int i = n - 2; i >= 0; i--) {
            TreeNode t = A.get(i);
            t.val = t.val + A.get(i + 1).val;
            A.set(i, t);
        }
        return root;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
