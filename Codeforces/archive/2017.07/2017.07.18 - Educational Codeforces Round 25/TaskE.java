package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.*;

@SuppressWarnings("Duplicates")
public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();

        int u, v;
        for (int i = 0; i < m; i++) {
            u = in.nextInt() - 1;
            v = in.nextInt() - 1;
            nodes[v].adj.add(u);
            nodes[u].outCount++;
        }

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nodes[i].outCount, new TreeSet<>());
            map.get(nodes[i].outCount).add(i);
        }

        TreeSet<Integer> nextTree;
        int[] label = new int[n];
        for (int i = n; i > 0; i--) {
            nextTree = map.get(0);
            u = nextTree.last();
            for (Integer next : nodes[u].adj) {
                map.get(nodes[next].outCount).remove(next);
                nodes[next].outCount--;
                map.putIfAbsent(nodes[next].outCount, new TreeSet<>());
                map.get(nodes[next].outCount).add(next);
            }
            nextTree.remove(u);
            label[u] = i;
        }
        StringBuilder res = new StringBuilder();
        for (int l : label) {
            res.append(l).append(' ');
        }
        out.print(res);
    }

    private static class Node {
        int outCount;
        ArrayList<Integer> adj;

        public Node() {
            outCount = 0;
            adj = new ArrayList<>();
        }
    }
}
