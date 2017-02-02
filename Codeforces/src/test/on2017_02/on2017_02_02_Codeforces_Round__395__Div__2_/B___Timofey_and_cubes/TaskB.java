package test.on2017_02.on2017_02_02_Codeforces_Round__395__Div__2_.B___Timofey_and_cubes;



import lib.util.InputReader;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);

        int current = (n / 2) - 1;
        while (current >= 0) {
            if ((current + 1) % 2 == 1) swap(a, current, n - current - 1);
            current--;
        }

        for (int i : a) out.printf("%d ", i);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
