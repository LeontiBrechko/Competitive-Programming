package test.on2017_04.on2017_04_10_Codeforces_Round__408__Div__2_.D___Police_Stations;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayDeque;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int d = in.nextInt();
        ArrayDeque<Step> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) queue.offer(new Step(-1, in.nextInt() - 1));

        ArrayDeque<Road>[] adj = new ArrayDeque[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayDeque<>();

        int u, v;
        for (int i = 1; i < n; i++) {
            u = in.nextInt() - 1;
            v = in.nextInt() - 1;
            adj[u].add(new Road(i, v));
            adj[v].add(new Road(i, u));
        }

        ArrayDeque<Integer> toDelete = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        Step current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (isVisited[current.to]) continue;
            isVisited[current.to] = true;
            for (Road road : adj[current.to]) {
                if (road.to != current.from) {
                    if (isVisited[road.to]) toDelete.offer(road.index);
                    else queue.offer(new Step(current.to, road.to));
                }
            }
        }

        StringBuilder res = new StringBuilder(String.format("%d\n", toDelete.size()));
        for (Integer i : toDelete) res.append(i).append(" ");
        out.print(res);
    }

    private static class Road {
        int index;
        int to;

        public Road(int index, int to) {
            this.index = index;
            this.to = to;
        }
    }

    private static class Step {
        int from;
        int to;

        public Step(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
