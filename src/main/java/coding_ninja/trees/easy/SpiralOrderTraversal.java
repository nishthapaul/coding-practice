package coding_ninja.trees.easy;
import java.util.*;

public class SpiralOrderTraversal {
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
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        Stack<BinaryTreeNode<Integer>> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean ltor = true;
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> front = q.poll();
            res.add(front.data);
            if (ltor) {
                if (front.left != null) {
                    st.push(front.left);
                }
                if (front.right != null) {
                    st.push(front.right);
                }
            } else {
                if (front.right != null) {
                    st.push(front.right);
                }
                if (front.left != null) {
                    st.push(front.left);
                }
            }
            if (q.isEmpty()) {
                while (!st.isEmpty()) {
                    q.add(st.pop());
                }
                ltor = !ltor;
            }
        }
        return res;
    }
}

/* O(N square)
resources used
one boolean variable - ltor
one queue
one stack

Every node has to go in queue as well as stack
 */
