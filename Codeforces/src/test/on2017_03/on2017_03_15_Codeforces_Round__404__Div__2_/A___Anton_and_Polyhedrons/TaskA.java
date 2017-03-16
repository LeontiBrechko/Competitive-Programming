package test.on2017_03.on2017_03_15_Codeforces_Round__404__Div__2_.A___Anton_and_Polyhedrons;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] count = new int[5];
        String next;
        for (int i = 0; i < n; i++) {
            next = in.next();
            switch (next) {
                case "Tetrahedron":
                    count[0]++;
                    break;
                case "Cube":
                    count[1]++;
                    break;
                case "Octahedron":
                    count[2]++;
                    break;
                case "Dodecahedron":
                    count[3]++;
                    break;
                case "Icosahedron":
                    count[4]++;
                    break;
            }
        }

        int res = count[0] * 4 + count[1] * 6 + count[2] * 8 + count[3] * 12 + count[4] * 20;
        out.print(res);
    }
}
