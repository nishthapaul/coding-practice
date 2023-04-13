package InterviewBit.graphs.traversal;

import java.util.*;

public class PathInDirectedGraph_BFS {
    public static int solve(int n, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (ArrayList<Integer> al : B) {
            graph.get(al.get(0)).add(al.get(1));
        }
        for (ArrayList<Integer> al : graph) {
            System.out.println(al);
        }
        ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(n+1, false));
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited.set(1, true);
        while (!q.isEmpty()) {
            int front = q.poll();
            ArrayList<Integer> frontNeighbourList = graph.get(front);
            for (int neighbour : frontNeighbourList) {
                if (neighbour == n) {
                    return 1;
                }
                if (!visited.get(neighbour)) {
                    q.add(neighbour);
                    visited.set(neighbour, true);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(4, 1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4)));
        edges.add(new ArrayList<>(Arrays.asList(5, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(solve(5, edges));
    }
}

// https://www.interviewbit.com/problems/path-in-directed-graph/
/*
Given a directed path in between nodes 1 to n
Return 1 if there exists a path from 1 to n, 0 if no path exists
The graph can be disconnected also.
 */
