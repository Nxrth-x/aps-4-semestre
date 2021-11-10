package sorting.algorithms;

import java.util.Arrays;

public class RadixSort implements ISortableAlgorithm {
  public Integer[] sort(Integer[] source) {
    var cloned = Arrays.copyOf(source, source.length);
    sort(cloned, cloned.length);
    return cloned;
  }

  private int getMaximum(Integer[] source) {
    int maximum = source[0];

    for (int i = 1; i < source.length; i++) {
      if (source[i] > maximum)
        maximum = source[i];
    }

    return maximum;
  }

  private void countSort(Integer[] source, int length, int exp) {
    Integer[] output = new Integer[length];
    Integer[] count = new Integer[10];
    Arrays.fill(count, 0);

    for (int i = 0; i < length; i++) {
      count[(source[i] / exp) % 10]++;
    }

    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    for (int i = length - 1; i >= 0; i--) {

      output[count[(source[i] / exp) % 10] - 1] = source[i];
      count[(source[i] / exp) % 10]--;
    }

    for (int i = 0; i < length; i++) {
      source[i] = output[i];
    }

  }

  private void sort(Integer[] source, int length) {
    int maximum = getMaximum(source);

    for (int exp = 1; maximum / exp > 0; exp *= 10)
      countSort(source, length, exp);
  }
}