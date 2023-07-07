package coding_ninja.trees.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralOrderTraversalOptimized {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
    public static ArrayList<Integer> spiralOrder(BinaryTreeNode<Integer> root)
    {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<BinaryTreeNode<Integer>> ltor = new Stack<>();
        Stack<BinaryTreeNode<Integer>> rtol = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        ltor.add(root);
        while (!ltor.isEmpty() || !rtol.isEmpty()) {
            while (!ltor.isEmpty()) {
                BinaryTreeNode<Integer> top = ltor.pop();
                res.add(top.data);
                if (top.left != null) {
                    rtol.push(top.left);
                }
                if (top.right != null) {
                    rtol.push(top.right);
                }
            }
            while (!rtol.isEmpty()) {
                BinaryTreeNode<Integer> top = rtol.pop();
                res.add(top.data);
                if (top.right != null) {
                    ltor.push(top.right);
                }
                if (top.left != null) {
                    ltor.push(top.left);
                }
            }
        }
        return res;
    }
}

/* O(N)
resources used
two stacks
 */
