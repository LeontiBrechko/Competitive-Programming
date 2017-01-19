package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        int[] count = new int[4];
        HashMap<Character, Integer> charPos = new HashMap<>();
        count(0, charPos, s, count);
        count(1, charPos, s, count);
        count(2, charPos, s, count);
        count(3, charPos, s, count);
        out.printf("%d %d %d %d", count[charPos.get('R')], count[charPos.get('B')], count[charPos.get('Y')], count[charPos.get('G')]);
    }

    private void count(int start, HashMap<Character, Integer> charPos, String s, int[] count) {
        char next;
        for (int i = start; i < s.length(); i += 4) {
            next = s.charAt(i);
            if (next != '!') {
                if (!charPos.containsKey(next)) charPos.put(next, start);
            } else {
                count[start]++;
            }
        }
    }
}
