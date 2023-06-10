package hackerearth.datastructures.tree.bst;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Tutorial {
    static class Node{
        int data;
        Node left, right;
        Node (int d) {
            data = d;
            left = null;
            right = null;
        }
    }
    static class BST {
        Node root;
        BST() {
            root = null;
        }
        void insert(int data) {
            root = insertRec(root, data);
        }
        Node insertRec(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }
            if (data < root.data) {
                root.left = insertRec(root.left, data);
            }
            if (data > root.data) {
                root.right = insertRec(root.right, data);
            }
            return root;
        }
        Node findTreeNode(int value) {
            Node temp = root;
            return findTreeNodeUtil(temp, value);
        }
        Node findTreeNodeUtil(Node root, int value) {
            if (root != null) {
                if (root.data == value) {
                    return root;
                } else if (value < root.data) {
                    return findTreeNodeUtil(root.left, value);
                } else if (value > root.data) {
                    return findTreeNodeUtil(root.right, value);
                }
            }
            return root;
        }
        void preorder(Node node) {
            if (node != null) {
                System.out.println(node.data);
                preorder(node.left);
                preorder(node.right);
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nodes = br.readLine().trim().split(" ");
        BST bst = new BST();
        for (String s : nodes) {
            int value = Integer.parseInt(s);
            bst.insert(value);
        }
        int v = Integer.parseInt(br.readLine());
        Node start = bst.findTreeNode(v);
        bst.preorder(start);
    }
}
