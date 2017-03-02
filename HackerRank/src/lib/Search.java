package lib;

public class Search {
    private Search() {}

    public static int upperBinarySearch(long[] array, int start, int finish, long key) {
        int low = start;
        int high = finish - 1;
        if (high < 0) return -1;
        while (low < high) {
            int mid = (low + high + 1) >>> 1;
            if (array[mid] <= key) low = mid;
            else high = mid - 1;
        }
        if (array[low] != key) {
            if (array[low] < key) low++;
            low = -(low + 1);
        }
        return low;
    }
}