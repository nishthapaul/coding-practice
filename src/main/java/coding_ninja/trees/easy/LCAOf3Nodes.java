package coding_ninja.trees.easy;

// https://www.codingninjas.com/codestudio/problems/lca-of-three-nodes_794944

import java.util.*;

public class LCAOf3Nodes {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static boolean checkLCA (BinaryTreeNode<Integer> root, int n1, int n2, int n3) {
        if (root == null) {
            return false;
        } else {
            boolean hasN1 = false, hasN2 = false, hasN3 = false;
            Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                BinaryTreeNode<Integer> front = q.poll();
                if (front.data == n1) {
                    hasN1 = true;
                }
                if (front.data == n2) {
                    hasN2 = true;
                }
                if (front.data == n3) {
                    hasN3 = true;
                }
                if (hasN1 == true && hasN2 == true && hasN3 == true) {
                    return true;
                }
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            return false;
        }
    }
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2, int node3) {
        BinaryTreeNode<Integer> leftLCA = null;
        if (root.left != null) {
            leftLCA = lcaOfThreeNodesHelper(root.left, node1, node2, node3);
        }
        BinaryTreeNode<Integer> rightLCA = null;
        if (root.right != null) {
            rightLCA = lcaOfThreeNodesHelper(root.right, node1, node2, node3);
        }
        if(leftLCA == null && rightLCA == null) {
            return root;
        } else if (leftLCA != null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }

    public static BinaryTreeNode<Integer> lcaOfThreeNodesHelper(BinaryTreeNode<Integer> root, int n1, int n2, int n3) {
        boolean isRootLCA = checkLCA(root, n1, n2, n3);
        if (isRootLCA) {
            BinaryTreeNode<Integer> leftLCA = null;
            if (root.left != null) {
                leftLCA = lcaOfThreeNodesHelper(root.left, n1, n2, n3);
            }
            BinaryTreeNode<Integer> rightLCA = null;
            if (root.right != null) {
                rightLCA = lcaOfThreeNodesHelper(root.right, n1, n2, n3);
            }
            if(leftLCA == null && rightLCA == null) {
                return root;
            } else if (leftLCA != null) {
                return leftLCA;
            } else {
                return rightLCA;
            }
        } else {
            return null;
        }
    }
}
