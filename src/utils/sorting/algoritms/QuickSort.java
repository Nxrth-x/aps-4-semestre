package utils.sorting.algoritms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort implements ISortableAlgorithm {
  public ArrayList<Integer> sort(ArrayList<Integer> list) {
    var sorted = new ArrayList<Integer>(list);
    this.sort(sorted, 0, sorted.size() - 1);

    return sorted;
  }

  private void sort(ArrayList<Integer> list, int low, int high) {
    if (low < high + 1) {
      var partition = this.partition(list, low, high);
      sort(list, low, partition - 1);
      sort(list, partition + 1, high);
    }
  }

  private int getPivot(int low, int high) {
    var random = new Random();
    return random.nextInt((high - low) + 1) + low;
  }

  private int partition(ArrayList<Integer> list, int low, int high) {
    Collections.swap(list, low, this.getPivot(low, high));

    int border = low + 1;

    for (int i = border; i <= high; i++) {
      if (list.get(i) < list.get(low)) {
        Collections.swap(list, i, border++);
      }
    }

    Collections.swap(list, low, border - 1);
    return border - 1;
  }
}
