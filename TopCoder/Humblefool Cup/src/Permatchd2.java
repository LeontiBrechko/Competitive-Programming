import java.util.HashMap;

public class Permatchd2 {
    private boolean[] isVisited;
    private boolean[][] isCounted;
    private int n;
    private HashMap<Integer, Info> components;

    public int fix(String[] graph) {
        n = graph.length;
        isVisited = new boolean[n];
        isCounted = new boolean[n][n];
        components = new HashMap<>();
        int res;
        Info componentInfo;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                componentInfo = new Info();
                components.put(i, componentInfo);
                dfs(i, graph, componentInfo);
            }
        }
        boolean hasEven = false;
        for (Integer key : components.keySet()) {
            if (components.get(key).numberOfEdges % 2 == 0) {
                hasEven = true;
                break;
            }
        }
        if (hasEven) {
            res = 0;
            for (Integer key : components.keySet()) {
                if (components.get(key).numberOfEdges % 2 == 1) {
                    res++;
                }
            }
        } else {
            if (components.size() > 1)
                res = components.size();
            else {
                boolean isOk = false;
                out: for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i != j && !isCounted[i][j]) {
                            isOk = true;
                            break out;
                        }
                    }
                }
                res = isOk ? 1 : -1;
            }
        }
        return res;
    }

    private void dfs(int u, String[] graph, Info componentInfo) {
        isVisited[u] = true;
        for (int i = 0; i < n; i++) {
            if (graph[u].charAt(i) == 'Y') {
                if (!isCounted[i][u]) {
                    componentInfo.numberOfEdges++;
                    isCounted[i][u] = isCounted[u][i] = true;
                }
                if (!isVisited[i]) dfs(i, graph, componentInfo);
            }
        }
    }

    private static class Info {
        int spaceAvailable;
        int numberOfEdges;
    }
}
