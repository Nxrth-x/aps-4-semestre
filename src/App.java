import java.util.ArrayList;
import utils.benchmark.Benchmarker;
import utils.benchmark.IBenchmarkable;
import utils.sorting.algoritms.BubbleSort;
import utils.sorting.algoritms.QuickSort;
import utils.sorting.algoritms.RadixSort;

public class App {
  public static void main(String[] args) {
    var benchmarks = new ArrayList<IBenchmarkable>();

    var bubbleSort = Benchmarker.getBenchmark(new BubbleSort());
    var quickSort = Benchmarker.getBenchmark(new QuickSort());
    var radixSort = Benchmarker.getBenchmark(new RadixSort());

    benchmarks.add(bubbleSort);
    benchmarks.add(quickSort);
    benchmarks.add(radixSort);

    Benchmarker.execute(benchmarks, 1000000);
  }
}
