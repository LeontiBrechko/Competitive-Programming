import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class Cross {

    public String exist(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean hasCross = false;
        Out: for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                hasCross = true;
                out: for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (abs(k) == abs(l) && k != 0) continue;
                        hasCross = hasCross && board[i + k].charAt(j + l) == '#';
                        if (!hasCross) break out;
                    }
                }
                if (hasCross) break Out;
            }
        }
        return hasCross ? "Exist" : "Does not exist";
    }
}
