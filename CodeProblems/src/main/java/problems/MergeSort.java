package problems;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        mergeSort(actual, actual.length);
    }
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Arrays.toString(a));

    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            System.out.println("i: " + i + ", j: " + j);
            System.out.println("k: " + k);
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            System.out.println("k: " + k);
            a[k++] = l[i++];
        }
        while (j < right) {
            System.out.println("j: " + j);
            a[k++] = r[j++];
        }

    }
}
