package sorting.algorithms;

import java.util.Arrays;

public class MergeSort implements ISortableAlgorithm {
  public Integer[] sort(Integer[] source) {
    var cloned = Arrays.copyOf(source, source.length);

    sort(cloned, cloned.length);

    return cloned;
  }

  public static void merge(Integer[] source, Integer[] leftArray, Integer[] rightArray, int left, int right) {
    int i = 0, j = 0, k = 0;

    while (i < left && j < right) {
      if (leftArray[i] <= rightArray[j]) {
        source[k++] = leftArray[i++];
      } else {
        source[k++] = rightArray[j++];
      }
    }
    while (i < left) {
      source[k++] = leftArray[i++];
    }
    while (j < right) {
      source[k++] = rightArray[j++];
    }
  }

  public static void sort(Integer[] source, int pivot) {
    if (pivot < 2) {
      return;
    }

    int mid = pivot / 2;
    Integer[] left = new Integer[mid];
    Integer[] right = new Integer[pivot - mid];

    for (int i = 0; i < mid; i++) {
      left[i] = source[i];
    }

    for (int i = mid; i < pivot; i++) {
      right[i - mid] = source[i];
    }

    sort(left, mid);
    sort(right, pivot - mid);
    merge(source, left, right, mid, pivot - mid);
  }
}
