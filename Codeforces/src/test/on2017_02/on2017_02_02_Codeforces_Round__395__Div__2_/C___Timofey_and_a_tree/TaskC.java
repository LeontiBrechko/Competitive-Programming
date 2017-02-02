package test.on2017_02.on2017_02_02_Codeforces_Round__395__Div__2_.C___Timofey_and_a_tree;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int u, v;
        for (int i = 0; i < n - 1; i++) {
            u = in.nextInt() - 1;
            v = in.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) c[i] = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (Integer j : adj[i]) {
                if (c[i] != c[j]) {
                    if (dfs(n, adj, c, i)) {
                        out.printf("YES\n%d", i + 1);
                        return;
                    } else if (dfs(n, adj, c, j)) {
                        out.printf("YES\n%d", j + 1);
                        return;
                    } else {
                        out.print("NO");
                        return;
                    }
                }
            }
        }

        out.print("YES\n1");
    }

    private boolean dfs(int n, ArrayList<Integer>[] adj, int[] c, int root) {
        boolean[] isVisited;
        ArrayDeque<Integer> stack;
        int u;

        for (Integer i : adj[root]) {
            isVisited = new boolean[n];
            stack = new ArrayDeque<>();
            isVisited[root] = true;
            isVisited[i] = true;
            stack.push(i);
            boolean isOk = true;
            while (!stack.isEmpty()) {
                if (!isOk) break;
                u = stack.poll();
                for (Integer v : adj[u]) {
                    if (!isVisited[v]) {
                        isOk = isOk && c[v] == c[i];
                        isVisited[v] = true;
                        stack.push(v);
                    }
                }
            }
            if (!isOk) return false;
        }
        return true;
    }
}
