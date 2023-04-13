package tree.basic;

import java.util.ArrayList;

public class BinaryTree {
    class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }
    // ................................................................................................. Minimum element
    int minValueRec(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return Math.min(root.data, Math.min(minValueRec(root.left), minValueRec(root.right)));
        }
    }
    int minValue(Node node) {
        if (node == null) {
            return -1;
        }
        return minValueRec(node);
    }
    // ................................................................................................. Inorder
    ArrayList<Integer> a;
    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            a.add(root.data);
            inOrderRec(root.right);
        }
    }
    ArrayList<Integer> inOrder(Node root) {
        // Code
        a = new ArrayList<>();
        inOrderRec(root);
        return a;
    }
    // ................................................................................................. Preorder
    static void preorderRec(Node root, ArrayList<Integer> a) {
        if (root != null) {
            a.add(root.data);
            preorderRec(root.left, a);
            preorderRec(root.right, a);
        }
    }
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> a = new ArrayList<>();
        preorderRec(root, a);
        return a;
    }
    // ................................................................................................. countLeaves
    int countLeaves(Node node)
    {
        if (node == null) {return 0;}
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }
    // ................................................................................................. l
    int countNonLeafNodes(Node node) {
        if (node == null) {return 0;}
        if (node.left == null && node.right == null) {
            return 0;
        } else {
            return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
        }
    }
    // ................................................................................................. no of nodes
    public static int getSize(Node root)
    {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }
    // .................................................................................................

}
