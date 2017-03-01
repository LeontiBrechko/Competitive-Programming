package test.on2017_02.on2017_02_25_ICM_Technex_2017_and_Codeforces_Round__400__Div__1___Div__2__combined_.D___The_Door_Problem;



import lib.util.InputReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) rooms[i] = new Room(in.nextInt() == 1, -1, -1);
        int x;
        Room room;
        ArrayList<Room>[] adj = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            adj[i] = new ArrayList<>();
            x = in.nextInt();
            for (int j = 0; j < x; j++) {
                room = rooms[in.nextInt() - 1];
                if (room.u == -1) room.u = i;
                else room.v = i;
                adj[i].add(room);
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] switchColors = new int[m];
        int u, v;
        boolean isPossible = true;
        for (int i = 0; i < m; i++) {
            if (!isPossible) break;
            if (switchColors[i] == 0) {
                queue.offer(i);
                switchColors[i] = 1;
                out: while (!queue.isEmpty()) {
                    u = queue.poll();
                    for (Room r : adj[u]) {
                        v = r.getAnother(u);
                        if (switchColors[v] == 0) {
                            if (r.isOpened) switchColors[v] = switchColors[u];
                            else switchColors[v] = switchColors[u] == 1 ? -1 : 1;
                            queue.offer(v);
                        } else {
                            if ((r.isOpened && switchColors[u] != switchColors[v]) ||
                                    (!r.isOpened && switchColors[u] == switchColors[v])) {
                                isPossible = false;
                                break out;
                            }
                        }
                    }
                }
            }
        }

        out.print(isPossible ? "YES" : "NO");
    }

    private static class Room {
        boolean isOpened;
        int u;
        int v;

        public Room(boolean isOpened, int u, int v) {
            this.isOpened = isOpened;
            this.u = u;
            this.v = v;
        }

        int getAnother(int u) {
            return u == this.u ? this.v : this.u;
        }
    }
}
