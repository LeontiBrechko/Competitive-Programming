package test.on2016_12.on2016_12_27_Codeforces_Round__389__Div__2__Rated__Based_on_Technocup_2017___Elimination_Round_3_.C___Santa_Claus_and_Robot;



import lib.util.InputReader;

import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        String protocol = in.next();
        int currentDirections = 0;
        int res = 1;
        int nextOppositeDirection;
        for (int i = 0; i < n; i++) {
            nextOppositeDirection = getDirectionInt(getOppositeDirection(protocol.charAt(i)));
            if ((currentDirections & nextOppositeDirection) != 0) {
                res++;
                currentDirections = 0;
            }
            currentDirections |= getDirectionInt(protocol.charAt(i));
        }
        out.print(res);
    }

    private int getDirectionInt(char direction) {
        switch (direction) {
            case 'L':
                return 0b1000;
            case 'U':
                return 0b0100;
            case 'R':
                return 0b0010;
            default:
                return 0b0001;
        }
    }

    private char getOppositeDirection(char direction) {
        switch (direction) {
            case 'L':
                return 'R';
            case 'U':
                return 'D';
            case 'R':
                return 'L';
            default:
                return 'U';
        }
    }
}
