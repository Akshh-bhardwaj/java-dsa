package dsa.sorting;

import java.util.Arrays;

public class SortingAlgorithms {

    // 1. Bubble Sort
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, array is already sorted
            if (!swapped) break;
        }
    }

    // 2. Selection Sort
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // swap minimum element with first unsorted element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // 3. Insertion Sort
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Shift elements that are greater than key forward
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // 4. Merge Sort
    // Time Complexity: O(N log N) | Space Complexity: O(N)
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSortHelper(arr, l, m);
            mergeSortHelper(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // 5. Quick Sort
    // Time Complexity: O(N log N) (Average), O(N^2) (Worst) | Space Complexity: O(log N) (call stack)
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i+1] and pivot (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println("--- Sorting Algorithms Test ---");
        int[] original = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Original array: " + Arrays.toString(original));

        // Test Bubble Sort
        int[] arr1 = original.clone();
        bubbleSort(arr1);
        System.out.println("Bubble Sorted:  " + Arrays.toString(arr1));

        // Test Selection Sort
        int[] arr2 = original.clone();
        selectionSort(arr2);
        System.out.println("Selection Sorted:" + Arrays.toString(arr2));

        // Test Insertion Sort
        int[] arr3 = original.clone();
        insertionSort(arr3);
        System.out.println("Insertion Sorted:" + Arrays.toString(arr3));

        // Test Merge Sort
        int[] arr4 = original.clone();
        mergeSort(arr4);
        System.out.println("Merge Sorted:    " + Arrays.toString(arr4));

        // Test Quick Sort
        int[] arr5 = original.clone();
        quickSort(arr5);
        System.out.println("Quick Sorted:    " + Arrays.toString(arr5));
    }
}
