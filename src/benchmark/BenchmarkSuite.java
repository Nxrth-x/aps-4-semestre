package benchmark;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import sorting.algorithms.HeapSort;
import sorting.algorithms.MergeSort;
import sorting.algorithms.QuickSort;
import sorting.algorithms.RadixSort;
import utils.benchmark.BenchmarkableAlgorithm;
import utils.benchmark.Benchmarker;

public class BenchmarkSuite {
  public static void main() {
    var benchmarks = new ArrayList<BenchmarkableAlgorithm>();
    benchmarks.add(new BenchmarkableAlgorithm("quick_sort", Benchmarker.getBenchmark(new QuickSort())));
    benchmarks.add(new BenchmarkableAlgorithm("radix_sort", Benchmarker.getBenchmark(new RadixSort())));
    benchmarks.add(new BenchmarkableAlgorithm("merge_sort", Benchmarker.getBenchmark(new MergeSort())));
    benchmarks.add(new BenchmarkableAlgorithm("heap_sort", Benchmarker.getBenchmark(new HeapSort())));

    var ranges = new int[] { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000 };
    var results = new ArrayList<String>();

    for (int range : ranges) {
      var result = Benchmarker.execute(benchmarks, range);
      results.add(result.toJSON());
    }

    saveResultsToFile(results);
  }

  private static void saveResultsToFile(ArrayList<String> results) {
    try {
      var writer = new BufferedWriter(new FileWriter("results.json"));
      var parsed = "[" + String.join(",", results) + "]";
      writer.write(parsed);
      writer.close();
    } catch (Exception error) {
      System.out.printf("Could not write to file 'results.json', error: %s", error.toString());
    }
  }
}
