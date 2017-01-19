package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.next();
        int count[] = new int[5];
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
                default:
                    count[4]++;
                    break;
            }
        }

        boolean isPossible = n % 4 == 0;
        if (isPossible) {
            for (int i = 0; i < 4; i++) {
                if (count[i] > n / 4) {
                    isPossible = false;
                    break;
                }
            }
        }

        if (isPossible) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != '?') res.append(s.charAt(i));
                else {
                    if (count[0] < n / 4) {
                        res.append('A');
                        count[0]++;
                    } else if (count[1] < n / 4) {
                        res.append('C');
                        count[1]++;
                    } else if (count[2] < n / 4) {
                        res.append('G');
                        count[2]++;
                    } else res.append('T');
                }
            }
            out.print(res);
        } else out.print("===");
    }
}
