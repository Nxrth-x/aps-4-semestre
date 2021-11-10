package sorting.algorithms;

import java.util.Arrays;
import utils.arrays.ArrayUtils;

public class BubbleSort implements ISortableAlgorithm {
  public Integer[] sort(Integer[] list) {
    var cloned = Arrays.copyOf(list, list.length);

    boolean isSorted = false;

    while (!isSorted) {
      isSorted = true;

      for (int i = 0; i < cloned.length - 1; i++) {
        if (cloned[i] > cloned[i + 1]) {
          ArrayUtils.swap(cloned, i, i + 1);
          isSorted = false;
        }
      }
    }

    return cloned;
  }
}
