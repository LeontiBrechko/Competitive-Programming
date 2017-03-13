package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class TaskC {
    int n, k;
    int[] mandatoryCourses, color;
    ArrayList<Integer>[] adj;
    ArrayList<Integer> result;
    boolean isPossible;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        mandatoryCourses = new int[k];
        for (int i = 0; i < k; i++) mandatoryCourses[i] = in.nextInt() - 1;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int t;
        for (int i = 0; i < n; i++) {
            t = in.nextInt();
            while (t-- > 0) adj[i].add(in.nextInt() - 1);
        }

        color = new int[n];
        isPossible = true;
        result = new ArrayList<>();
        for (Integer course : mandatoryCourses) {
            if (!isPossible) break;
            if (color[course] == 0) {
                dfs(course);
            }
        }

        if (isPossible) {
            StringBuilder res = new StringBuilder();
            res.append(result.size()).append("\n");
            for (Integer course : result) res.append(course + 1).append(" ");
            out.print(res);
        } else out.print(-1);
    }

    private void dfs(int u) {
        if (!isPossible) return;
        color[u] = 1;
        for (Integer v : adj[u]) {
            if (!isPossible) return;
            if (color[v] == 0) {
                dfs(v);
            } else if (color[v] == 1) {
                isPossible = false;
                return;
            }
        }
        color[u] = 2;
        result.add(u);
    }
}
