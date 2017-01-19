package test.on2017_01.on2017_01_05_Codeforces_Round__383__Div__2_.C___Arpa_s_loud_Owf_and_Mehrdad_s_evil_plan;



import lib.NumberTheory;
import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;

public class TaskC {
    int n;
    int[] crush;
    boolean[] isVisited, hasInEdge;
    HashSet<Integer> cycleLengths;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        crush = new int[n];
        hasInEdge = new boolean[n];
        isVisited = new boolean[n];
        cycleLengths = new HashSet<>();
        for (int i = 0; i < n; i++) {
            crush[i] = in.nextInt() - 1;
            hasInEdge[crush[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!hasInEdge[i]) {
                out.print(-1);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, 1);
            }
        }

        int[] lengths = new int[cycleLengths.size()];
        int index = 0;
        for (Integer length : cycleLengths) lengths[index++] = length;
        out.print(NumberTheory.lcm(lengths));
    }

    private void dfs(int u, int level) {
        isVisited[u] = true;
        if (!isVisited[crush[u]])
            dfs(crush[u], level + 1);
        else {
            cycleLengths.add(level % 2 == 0 ? level / 2 : level);
        }
    }
}
