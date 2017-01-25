package tasks;

import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();
        int resCount = 0;
        long resValue = 0;

        PriorityQueue<Integer> usb = new PriorityQueue<>();
        PriorityQueue<Integer> ps2 = new PriorityQueue<>();
        int v;
        String type;
        for (int i = 0; i < m; i++) {
            v = in.nextInt();
            type = in.next();
            if ("USB".equals(type)) usb.offer(v);
            else ps2.offer(v);
        }

        while (!usb.isEmpty() && a > 0) {
            a--;
            resCount++;
            resValue += (long) usb.poll();
        }

        while (!ps2.isEmpty() && b > 0) {
            b--;
            resCount++;
            resValue += (long) ps2.poll();
        }

        int nextUsbVal, nextPs2Val;
        while ((!usb.isEmpty() || !ps2.isEmpty()) && c > 0) {
            c--;
            resCount++;
            if (!usb.isEmpty() && !ps2.isEmpty()) {
                nextUsbVal = usb.peek();
                nextPs2Val = ps2.peek();
                if (nextUsbVal < nextPs2Val) resValue += (long) usb.poll();
                else resValue += (long) ps2.poll();
            } else if (!usb.isEmpty()) {
                resValue += (long) usb.poll();
            } else {
                resValue += (long) ps2.poll();
            }
        }

        out.printf("%d %d", resCount, resValue);
    }
}
