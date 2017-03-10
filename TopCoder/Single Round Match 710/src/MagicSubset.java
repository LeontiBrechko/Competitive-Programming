public class MagicSubset {

    public int findBest(int[] values) {
        int n = values.length;

        int negativeSum = 0;
        int positiveSum = 0;
        for (int i = 1; i < n; i++) {
            if (values[i] < 0) negativeSum += values[i];
            else positiveSum += values[i];
        }

        return Math.max(positiveSum, -(negativeSum + values[0]));
    }
}
