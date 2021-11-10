package test;

import java.util.Arrays;
import java.util.ArrayList;

import sorting.algorithms.BubbleSort;
import sorting.algorithms.HeapSort;
import sorting.algorithms.ISortableAlgorithm;
import sorting.algorithms.MergeSort;
import sorting.algorithms.QuickSort;
import sorting.algorithms.RadixSort;

public class TestSuite {
  public static void main() {
    try {
      var algorithms = new ArrayList<>(Arrays.asList(new ISortableAlgorithm[] { new RadixSort(), new BubbleSort(),
          new QuickSort(), new MergeSort(), new HeapSort() }));

      for (var algorithm : algorithms) {
        TestImplementation.test(algorithm);
      }
    } catch (Exception error) {
      System.out.printf("Error, a test suite failed, error: %s", error.toString());
    }
  }
}
