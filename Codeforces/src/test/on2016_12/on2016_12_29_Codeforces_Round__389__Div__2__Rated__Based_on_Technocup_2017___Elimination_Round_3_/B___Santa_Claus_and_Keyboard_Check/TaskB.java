package test.on2016_12.on2016_12_29_Codeforces_Round__389__Div__2__Rated__Based_on_Technocup_2017___Elimination_Round_3_.B___Santa_Claus_and_Keyboard_Check;



import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String rightVersion = in.next();
        String resultVersion = in.next();
        int alp[] = new int[26];
        Arrays.fill(alp, -1);
        int k = 0;
        int nextResultChar, nextRightChar;
        for (int i = 0; i < resultVersion.length(); i++) {
            nextResultChar = resultVersion.charAt(i) - 'a';
            nextRightChar = rightVersion.charAt(i) - 'a';
            if (nextResultChar != nextRightChar) {
                if (alp[nextResultChar] == -1 && alp[nextRightChar] == -1) {
                    alp[nextResultChar] = nextRightChar;
                    alp[nextRightChar] = nextResultChar;
                    k++;
                } else if (alp[nextResultChar] != nextRightChar || alp[nextRightChar] != nextResultChar) {
                    k = -1;
                    break;
                }
            } else {
                if (alp[nextResultChar] == -1 && alp[nextRightChar] == -1) {
                    alp[nextResultChar] = nextRightChar;
                } else if (alp[nextResultChar] != nextRightChar) {
                    k = -1;
                    break;
                }
            }
        }
        out.println(k);
        if (k != -1) {
            for (int i = 0; i < 26; i++) {
                if (alp[i] != -1 && alp[i] != i) {
                    out.printf("%c %c\n", ((char) alp[i] + 'a'), ((char) alp[alp[i]] + 'a'));
                    alp[alp[i]] = -1;
                }
            }
        }
    }
}
