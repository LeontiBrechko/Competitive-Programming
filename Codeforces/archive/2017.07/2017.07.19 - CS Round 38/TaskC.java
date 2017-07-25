package tasks;

import lib.util.InputReader;

import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        boolean first, second;
        first = second = false;
        boolean isPossible = true;
        int[][] index = new int[2][2];
        index[0][0] = index[0][1] = index[1][0] = index[1][1] = -1;
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] - a[i - 1]) > k) {
                if (i < n - 1 && Math.abs(a[i] - a[i + 1]) > k) {
                    if (!first) {
                        index[0][0] = i;
                    } else if (!second) {
                        index[1][0] = i;
                    }
                    i++;
                } else {
                    if (!first) {
                        index[0][0] = i - 1;
                        index[0][1] = i;
                    } else if (!second) {
                        index[1][0] = i - 1;
                        index[1][1] = i;
                    }
                }

                if (!first) first = true;
                else if (!second) second = true;
                else isPossible = false;
            }
        }

        if (isPossible) {
            if (!first) {
                out.print(0);
                return;
            } else if (!second) {
                for (int idx : index[0]) {
                    for (int i = 0; i < n; i++) {
                        if (idx != -1 && idx != i) {
                            int temp = a[idx];
                            a[idx] = a[i];
                            a[i] = temp;

                            if ((idx <= 0 || Math.abs(a[idx - 1] - a[idx]) <= k) &&
                                    (idx >= n - 1 || Math.abs(a[idx + 1] - a[idx]) <= k) &&
                                    (i <= 0 || Math.abs(a[i - 1] - a[i]) <= k) &&
                                    (i >= n - 1 || Math.abs(a[i] - a[i + 1]) <= k)) {
                                out.printf("%d %d", idx + 1, i + 1);
                                return;
                            }

                            temp = a[idx];
                            a[idx] = a[i];
                            a[i] = temp;
                        }
                    }
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (index[0][i] != -1 && index[1][j] != -1) {
                            int temp = a[index[0][i]];
                            a[index[0][i]] = a[index[1][j]];
                            a[index[1][j]] = temp;
                            boolean isOk = true;
                            for (int l = 1; l < n; l++) {
                                if (Math.abs(a[l] - a[l - 1]) > k) {
                                    isOk = false;
                                    break;
                                }
                            }
                            if (isOk) {
                                out.printf("%d %d", index[0][i] + 1, index[1][j] + 1);
                                return;
                            }
                            temp = a[index[0][i]];
                            a[index[0][i]] = a[index[1][j]];
                            a[index[1][j]] = temp;
                        }
                    }
                }
            }

        }

        out.print(-1);
    }
}
