package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int x, y;
        for (int i = 1; i < n; i++) {
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;
            adj[x].add(y);
            adj[y].add(x);
        }

        int[] colors = new int[n];
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.offer(new State(0, 0));
        colors[0] = 1;

        int maxDegree = 0;
        for (int i = 0; i < n; i++) maxDegree = Math.max(maxDegree, adj[i].size());

        State u;
        int color;
        while (!queue.isEmpty()) {
            u = queue.poll();
            color = 1;
            for (Integer v : adj[u.index]) {
                if (colors[v] == 0) {
                    while (color == colors[u.index] || color == colors[u.parent])
                        color++;
                    colors[v] = color++;
                    queue.offer(new State(v, u.index));
                }
            }
        }

        out.println(maxDegree + 1);
        for (int i = 0; i < n; i++) {
            out.printf("%d ", colors[i]);
        }
    }

    private static class State {
        int index;
        int parent;

        public State(int index, int parent) {
            this.index = index;
            this.parent = parent;
        }
    }
}
