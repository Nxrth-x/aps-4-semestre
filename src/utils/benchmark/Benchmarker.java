package utils.benchmark;

import java.util.ArrayList;

import utils.sorting.algoritms.ISortableAlgorithm;

public class Benchmarker {
  public static void execute(ArrayList<IBenchmarkable> benchmarks, int range) {
    var times = new ArrayList<Long>();
    var list = new ArrayList<Integer>();

    for (int i = 0; i < range; i++)
      list.add(i);

    for (IBenchmarkable benchmark : benchmarks) {
      long start = System.nanoTime();
      benchmark.call(list);
      long end = System.nanoTime();
      times.add(end - start);
    }

    System.out.println("TIMES:" + times.toString());
  }

  public static IBenchmarkable getBenchmark(ISortableAlgorithm algorithm) {
    return Benchmarker.getBenchmark((list) -> {
      algorithm.sort(list);
    });
  }

  private static IBenchmarkable getBenchmark(IBenchmarkable benchmark) {
    return benchmark;
  }
}
