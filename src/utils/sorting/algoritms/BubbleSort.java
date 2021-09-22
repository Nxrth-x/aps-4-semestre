package utils.sorting.algoritms;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort implements ISortableAlgorithm {
  public ArrayList<Integer> sort(ArrayList<Integer> list) {
    var sorted = new ArrayList<Integer>(list);
    boolean isSorted = false;

    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < sorted.size() - 1; i++) {
        if (sorted.get(i) > sorted.get(i + 1)) {
          Collections.swap(sorted, i, i + 1);
          isSorted = false;
        }
      }
    }

    return sorted;
  }
}
