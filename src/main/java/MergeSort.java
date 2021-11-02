import java.util.Random;

public class MergeSort {
    private static void mergesort(double[] arr, int low, int high) {
        if (high - low > 0) {
            int mid = (low + high) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(double[] a, int left, int mid, int right) {
        double[] tmpLeft = new double[mid - left + 1];
        System.arraycopy(a, left, tmpLeft, 0, tmpLeft.length);
        int indexLeft = 0;
        int indexRight = mid + 1;
        int indexResult = left;
        while (indexLeft < tmpLeft.length && indexRight <= right) {
            if (tmpLeft[indexLeft] <= a[indexRight]) {
                a[indexResult] = tmpLeft[indexLeft];
                indexLeft++;
            } else {
                a[indexResult] = a[indexRight];
                indexRight++;
            }
            indexResult++;
        }
        while (indexLeft < tmpLeft.length) {
            a[indexResult] = tmpLeft[indexLeft];
            indexResult++;
            indexLeft++;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 100;
        double[] arr = new double[size];
        for (int i = 0; i<size; i++) arr[i] = random.nextDouble();
        mergesort(arr, 0, size-1);
        for (double elem : arr) System.out.println(elem);
    }
}
