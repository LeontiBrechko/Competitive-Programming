package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        String[] subs = new String[2000010];
        int length = 0;

        String next;
        int k;
        for (int i = 0; i < n; i++) {
            next = in.next();
            for (int j = in.nextInt(); j > 0; j--) {
                k = in.nextInt();
                length = Math.max(length, k + next.length() - 1);
                if (subs[k - 1] == null || subs[k - 1].length() < next.length()) subs[k - 1] = next;
            }
        }

        StringBuilder res = new StringBuilder();
        ArrayDeque<Class> queue = new ArrayDeque<>();
        Class nextClass;
        for (int i = 0; i < length; i++) {
            if (subs[i] != null) queue.offer(new Class(subs[i], i));

            nextClass = queue.peek();
            while (nextClass != null && nextClass.index + nextClass.s.length() - 1 < i) {
                queue.poll();
                nextClass = queue.peek();
            }

            if (nextClass == null) res.append("a");
            else res.append(nextClass.s.charAt(i - nextClass.index));
        }

        out.print(res);
    }

    private static class Class {
        String s;
        int index;

        public Class(String s, int index) {
            this.s = s;
            this.index = index;
        }
    }
}
