package test.on2017_03.on2017_03_18_VK_Cup_2017___Round_1.A___Bear_and_Friendship_Condition;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int a, b;
        for (int i = 0; i < m; i++) {
            a = in.nextInt() - 1;
            b = in.nextInt() - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int u;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                queue.offer(i);
                isVisited[i] = true;
                parent[i] = i;
                while (!queue.isEmpty()) {
                    u = queue.poll();
                    for (Integer v : adj[u]) {
                        if (!isVisited[v]) {
                            parent[v] = i;
                            queue.offer(v);
                            isVisited[v] = true;
                        }
                    }
                }
            }
        }

        int[] weight = new int[n];
        for (int i = 0; i < n; i++) weight[parent[i]]++;

        boolean isPossible = true;
        for (int i = 0; i < n; i++) {
            if (adj[i].size() < weight[parent[i]] - 1) {
                isPossible = false;
                break;
            }
        }

        out.print(isPossible ? "YES" : "NO");
    }
}
