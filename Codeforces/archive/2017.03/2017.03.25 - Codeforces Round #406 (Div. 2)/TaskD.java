package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class TaskD {
    List<Edge>[] adj;
    int offset1, offset2;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        int s = in.nextInt() - 1;

        int N = 9 * n;
        offset1 = n;
        offset2 = 5 * n;
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        buildTree(0, 0, n - 1);

        int t, u, v, w, l, r;
        for (int i = 0; i < q; i++) {
            t = in.nextInt();
            if (t == 1) {
                u = in.nextInt() - 1;
                v = in.nextInt() - 1;
                w = in.nextInt();
                adj[u].add(new Edge(v, w));
            } else {
                u = in.nextInt() - 1;
                l = in.nextInt() - 1;
                r = in.nextInt() - 1;
                w = in.nextInt();
                if (t == 2) addSecondPlanType(0, 0, n - 1, l, r, u, w);
                else addThirdPlanType(0, 0, n - 1, l, r, u, w);
            }
        }

        long[] distTo = new long[N];
        Arrays.fill(distTo, Long.MAX_VALUE);
        distTo[s] = 0;

        PriorityQueue<Vertex> priority = new PriorityQueue<>();
        priority.offer(new Vertex(s, 0));

        Vertex next;
        long nextDist;
        while (!priority.isEmpty()) {
            next = priority.poll();
            if (distTo[next.u] < next.distTo) continue;
            for (Edge e : adj[next.u]) {
                nextDist = (long) e.w + next.distTo;
                if (nextDist < distTo[e.v]) {
                    distTo[e.v] = nextDist;
                    priority.offer(new Vertex(e.v, nextDist));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) res.append(distTo[i] == Long.MAX_VALUE ? -1 : distTo[i]).append(" ");

        out.print(res);
    }

    private void buildTree(int index, int left, int right) {
        if (left == right) {
            adj[index + offset1].add(new Edge(left, 0));
            adj[left].add(new Edge(index + offset2, 0));
        }
        else {
            int mid = (left + right) >>> 1;
            adj[index + offset1].add(new Edge(index * 2 + 1 + offset1, 0));
            adj[index + offset1].add(new Edge(index * 2 + 2 + offset1, 0));
            adj[index * 2 + 1 + offset2].add(new Edge(index + offset2, 0));
            adj[index * 2 + 2 + offset2].add(new Edge(index + offset2, 0));
            buildTree(index * 2 + 1, left, mid);
            buildTree(index * 2 + 2, mid + 1, right);
        }
    }

    private void addSecondPlanType(int index, int treeLeft, int treeRight,
                                   int planLeft, int planRight, int u, int w) {
        if ((treeLeft > planRight) || (treeRight < planLeft)) return;
        if (treeLeft >= planLeft && treeRight <= planRight) adj[u].add(new Edge(offset1 + index, w));
        else {
            int mid = (treeLeft + treeRight) >>> 1;
            addSecondPlanType(index * 2 + 1, treeLeft, mid, planLeft, planRight, u, w);
            addSecondPlanType(index * 2 + 2, mid + 1, treeRight, planLeft, planRight, u, w);
        }
    }

    private void addThirdPlanType(int index, int treeLeft, int treeRight,
                                  int planLeft, int planRight, int v, int w) {
        if ((treeLeft > planRight) || (treeRight < planLeft)) return;
        if (treeLeft >= planLeft && treeRight <= planRight) adj[offset2 + index].add(new Edge(v, w));
        else {
            int mid = (treeLeft + treeRight) >>> 1;
            addThirdPlanType(index * 2 + 1, treeLeft, mid, planLeft, planRight, v, w);
            addThirdPlanType(index * 2 + 2, mid + 1, treeRight, planLeft, planRight, v, w);
        }
    }

    private static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static class Vertex implements Comparable<Vertex> {
        int u;
        long distTo;

        public Vertex(int u, long distTo) {
            this.u = u;
            this.distTo = distTo;
        }

        @Override
        public int compareTo(Vertex o) {
            return Long.compare(this.distTo, o.distTo);
        }
    }
}
