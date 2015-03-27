import java.util.*;

public class MergeSort {

    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];
        for (int i = left; i <= mid; i++) {
            leftArray[i - left] = array[i];
        }
        for (int i = mid + 1; i <= right; i++) {
            rightArray[i - mid - 1] = array[i];
        }

        int leftPoint = 0;
        int rightPoint = 0;
        int m = left;

        while ((leftPoint < leftArray.length) && (rightPoint < rightArray.length)) {
            if (leftArray[leftPoint] < rightArray[rightPoint]) {
                array[m] = leftArray[leftPoint];
                leftPoint++;
            } else {
                array[m] = rightArray[rightPoint];
                rightPoint++;
            }
            m++;
        }

        while (leftPoint < leftArray.length) {
            array[m] = leftArray[leftPoint];
            leftPoint++;
            m++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {6, 78, 4, -1, 34, 45};
        mergeSort(array, 0, array.length -1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}