package coding_ninja.trees.easy;

// https://www.codingninjas.com/codestudio/problems/lca-of-three-nodes_794944

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LCAOf3NodesOptimized {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2, int node3) {
        ArrayList<BinaryTreeNode<Integer>> path1 = new ArrayList<>();
        getPath(root, node1, path1);
        ArrayList<BinaryTreeNode<Integer>> path2 = new ArrayList<>();
        getPath(root, node2, path2);
        ArrayList<BinaryTreeNode<Integer>> path3 = new ArrayList<>();
        getPath(root, node3, path3);
        int minl = Math.min(path1.size(), path2.size());
        minl = Math.min(minl, path3.size());
        BinaryTreeNode<Integer> lca = root;
        for (int i=1; i<minl; i++) {
            if (path1.get(i).data == path2.get(i).data && path2.get(i).data == path3.get(i).data) {
                lca = path1.get(i);
            }
        }
        return lca;
    }

    public static boolean getPath(BinaryTreeNode<Integer> root, int n, ArrayList<BinaryTreeNode<Integer>> path) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        path.add(root);
        if (root.data == n) {
            return true;
        } else {
            if (root.left != null) {
                if(getPath(root.left, n, path)) {
                    return true;
                }
            }
            if (root.right != null) {
                if(getPath(root.right, n, path)) {
                    return true;
                }
            }
            path.remove(path.size() - 1);
            return false;
        }
    }
}

/* Time complexity of O(N)
because we are traversing the tree in worst case in O(N)
and this traversal will happen for al the three nodes
so in total = O(3*N) = O(N)
 */