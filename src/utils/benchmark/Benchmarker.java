package utils.benchmark;

import java.util.ArrayList;
import java.util.Random;

import sorting.algorithms.ISortableAlgorithm;
import utils.tuples.Pair;

public class Benchmarker {
  public static BenchmarkResult execute(ArrayList<BenchmarkableAlgorithm> benchmarks, int range) {
    var list = getRandomList(range);
    var results = new ArrayList<Pair<String, Double>>();

    for (BenchmarkableAlgorithm benchmark : benchmarks) {
      long start = System.nanoTime();
      benchmark.algorithm.call(list);
      long end = System.nanoTime();

      results.add(new Pair<>(benchmark.label, (double) (end - start) / 1_000_000_000));
    }

    return new BenchmarkResult(range, results);
  }

  private static Integer[] getRandomList(int range) {
    var random = new Random();
    var list = new Integer[range];

    for (int i = 0; i < range; i++) {
      list[i] = random.nextInt(1_000_000);
    }

    return list;
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
