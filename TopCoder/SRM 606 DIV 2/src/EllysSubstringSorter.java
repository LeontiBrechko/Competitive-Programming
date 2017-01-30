import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class EllysSubstringSorter {

    public String getMin(String S, int L) {
        char[] nextSub;
        for (int i = 0; i + L <= S.length(); i++) {
            nextSub = S.substring(i, i + L).toCharArray();
            Arrays.sort(nextSub);
            for (int j = 0; j < L; j++) {
                if (nextSub[j] != S.charAt(i + j)) {
                    StringBuilder res = new StringBuilder(S.substring(0, i));
                    for (int k = 0; k < L; k++) res.append(nextSub[k]);
                    if (i + L < S.length()) res.append(S.substring(i + L, S.length()));
                    return res.toString();
                } else if (i + L != S.length()) break;
            }
        }
        return S;
    }
}
