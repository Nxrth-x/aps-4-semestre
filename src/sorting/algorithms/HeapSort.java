package sorting.algorithms;

import java.util.Arrays;

public class HeapSort implements ISortableAlgorithm {
  public Integer[] sort(Integer[] source) {
    var cloned = Arrays.copyOf(source, source.length);
    sort(cloned, cloned.length);
    return cloned;
  }

  private void sort(Integer[] source, int length) {
    for (int i = length / 2 - 1; i >= 0; i--)
      heapSort(source, length, i);

    for (int i = length - 1; i > 0; i--) {
      int temp = source[0];

      source[0] = source[i];
      source[i] = temp;

      heapSort(source, i, 0);
    }
  }

  private void heapSort(Integer source[], int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && source[left] > source[largest])
      largest = left;

    if (right < n && source[right] > source[largest])
      largest = right;

    if (largest != i) {
      int swap = source[i];
      source[i] = source[largest];
      source[largest] = swap;
      heapSort(source, n, largest);
    }
  }

}
